package com.maven.tmall.service;

import java.util.List;

import com.maven.tmall.pojo.Property;

public interface PropertyService {

	public void add(Property property);

	public void delete(int id);

	public void update(Property property);

	public Property get(int id);

	public List list(int cid);

}
