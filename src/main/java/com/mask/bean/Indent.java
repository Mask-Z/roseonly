package com.mask.bean;

import javax.persistence.*;

/**
 * Created by Mr丶周 on 2016/12/9.
 */
@Entity
public class Indent {
	private int id;
	private String address;
	private int state;
	private Double totalMoney;
	private String dealDetails;
	private User userByUserId;
	private Flower flowerByFlowerId;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "address", nullable = true, length = 50)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
	@Column(name = "state", nullable = false)
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Basic
	@Column(name = " total_money", nullable = true, precision = 0)
	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Basic
	@Column(name = "deal_details", nullable = true, length = 50)
	public String getDealDetails() {
		return dealDetails;
	}

	public void setDealDetails(String dealDetails) {
		this.dealDetails = dealDetails;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Indent indent = (Indent) o;

		if (id != indent.id) return false;
		if (state != indent.state) return false;
		if (address != null ? !address.equals(indent.address) : indent.address != null) return false;
		if (totalMoney != null ? !totalMoney.equals(indent.totalMoney) : indent.totalMoney != null) return false;
		if (dealDetails != null ? !dealDetails.equals(indent.dealDetails) : indent.dealDetails != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + state;
		result = 31 * result + (totalMoney != null ? totalMoney.hashCode() : 0);
		result = 31 * result + (dealDetails != null ? dealDetails.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	public User getUserByUserId() {
		return userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	@ManyToOne
	@JoinColumn(name = "flower_id", referencedColumnName = "id", nullable = false)
	public Flower getFlowerByFlowerId() {
		return flowerByFlowerId;
	}

	public void setFlowerByFlowerId(Flower flowerByFlowerId) {
		this.flowerByFlowerId = flowerByFlowerId;
	}
}
