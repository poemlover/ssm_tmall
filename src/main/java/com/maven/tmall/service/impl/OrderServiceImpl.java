package com.maven.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.tmall.mapper.OrderMapper;
import com.maven.tmall.pojo.Order;
import com.maven.tmall.pojo.OrderExample;
import com.maven.tmall.pojo.User;
import com.maven.tmall.service.OrderService;
import com.maven.tmall.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserService userService;

	@Override
	public void add(Order c) {
		// TODO Auto-generated method stub
		orderMapper.insertSelective(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Order c) {
		// TODO Auto-generated method stub
		orderMapper.updateByPrimaryKeySelective(c);
	}

	@Override
	public Order get(int id) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		OrderExample example = new OrderExample();
		example.setOrderByClause("id desc");
		List<Order> result = orderMapper.selectByExample(example);
		setUser(result);
		return result;
	}

	private void setUser(List<Order> os) {
		// TODO Auto-generated method stub
		for (Order o : os) {
			setUser(o);
		}
	}

	public void setUser(Order order) {
		int uid = order.getUid();
		User user = userService.get(uid);
		order.setUser(user);
	}

}
