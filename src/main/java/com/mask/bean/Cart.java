package com.mask.bean;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Mr丶周 on 2016/12/10.
 */
@Entity
public class Cart {
	private String goods;
	private Integer amount;
	private Date addtime;
	private User userByUserId;
	private Collection<Flower> flowersById;
	private int id;

	public void setAddtime(java.sql.Date addtime) {
		this.addtime = addtime;
	}

	@Basic
	@Column(name = "goods", nullable = true, length = 50)
	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	@Basic
	@Column(name = "amount", nullable = true)
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Basic
	@Column(name = "addtime", nullable = true)
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cart cart = (Cart) o;

		if (goods != null ? !goods.equals(cart.goods) : cart.goods != null) return false;
		if (amount != null ? !amount.equals(cart.amount) : cart.amount != null) return false;
		if (addtime != null ? !addtime.equals(cart.addtime) : cart.addtime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = goods != null ? goods.hashCode() : 0;
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		result = 31 * result + (addtime != null ? addtime.hashCode() : 0);
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

	@OneToMany(mappedBy = "cartByCartId")
	public Collection<Flower> getFlowersById() {
		return flowersById;
	}

	public void setFlowersById(Collection<Flower> flowersById) {
		this.flowersById = flowersById;
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
