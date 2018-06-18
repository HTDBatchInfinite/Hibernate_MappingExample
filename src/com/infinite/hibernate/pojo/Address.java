package com.infinite.hibernate.pojo;

public class Address {
	private int id;
	private String state;
	private String country;
	private int pin;

	// parameter constructor

	public Address() {

	}

	// parameter constructor

	public Address(int id, String state, String country, int pin) {
		super();
		this.id = id;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}

	// setter and getters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	
}