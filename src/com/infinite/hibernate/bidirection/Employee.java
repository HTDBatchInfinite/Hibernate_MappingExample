package com.infinite.hibernate.bidirection;

public class Employee {
	private int employeeId;
	private String employeeName;
	private int employeeSalary;
	private String employeeAddress;
	private Department departments;

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeSalary
	 */
	public int getEmployeeSalary() {
		return employeeSalary;
	}

	/**
	 * @param employeeSalary
	 *            the employeeSalary to set
	 */
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	/**
	 * @return the employeeAddress
	 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}

	/**
	 * @param employeeAddress
	 *            the employeeAddress to set
	 */
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	/**
	 * @return the departments
	 */
	public Department getDepartments() {
		return departments;
	}

	/**
	 * @param departments
	 *            the departments to set
	 */
	public void setDepartments(Department departments) {
		this.departments = departments;
	}
}
