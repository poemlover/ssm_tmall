package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.PropertyValueMapper;
import com.maven.tmall.pojo.Product;
import com.maven.tmall.pojo.Property;
import com.maven.tmall.pojo.PropertyValue;
import com.maven.tmall.pojo.PropertyValueExample;
import com.maven.tmall.service.PropertyService;
import com.maven.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

	@Autowired
	private PropertyValueMapper propertyValueMapper;

	@Autowired
	private PropertyService propertyService;

	/**
	 * 3.1 这个方法的作用是初始化PropertyValue。 为什么要初始化呢？ 因为对于PropertyValue的管理，没有增加，只有修改。
	 * 所以需要通过初始化来进行自动地增加，以便于后面的修改。 3.2 首先根据产品获取分类，然后获取这个分类下的所有属性集合 3.3
	 * 然后用属性和id产品id去查询，看看这个属性和这个产品，是否已经存在属性值了。 3.4
	 * 如果不存在，那么就创建一个属性值，并设置其属性和产品，接着插入到数据库中。这样就完成了属性值的初始化。
	 */
	@Override
	public void init(Product product) {
		// TODO Auto-generated method stub
		List<Property> productProperties = propertyService.list(product.getCid());

		for (Property pt : productProperties) {
			PropertyValue pv = get(pt.getId(), product.getId());
			if (null == pv) {
				pv = new PropertyValue();
				pv.setPid(product.getId());
				pv.setPtid(pt.getId());
				propertyValueMapper.insertSelective(pv);
			}
		}
	}

	@Override
	public void update(PropertyValue propertyValue) {
		// TODO Auto-generated method stub
		propertyValueMapper.updateByPrimaryKeySelective(propertyValue);
	}

	/**
	 * 根据属性id和产品id获取PropertyValue对象
	 */
	@Override
	public PropertyValue get(int ptid, int pid) {
		// TODO Auto-generated method stub
		PropertyValueExample example = new PropertyValueExample();
		example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
		List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
		if (pvs.isEmpty()) {
			return null;
		}
		return pvs.get(0);
	}

	/**
	 * 根据产品id获取所有的属性值
	 */
	@Override
	public List<PropertyValue> list(int pid) {
		// TODO Auto-generated method stub
		PropertyValueExample example = new PropertyValueExample();
		example.createCriteria().andPidEqualTo(pid);
		List<PropertyValue> result = propertyValueMapper.selectByExample(example);
		for (PropertyValue pv : result) {
			Property property = propertyService.get(pv.getPtid());
			pv.setProperty(property);
		}
		return result;
	}

}
