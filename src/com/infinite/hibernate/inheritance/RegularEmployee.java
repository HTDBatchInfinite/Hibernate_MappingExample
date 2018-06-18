package com.infinite.hibernate.inheritance;

public class RegularEmployee extends EmployeeInheritance {
private int Salary;
private int Bonus;
/**
 * @return the salary
 */
public int getSalary() {
	return Salary;
}
/**
 * @param salary the salary to set
 */
public void setSalary(int salary) {
	Salary = salary;
}
/**
 * @return the bonus
 */
public int getBonus() {
	return Bonus;
}
/**
 * @param bonus the bonus to set
 */
public void setBonus(int bonus) {
	Bonus = bonus;
}
}
