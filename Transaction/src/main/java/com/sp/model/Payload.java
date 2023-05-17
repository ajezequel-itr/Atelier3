package com.sp.model;

public class Payload {

	private int idCard;
    private int idBuyer;
    
    public Payload() {}
    
    public Payload(int idCard, int idBuyer) {
        this.setIdCard(idCard);
        this.setIdBuyer(idBuyer);
    }

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public int getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(int idBuyer) {
		this.idBuyer = idBuyer;
	}
}
