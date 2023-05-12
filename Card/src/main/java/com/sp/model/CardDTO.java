package com.sp.model;

public class CardDTO {
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
	
	public CardDTO(String name, String spn, int spv, int hp, int atk, int def, int eng, int value, String desc, String img) {
		this.name = name;
		this.superPowerName = spn;
		this.superPowerValue = spv;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.eng = eng;
		this.value = value;
		this.description = desc;
		this.imgUrl = img;
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
	
	
}
