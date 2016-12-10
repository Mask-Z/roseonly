package com.mask.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mr丶周 on 2016/12/10.
 */
@Entity
public class Indent {
	private String address;
	private Integer state;
	private Double totalMoney;
	private String dealDetails;
	private Integer postStyle;
	private Integer payStyle;
	private Integer payState;
	private Date payDate;
	private User userByUserId;
	private Flower flowerByFlowerId;
	private int id;

	public void setPayDate(java.sql.Date payDate) {
		this.payDate = payDate;
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
	@Column(name = "state", nullable = true)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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

	@Basic
	@Column(name = "post_style", nullable = true)
	public Integer getPostStyle() {
		return postStyle;
	}

	public void setPostStyle(Integer postStyle) {
		this.postStyle = postStyle;
	}

	@Basic
	@Column(name = "pay_style", nullable = true)
	public Integer getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(Integer payStyle) {
		this.payStyle = payStyle;
	}

	@Basic
	@Column(name = "pay_state", nullable = true)
	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	@Basic
	@Column(name = "pay_date", nullable = true)
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Indent indent = (Indent) o;

		if (address != null ? !address.equals(indent.address) : indent.address != null) return false;
		if (state != null ? !state.equals(indent.state) : indent.state != null) return false;
		if (totalMoney != null ? !totalMoney.equals(indent.totalMoney) : indent.totalMoney != null) return false;
		if (dealDetails != null ? !dealDetails.equals(indent.dealDetails) : indent.dealDetails != null) return false;
		if (postStyle != null ? !postStyle.equals(indent.postStyle) : indent.postStyle != null) return false;
		if (payStyle != null ? !payStyle.equals(indent.payStyle) : indent.payStyle != null) return false;
		if (payState != null ? !payState.equals(indent.payState) : indent.payState != null) return false;
		if (payDate != null ? !payDate.equals(indent.payDate) : indent.payDate != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = address != null ? address.hashCode() : 0;
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (totalMoney != null ? totalMoney.hashCode() : 0);
		result = 31 * result + (dealDetails != null ? dealDetails.hashCode() : 0);
		result = 31 * result + (postStyle != null ? postStyle.hashCode() : 0);
		result = 31 * result + (payStyle != null ? payStyle.hashCode() : 0);
		result = 31 * result + (payState != null ? payState.hashCode() : 0);
		result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	public User getUserByUserId() {
		return userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	@ManyToOne
	@JoinColumn(name = "flower_id", referencedColumnName = "id")
	public Flower getFlowerByFlowerId() {
		return flowerByFlowerId;
	}

	public void setFlowerByFlowerId(Flower flowerByFlowerId) {
		this.flowerByFlowerId = flowerByFlowerId;
	}

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
