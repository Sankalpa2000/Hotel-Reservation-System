package com.oop.model;

public class Payment {
	private int PID;
	private String CusName;
	private String CardType;
	private String CardNo;
	private String CVV;
	private String Address;
	private String Amount;
	
	public Payment(int pID, String cusName, String cardType, String cardNo, String cVV, String address, String amount) {
		
		PID = pID;
		CusName = cusName;
		CardType = cardType;
		CardNo = cardNo;
		CVV = cVV;
		Address = address;
		Amount = amount;
	}

	public int getPID() {
		return PID;
	}

	public String getCusName() {
		return CusName;
	}

	public String getCardType() {
		return CardType;
	}

	public String getCardNo() {
		return CardNo;
	}

	public String getCVV() {
		return CVV;
	}

	public String getAddress() {
		return Address;
	}

	public String getAmount() {
		return Amount;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public void setCusName(String cusName) {
		CusName = cusName;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}

	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

}
