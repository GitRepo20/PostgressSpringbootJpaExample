package com.example.demo.dao;

import com.example.demo.model.Movies;
import com.example.demo.model.Profile;
import com.example.demo.model.User;

public interface UserDao {
	public void createUser();
	public void createProfile();
	public void createProfileMovies();
	
	public User saveUserSubscription(User user);
	public User saveUserProfile(User user);
	public Movies saveProfileMovies(Movies movies);
	
	public Profile getProfile(Integer id);
}
