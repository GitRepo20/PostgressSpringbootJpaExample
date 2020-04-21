package com.example.demo.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.GlobalAutowiring;
import com.example.demo.model.Subscription;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	GlobalAutowiring globalAutowiring;
	@Autowired
	SessionFactory sessionFactory;
	
	/*private final String url = "jdbc:postgresql://localhost/postgrespoc";
    private final String user = "postgres";
    private final String password = "admin";*/
	
	@RequestMapping("/createuser")
	public void createUser() {
		try {
			
/*	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully."+conn);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }*/
			
			globalAutowiring.getUserService().createUser();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Hellow World...");
	}
	
	@RequestMapping("/createprofile")
	public void createProfile() {
		globalAutowiring.getUserService().createProfile();
	}
	
	@RequestMapping("/createprofilemovies")
	public void createProfileMovies() {
		globalAutowiring.getUserService().createProfileMovies();
		
	}
}
