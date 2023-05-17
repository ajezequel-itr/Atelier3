package com.sp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDB {
	@Id
	@GeneratedValue
	private int idUser;
	private String username;
	private String password;
	private int wallet = 100;
	@ElementCollection
	private Set<Integer> idList = new HashSet<Integer>();


	public UserDB() {}

	public UserDB(String username,String password) {
		this.username=username;
		this.password = password;
		//this.wallet = 100;
	}

	// Getters and Setters //

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWallet() {
		return wallet;
	}
	public Integer getId() {
		return idUser;
	}

	@Override
	public String toString() {
		return "Id:" + this.idUser + " Username ["+this.username+"]: Username:"+this.username+", Password:"+this.password+", Wallet:"+this.wallet;
	}


	public Iterable<Integer> getIdList() {
		return idList;
	}

	public void setIdList(Set<Integer> idList) {
		this.idList = idList;
	}

	public void setId(Integer id) {
		this.idUser = id;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}


}
