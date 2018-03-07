package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.CategoryMapper;
import com.maven.tmall.mapper.ProductMapper;
import com.maven.tmall.pojo.Category;
import com.maven.tmall.pojo.Product;
import com.maven.tmall.pojo.ProductExample;
import com.maven.tmall.pojo.ProductImage;
import com.maven.tmall.service.ProductImageService;
import com.maven.tmall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductImageService productImageService;

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productMapper.insertSelective(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		Product product = productMapper.selectByPrimaryKey(id);
		setFirstProductImage(product);
		setCategory(product);
		return product;
	}

	private void setCategory(Product product) {
		// TODO Auto-generated method stub
		Category category = categoryMapper.selectByPrimaryKey(product.getCid());
		product.setCategory(category);
	}

	@Override
	public List list(int cid) {
		// TODO Auto-generated method stub
		ProductExample example = new ProductExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("id desc");
		List result = productMapper.selectByExample(example);
		setCateGory(result);
		setFirstProductImage(result);
		return result;
	}

	private void setCateGory(List<Product> products) {
		// TODO Auto-generated method stub
		for (Product product : products) {
			setCategory(product);
		}
	}

	@Override
	public void setFirstProductImage(Product product) {
		// TODO Auto-generated method stub
		List<ProductImage> pis = productImageService.list(product.getId(), ProductImageService.type_single);
		if (!pis.isEmpty()) {
			ProductImage pi = pis.get(0);
			product.setFirstProductImage(pi);
		}
	}

	public void setFirstProductImage(List<Product> products) {
		for (Product product : products) {
			setFirstProductImage(product);
		}
	}

}
