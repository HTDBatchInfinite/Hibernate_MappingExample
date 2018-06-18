package com.infinite.hibernate.thirdTable;

import java.util.List;

public class Bank {

	private int bank_Id;
	private String bank_Name;
	private List<Customer> customers;
	/**
	 * @return the bank_Id
	 */
	public int getBank_Id() {
		return bank_Id;
	}
	/**
	 * @param bank_Id the bank_Id to set
	 */
	public void setBank_Id(int bank_Id) {
		this.bank_Id = bank_Id;
	}
	/**
	 * @return the bank_Name
	 */
	public String getBank_Name() {
		return bank_Name;
	}
	/**
	 * @param bank_Name the bank_Name to set
	 */
	public void setBank_Name(String bank_Name) {
		this.bank_Name = bank_Name;
	}
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}
	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
