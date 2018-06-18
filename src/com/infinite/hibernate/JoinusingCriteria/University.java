package com.infinite.hibernate.JoinusingCriteria;

import java.util.List;

public class University {
	
	private int university_ID;
	
	private String university_Name;
	
	private List<Uni_Student> students;

	/**
	 * @return the university_ID
	 */
	public int getUniversity_ID() {
		return university_ID;
	}

	/**
	 * @param university_ID the university_ID to set
	 */
	public void setUniversity_ID(int university_ID) {
		this.university_ID = university_ID;
	}

	/**
	 * @return the university_Name
	 */
	public String getUniversity_Name() {
		return university_Name;
	}

	/**
	 * @param university_Name the university_Name to set
	 */
	public void setUniversity_Name(String university_Name) {
		this.university_Name = university_Name;
	}

	/**
	 * @return the students
	 */
	public List<Uni_Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Uni_Student> students) {
		this.students = students;
	}

}
