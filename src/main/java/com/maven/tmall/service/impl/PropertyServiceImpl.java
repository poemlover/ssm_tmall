package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.PropertyMapper;
import com.maven.tmall.pojo.Property;
import com.maven.tmall.pojo.PropertyExample;
import com.maven.tmall.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyMapper propertyMapper;

	@Override
	public void add(Property property) {
		// TODO Auto-generated method stub
		propertyMapper.insertSelective(property);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		propertyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Property property) {
		// TODO Auto-generated method stub
		propertyMapper.updateByPrimaryKeySelective(property);
	}

	@Override
	public Property get(int id) {
		// TODO Auto-generated method stub
		return propertyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int cid) {
		// TODO Auto-generated method stub
		PropertyExample example = new PropertyExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("id desc");
		return propertyMapper.selectByExample(example);
	}

}
