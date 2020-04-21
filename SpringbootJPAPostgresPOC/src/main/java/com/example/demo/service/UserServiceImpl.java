package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public void createUser() {
		userdao.createUser();
	}
	
	@Override
	public void createProfile() {
		userdao.createProfile();
	}

	@Override
	public void createProfileMovies() {
		userdao.createProfileMovies();
	}

}
