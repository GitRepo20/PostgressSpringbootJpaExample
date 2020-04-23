package com.example.demo.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.GlobalAutowiring;
import com.example.demo.model.Movies;
import com.example.demo.model.Profile;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	GlobalAutowiring globalAutowiring;
	@Autowired
	SessionFactory sessionFactory;

	/*OneToOne User to Subscription*/
	@RequestMapping("/createuser")
	public void createUser() {
		try {
			globalAutowiring.getUserService().createUser();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*OneToMany User to Multiple Profile */
	@RequestMapping("/createprofile")
	public void createProfile() {
		try {
			globalAutowiring.getUserService().createProfile();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	/*ManyToMany Movies To Profile*/
	@RequestMapping("/createprofilemovies")
	public void createProfileMovies() {
		try {
			globalAutowiring.getUserService().createProfileMovies();			
		}catch(Exception e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 * OneToOne Relationship
	 * User to Subscription
	 */
	@PostMapping(path="/saveusersubscription")
	public User saveUserSubscription(@RequestBody User user) {
		
		User savedUser=null;
		try {
			savedUser = globalAutowiring.getUserService().saveUserSubscription(user);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedUser;		
	}
	
	/**
	 * OneToMany Relationship 
	 * User to Multiple Profile 
	 */
	@PostMapping(path="/saveuserprofile" , consumes= "application/json") 
	public User saveUserProfile(@RequestBody User user) {
		
		User savedUser=null;
		try {
			savedUser = globalAutowiring.getUserService().saveUserProfile(user);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedUser;		
	}
	
	@PostMapping(path="/savemoviesprofile/{id}" , consumes= "application/json") 
	public Movies saveMoviesProfile(@RequestBody Movies movies, @PathVariable Integer id) {
		
		Movies savedMovies=null;
		Integer userId=id;
		try {
			savedMovies = globalAutowiring.getUserService().saveProfileMovies(movies,id);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedMovies;		
	}
	
	@GetMapping(path="/getprofile/{id}")
	public Profile getProfile(@PathVariable Integer id) {
		
		try {
			return globalAutowiring.getUserService().getProfile(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
