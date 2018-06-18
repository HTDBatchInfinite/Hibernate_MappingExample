package com.infinite.hibernate.bidirection;

import java.util.List;

public class Department {
	
	//setters and getters
	private int departmentId;
	private String departmentName;
	private List<Employee> employees;
	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}
	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}