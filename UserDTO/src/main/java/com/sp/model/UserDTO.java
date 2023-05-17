package com.sp.model;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
	private int idUser;
	private String username;
	private int wallet = 100;
	private Set<Integer> idList = new HashSet<Integer>();

	public UserDTO() {
		
	}

	public UserDTO(String username) {
		this.username=username;
	}

	// Getters and Setters //

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getWallet() {
		return wallet;
	}
	public Integer getId() {
		return idUser;
	}

	@Override
	public String toString() {
		return "Id:" + this.idUser + " Username ["+this.username+"]: Username:"+this.username+", Wallet:"+this.wallet;
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
