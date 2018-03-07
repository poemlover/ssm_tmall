package com.maven.tmall.service;

import java.util.List;

import com.maven.tmall.pojo.Category;

public interface CategoryService {

	public List<Category> list();

	//public int total();

	public void add(Category category);

	public void delete(int id);

	public Category get(int id);

	public void update(Category c);

	
}
