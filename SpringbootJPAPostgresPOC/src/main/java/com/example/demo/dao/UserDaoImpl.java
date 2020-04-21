package com.example.demo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movies;
import com.example.demo.model.Profile;
import com.example.demo.model.Subscription;
import com.example.demo.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void createUser() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Subscription subscription=new Subscription();		
		subscription.setStartDate(new Date());
		subscription.setEndDate(new Date());

		User user=new User();		
		user.setFirstName("Santosh");
		user.setLastName("Jogade");
		user.setEmail("santoshj@gmail.com");
		user.setUsername("santoshj");
		user.setPassword("pwd@123");
		user.setCreatedOn(new Date());	
		user.setLastLogin(new Date());
		
		subscription.setUser(user);
		user.setSubscription(subscription);

		Serializable id1 = session.save(user);
		User savedUser = (User)session.get(User.class, id1);
		System.out.println(savedUser);
		System.out.println("ID : "+id1+" "+id1);
	}
	
	@Override
	public void createProfile() {
		
		Session session = sessionFactory.getCurrentSession();
		
		User user=new User();		
		user.setFirstName("Santosh1");
		user.setLastName("Jogade1");
		user.setEmail("santoshj1@gmail.com");
		user.setUsername("santoshj1");
		user.setPassword("1pwd@123");
		user.setCreatedOn(new Date());	
		user.setLastLogin(new Date());
		
		//User user = (User)session.get(User.class, 18);
		/*User user=new User();
		user.setId(18);*/
		
		List<Profile> profileList=new ArrayList<Profile>();
		Profile profile1=new Profile();
		Profile profile2=new Profile();		
		
		profile1.setProfileName("profile14");
		profile1.setUser(user);
		profile2.setProfileName("profile15");
		profile2.setUser(user);
		
		profileList.add(profile1);
		profileList.add(profile2);
	//	user.setProfile(profileList);
		
		session.save(profile1);
		session.save(profile2);
		System.out.println();
		User savedUsers = (User)session.get(User.class, 18);
		System.out.println();
		//System.out.println("Saved User : "+ savedUsers);		
	}
	
	@Override
	@Transactional
	public void createProfileMovies() {
		
		Set<Profile> profileList=new HashSet<Profile>();		
		
		Movies movie1=new Movies();
		movie1.setMovieName("movie1");
		movie1.setReleaseDate(new Date());
		
		Profile profile1=new Profile();
		profile1.setProfileName("profile21");
		User user1=new User();
		user1.setId(1);
		profile1.setUser(user1);
				
		Profile profile2=new Profile();		
		profile2.setProfileName("profile22");		
		profile2.setUser(user1);
		
		profileList.add(profile1);
		profileList.add(profile2);		
				
		movie1.setProfiles(profileList);
		profile1.getMovies().add(movie1);
		profile2.getMovies().add(movie1);
		

		Session session = sessionFactory.getCurrentSession();
		//Serializable id1 = session.save(profile1);
		Serializable id2 = session.save(movie1);
//		session.close();
	/*	Serializable id2 = session.save(movie1);
		System.out.println("ID1 = "+id1+" ID2 = "+id2 );*/		
	}
	
}
