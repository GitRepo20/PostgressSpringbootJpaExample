package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="subscription")
public class Subscription {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	@Temporal(TemporalType.TIMESTAMP)@Column(name="start_date")
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)@Column(name="end_date")
	private Date endDate;
	
//	@OneToOne @JoinColumn(name="user_id")
//	private User user;	
//	
/*	@OneToOne(mappedBy="subscription", cascade = CascadeType.ALL)
	private User user;*/
	
	/*
	@OneToOne @JoinColumn(name="subscription_plan_id")
	private SubscriptionpPlan subscriptionPlan; 
	*/
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
/*	public SubscriptionpPlan getSubscriptionPlan() {
		return subscriptionPlan;
	}
	public void setSubscriptionPlan(SubscriptionpPlan subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}*/
	
		
}
