package com.maven.tmall.service;

import java.util.List;

import com.maven.tmall.pojo.Product;
import com.maven.tmall.pojo.PropertyValue;

public interface PropertyValueService {
	
	public void init(Product product);
	
	public void update(PropertyValue propertyValue);
	
	public PropertyValue get(int ptid, int pid);
	
	public List<PropertyValue> list(int pid);

}
