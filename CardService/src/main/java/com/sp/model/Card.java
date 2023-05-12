package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Card {
	@Id
	@GeneratedValue
	private int idCard;
	private int ownerId;
	private String name;
	private String superPowerName;
	private int superPowerValue;
	private int hp;
	private int atk;
	private int def;
	private int eng;
	private int value;
	private String description;
	private String imgUrl;
	private boolean onSale = true;

	public Card() {		
	}
	
	public Card(int ownerId, String name, String superPowerName, int superPowerValue, int hp, int atk, int def, int eng,
			int val, String description, String imgUrl, boolean sale) {
		this.ownerId = ownerId;
		this.name = name;
		this.superPowerName = superPowerName;
		this.superPowerValue = superPowerValue;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.eng = eng;
		this.value = val;
		this.description = description;
		this.imgUrl = imgUrl;
		this.onSale = sale;
	}
	
	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getId() {
		return idCard;
	}

	public void setId(int id) {
		this.idCard = id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPowerName() {
		return superPowerName;
	}

	public void setSuperPowerName(String superPowerName) {
		this.superPowerName = superPowerName;
	}

	public int getSuperPowerValue() {
		return superPowerValue;
	}

	public void setSuperPowerValue(int superPowerValue) {
		this.superPowerValue = superPowerValue;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}
}
