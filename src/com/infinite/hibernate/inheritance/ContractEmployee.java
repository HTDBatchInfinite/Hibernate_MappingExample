package com.infinite.hibernate.inheritance;

public class ContractEmployee extends EmployeeInheritance {
	private int Pay_for_hour;
	private int TimePeriode;

	/**
	 * @return the pay_for_hour
	 */
	public int getPay_for_hour() {
		return Pay_for_hour;
	}

	/**
	 * @param pay_for_hour
	 *            the pay_for_hour to set
	 */
	public void setPay_for_hour(int pay_for_hour) {
		Pay_for_hour = pay_for_hour;
	}

	/**
	 * @return the timePeriode
	 */
	public int getTimePeriode() {
		return TimePeriode;
	}

	/**
	 * @param timePeriode
	 *            the timePeriode to set
	 */
	public void setTimePeriode(int timePeriode) {
		TimePeriode = timePeriode;
	}
}
