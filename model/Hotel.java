package com.oop.model;

public class Hotel {
	private int HID;
	private String Name;
	private String Address;
	private String Phone;
	private String OwnerName;
	private String HType;
	private String Price;
	
	public Hotel(int hID, String name, String address, String phone, String ownerName, String hType, String price) {
	
		HID = hID;
		Name = name;
		Address = address;
		Phone = phone;
		OwnerName = ownerName;
		HType = hType;
		Price = price;
	}

	public int getHID() {
		return HID;
	}

	public String getName() {
		return Name;
	}

	public String getAddress() {
		return Address;
	}

	public String getPhone() {
		return Phone;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public String getHType() {
		return HType;
	}

	public String getPrice() {
		return Price;
	}

	public void setHID(int hID) {
		HID = hID;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	public void setHType(String hType) {
		HType = hType;
	}

	public void setPrice(String price) {
		Price = price;
	}

}
