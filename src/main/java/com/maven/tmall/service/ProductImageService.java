package com.maven.tmall.service;

import java.util.List;

import com.maven.tmall.pojo.ProductImage;

public interface ProductImageService {

	public String type_single = "type_single";

	public String type_detail = "type_detail";

	public void add(ProductImage productImage);

	public void delete(int id);

	public void update(ProductImage productImage);

	public ProductImage get(int id);

	public List list(int pid, String type);

}
