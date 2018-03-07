package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.ProductImageMapper;
import com.maven.tmall.pojo.ProductImage;
import com.maven.tmall.pojo.ProductImageExample;
import com.maven.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ProductImageMapper productImageMapper;

	@Override
	public void add(ProductImage productImage) {
		// TODO Auto-generated method stub
		productImageMapper.insertSelective(productImage);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productImageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(ProductImage productImage) {
		// TODO Auto-generated method stub
		productImageMapper.updateByPrimaryKeySelective(productImage);
	}

	@Override
	public ProductImage get(int id) {
		// TODO Auto-generated method stub
		return productImageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int pid, String type) {
		// TODO Auto-generated method stub
		ProductImageExample example = new ProductImageExample();
		example.createCriteria().andPidEqualTo(pid).andTypeEqualTo(type);
		example.setOrderByClause("id desc");
		return productImageMapper.selectByExample(example);
	}

}
