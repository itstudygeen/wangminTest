package com.ssm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.po.User;
import com.ssm.services.UserService;
@Service
public class UserServiceImp implements UserService {
    @Autowired
	private UserMapper userMapper;

	@Override
	public User loginByUser(User user) {
		
		return userMapper.loginByUser(user);
	}

	

}
