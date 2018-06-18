package com.infinite.hibernate.Component;

public class Student {
	private int studentId;
	private String studentName;
	private int studentAge;
	private String studentCollege;
	private String studentDepartment;
	private StudentAddress address;

	public Student() {

	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentAge
	 */
	public int getStudentAge() {
		return studentAge;
	}

	/**
	 * @param studentAge
	 *            the studentAge to set
	 */
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	/**
	 * @return the studentCollege
	 */
	public String getStudentCollege() {
		return studentCollege;
	}

	/**
	 * @param studentCollege
	 *            the studentCollege to set
	 */
	public void setStudentCollege(String studentCollege) {
		this.studentCollege = studentCollege;
	}

	/**
	 * @return the studentDepartment
	 */
	public String getStudentDepartment() {
		return studentDepartment;
	}

	/**
	 * @param studentDepartment
	 *            the studentDepartment to set
	 */
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	/**
	 * @return the address
	 */
	public StudentAddress getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(StudentAddress address) {
		this.address = address;
	}

	// to String

	public Student(int studentId, String studentName, int studentAge,
			String studentCollege, String studentDepartment,
			StudentAddress address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentCollege = studentCollege;
		this.studentDepartment = studentDepartment;
		this.address = address;
	}

}
