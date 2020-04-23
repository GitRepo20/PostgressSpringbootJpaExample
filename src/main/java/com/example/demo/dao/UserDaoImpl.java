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
	public User saveUserSubscription(User user) {
		
		User savedUser=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Serializable id = session.save(user);
			User persistedUser = (User)session.get(User.class, id);	
			savedUser = persistedUser;
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedUser;
	}
	
	@Override
	public User saveUserProfile(User user) {
		
		User savedUser=null;
		try {
			Session session = sessionFactory.getCurrentSession();			
			Serializable id = session.save(user);
			User persistedUser = (User)session.get(User.class, id);	
			savedUser = persistedUser;
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return savedUser;
	}
	
	public Movies saveProfileMovies(Movies movies) {

		Movies persistedMovie = null;
		try {
			Session session = sessionFactory.getCurrentSession();			
			Serializable id = session.save(movies);
			persistedMovie = (Movies)session.get(Movies.class, id);				
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return persistedMovie;
	
	}
	
	public Profile getProfile(Integer id) {
		Profile persistedProfile = null;
		Profile profile = new Profile();
		Set<Movies> moviesList=new HashSet<Movies>();
		Movies moviedto=null;
		try {
			Session session = sessionFactory.getCurrentSession();			
			persistedProfile = (Profile) session.get(Profile.class,id);	
			
			for(Movies movie: persistedProfile.getMovies() ) {
				moviedto=new Movies();
				moviedto.setId(movie.getId());
				moviedto.setMovieName(movie.getMovieName());
				moviedto.setReleaseDate(movie.getReleaseDate());
				moviesList.add(moviedto);
			}
			
			profile.setId(persistedProfile.getId());
			profile.setProfileName(persistedProfile.getProfileName());
			profile.setMovies(moviesList);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return profile;	
	}
	
	
	@Override
	public void createUser() {
	
		try {
			
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
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	@Override
	public void createProfile() {

		try {	
		User user=new User();		
		user.setFirstName("Santosh1");
		user.setLastName("Jogade1");
		user.setEmail("santoshj1@gmail.com");
		user.setUsername("santoshj1");
		user.setPassword("1pwd@123");
		user.setCreatedOn(new Date());	
		user.setLastLogin(new Date());
		
		List<Profile> profileList=new ArrayList<Profile>();
		Profile profile1=new Profile();
		Profile profile2=new Profile();		
		
		profile1.setProfileName("profile14");
		profile1.setUser(user);
		profile2.setProfileName("profile15");
		profile2.setUser(user);
		
		profileList.add(profile1);
		profileList.add(profile2);
		user.setProfile(profileList);
			
		Session session = sessionFactory.getCurrentSession();			
		Serializable id=session.save(user);
		User u = (User) session.get(User.class, id);
//		System.out.println(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Override
	@Transactional
	public void createProfileMovies() {
	
		try {
		
		Set<Profile> profileList=new HashSet<Profile>();		
		
		Movies movie1=new Movies();
		movie1.setMovieName("movie1");
		movie1.setReleaseDate(new Date());
	
		Movies movie2=new Movies();
		movie2.setMovieName("movie2");
		movie2.setReleaseDate(new Date());
		
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
		movie2.setProfiles(profileList);
		
		profile1.getMovies().add(movie1);
		profile1.getMovies().add(movie2);
		profile2.getMovies().add(movie1);
		profile2.getMovies().add(movie2);

		Session session = sessionFactory.getCurrentSession();
		Serializable id2 = session.save(movie1);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
}
