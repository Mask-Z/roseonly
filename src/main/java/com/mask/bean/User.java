package com.mask.bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mr丶周 on 2016/12/10.
 */
@Entity
public class User {
	private String name;
	private String password;
	private String realname;
	private Integer role;
	private String number;
	private String gender;
	private String city;
	private Double account;
	private Collection<Cart> cartsById;
	private Collection<Indent> indentsById;
	private int id;

	@Basic
	@Column(name = "name", nullable = true, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "password", nullable = true, length = 20)
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
	@Column(name = "role", nullable = true)
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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

		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (realname != null ? !realname.equals(user.realname) : user.realname != null) return false;
		if (role != null ? !role.equals(user.role) : user.role != null) return false;
		if (number != null ? !number.equals(user.number) : user.number != null) return false;
		if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
		if (city != null ? !city.equals(user.city) : user.city != null) return false;
		if (account != null ? !account.equals(user.account) : user.account != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (realname != null ? realname.hashCode() : 0);
		result = 31 * result + (role != null ? role.hashCode() : 0);
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

	@OneToMany(mappedBy = "userByUserId")
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
