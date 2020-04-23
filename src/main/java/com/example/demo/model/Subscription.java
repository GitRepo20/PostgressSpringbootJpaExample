package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
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
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", user=" + user + "]";
	}
	
/*	public SubscriptionpPlan getSubscriptionPlan() {
		return subscriptionPlan;
	}
	public void setSubscriptionPlan(SubscriptionpPlan subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}*/
	
		
}
