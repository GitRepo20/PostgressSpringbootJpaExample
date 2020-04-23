package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subscription_plan")
public class SubscriptionpPlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="code_name")
	private String codeName;
	
	@Column(name="pricing")
	private Integer pricing;
	
/*	@OneToOne(mappedBy="subscriptionPlan", cascade=CascadeType.ALL)
	private Subscription subscription;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Integer getPricing() {
		return pricing;
	}

	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}
		
}
