package com.mask.bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mr丶周 on 2016/12/6.
 */
@Entity
public class User {
	private int id;
	private String name;
	private String number;
	private String gender;
	private String city;
	private Double account;
	private Collection<Cart> cartsById;
	private String password;
	private String realname;
	private int role;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "number", nullable = true, length = 20)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Basic
	@Column(name = "gender", nullable = true, length = 20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Basic
	@Column(name = "city", nullable = true, length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Basic
	@Column(name = "account", nullable = true, precision = 0)
	public Double getAccount() {
		return account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (number != null ? !number.equals(user.number) : user.number != null) return false;
		if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
		if (city != null ? !city.equals(user.city) : user.city != null) return false;
		if (account != null ? !account.equals(user.account) : user.account != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (number != null ? number.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (account != null ? account.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "userByUserId")
	public Collection<Cart> getCartsById() {
		return cartsById;
	}

	public void setCartsById(Collection<Cart> cartsById) {
		this.cartsById = cartsById;
	}

	@Basic
	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "realname", nullable = true, length = 20)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Basic
	@Column(name = "role", nullable = false)
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
