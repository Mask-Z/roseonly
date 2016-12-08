package com.mask.bean;

import javax.persistence.*;

/**
 * Created by Mr丶周 on 2016/12/8.
 */
@Entity
public class Flower {
	private int id;
	private int amount;
	private String name;
	private double price;
	private Cart cartByCartId;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "price", nullable = false, precision = 0)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Flower flower = (Flower) o;

		if (id != flower.id) return false;
		if (amount != flower.amount) return false;
		if (Double.compare(flower.price, price) != 0) return false;
		if (name != null ? !name.equals(flower.name) : flower.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id;
		result = 31 * result + amount;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
	public Cart getCartByCartId() {
		return cartByCartId;
	}

	public void setCartByCartId(Cart cartByCartId) {
		this.cartByCartId = cartByCartId;
	}
}
