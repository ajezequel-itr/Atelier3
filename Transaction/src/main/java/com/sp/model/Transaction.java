package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private int lastId = 0;
	private int id;
	private int idBuyer;
	private int idSeller;
	private int value;
	private String date;
	
	public Transaction() {
	}

	public Transaction(int idBuyer, int idSeller, int value, String date) {
		lastId++;
		this.id=lastId;
		this.idBuyer = idBuyer;
		this.idSeller = idSeller;
		this.value = value;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(int idAcheteur) {
		this.idBuyer = idAcheteur;
	}

	public int getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(int idSeller) {
		this.idSeller = idSeller;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TRANSACTION ["+this.id+"]: Buyer:"+this.idBuyer+", Seller:"+this.idSeller+", Value:"+this.value+" Date:"+this.date;
	}
}
