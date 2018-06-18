package com.infinite.hibernate.inheritance;

public class EmployeeInheritance {
	private int EmployeeId;
	private String EmployeeName;
	private int EmployeeAge;
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return EmployeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return EmployeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	/**
	 * @return the employeeAge
	 */
	public int getEmployeeAge() {
		return EmployeeAge;
	}
	/**
	 * @param employeeAge the employeeAge to set
	 */
	public void setEmployeeAge(int employeeAge) {
		EmployeeAge = employeeAge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeInheritance [EmployeeId=" + EmployeeId
				+ ", EmployeeName=" + EmployeeName + ", EmployeeAge="
				+ EmployeeAge + "]";
	}
	
	
}
