package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.OrderItemMapper;
import com.maven.tmall.pojo.Order;
import com.maven.tmall.pojo.OrderItem;
import com.maven.tmall.pojo.OrderItemExample;
import com.maven.tmall.pojo.Product;
import com.maven.tmall.service.OrderItemService;
import com.maven.tmall.service.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private ProductService productService;

	@Override
	public void add(OrderItem c) {
		// TODO Auto-generated method stub
		orderItemMapper.insertSelective(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		orderItemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(OrderItem c) {
		// TODO Auto-generated method stub
		orderItemMapper.updateByPrimaryKeySelective(c);
	}

	private void setProduct(OrderItem oi) {
		Product p = productService.get(oi.getPid());
		oi.setProduct(p);
	}

	@Override
	public OrderItem get(int id) {
		// TODO Auto-generated method stub
		OrderItem result = orderItemMapper.selectByPrimaryKey(id);
		setProduct(result);
		return result;
	}

	@Override
	public List<OrderItem> list() {
		// TODO Auto-generated method stub
		OrderItemExample example = new OrderItemExample();
		example.setOrderByClause("id desc");
		return orderItemMapper.selectByExample(example);
	}

	@Override
	public void fill(List<Order> os) {
		// TODO Auto-generated method stub
		for (Order o : os) {
			fill(o);
		}
	}

	@Override
	public void fill(Order o) {
		// TODO Auto-generated method stub
		OrderItemExample example = new OrderItemExample();
		example.createCriteria().andOidEqualTo(o.getId());
		example.setOrderByClause("id desc");
		List<OrderItem> ois = orderItemMapper.selectByExample(example);
		setProduct(ois);

		float total = 0;
		int totalNumber = 0;
		for (OrderItem oi : ois) {
			total += oi.getNumber() * oi.getProduct().getPromotePrice();
			totalNumber += oi.getNumber();
		}

		o.setTotal(total);
		o.setTotalNumber(totalNumber);
		o.setOrderItems(ois);

	}

	private void setProduct(List<OrderItem> ois) {
		// TODO Auto-generated method stub
		for (OrderItem oi : ois) {
			setProduct(oi);
		}
	}

}
