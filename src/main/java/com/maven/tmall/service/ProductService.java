package com.maven.tmall.service;

import java.util.List;

import com.maven.tmall.pojo.Product;

public interface ProductService {

	public void add(Product product);

	public void delete(int id);

	public void update(Product product);

	public Product get(int id);

	public List list(int cid);

	public void setFirstProductImage(Product product);

}
