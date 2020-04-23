package com.example.demo.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Movies;
import com.example.demo.model.Profile;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public void createUser() {
		try {
			userdao.createUser();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void createProfile() {
		try {
			userdao.createProfile();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createProfileMovies() {
		try {
			userdao.createProfileMovies();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User saveUserSubscription(User user) {
		try {
			user.getSubscription().setUser(user);
			return userdao.saveUserSubscription(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User saveUserProfile(User user) {
		try {
			
			user.getProfile().forEach(profile -> { profile.setUser(user);});
			return userdao.saveUserProfile(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;			
	}

	@Override
	public Movies saveProfileMovies(Movies movies,Integer id) {
		try {
						
			User user=new User();
			user.setId(id);
			
			movies.getProfiles().forEach(profile -> { 
				profile.getMovies().add(movies);
				profile.setUser(user);
				});
			return userdao.saveProfileMovies(movies);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;			
	}
	
	public Profile getProfile(Integer id) {
		
		try {
			return userdao.getProfile(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
