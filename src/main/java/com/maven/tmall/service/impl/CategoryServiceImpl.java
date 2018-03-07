package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.CategoryMapper;
import com.maven.tmall.pojo.Category;
import com.maven.tmall.pojo.CategoryExample;
import com.maven.tmall.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> list() {
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id desc");
		return categoryMapper.selectByExample(example);
	}

	@Override
	public void add(Category category) {
		categoryMapper.insertSelective(category);
	}

	@Override
	public void delete(int id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category get(int id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
		
	}

	

}
