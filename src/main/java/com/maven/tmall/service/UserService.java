package com.maven.tmall.service;

import java.util.List;

import com.maven.tmall.pojo.User;

public interface UserService {

	public void add(User user);

	public void delete(int id);

	public void update(User user);

	public User get(int id);

	public List list();

}
