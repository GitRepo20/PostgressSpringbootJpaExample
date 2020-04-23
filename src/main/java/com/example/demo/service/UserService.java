package com.example.demo.service;

import com.example.demo.model.Movies;
import com.example.demo.model.Profile;
import com.example.demo.model.User;

public interface UserService {

	public void createUser();
	public void createProfile();
	public void createProfileMovies();
	
	public User saveUserSubscription(User user);
	public User saveUserProfile(User user);
	public Movies saveProfileMovies(Movies user,Integer id);
	
	public Profile getProfile(Integer id);
}
