package com.mask.bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mr丶周 on 2016/12/10.
 */
@Entity
public class Flower {
	private Integer amount;
	private String name;
	private Double price;
	private Cart cartByCartId;
	private Collection<Indent> indentsById;
	private int id;

	@Basic
	@Column(name = "amount", nullable = true)
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "price", nullable = true, precision = 0)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Flower flower = (Flower) o;

		if (amount != null ? !amount.equals(flower.amount) : flower.amount != null) return false;
		if (name != null ? !name.equals(flower.name) : flower.name != null) return false;
		if (price != null ? !price.equals(flower.price) : flower.price != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = amount != null ? amount.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "id")
	public Cart getCartByCartId() {
		return cartByCartId;
	}

	public void setCartByCartId(Cart cartByCartId) {
		this.cartByCartId = cartByCartId;
	}

	@OneToMany(mappedBy = "flowerByFlowerId")
	public Collection<Indent> getIndentsById() {
		return indentsById;
	}

	public void setIndentsById(Collection<Indent> indentsById) {
		this.indentsById = indentsById;
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
