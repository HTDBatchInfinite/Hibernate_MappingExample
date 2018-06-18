package com.infinite.hibernate.Component;

public class StudentAddress 
{
private String Country;
private String State;
private String city;
private int Pine;
/**
 * @return the country
 */
public String getCountry() {
	return Country;
}
/**
 * @param country the country to set
 */
public void setCountry(String country) {
	Country = country;
}
/**
 * @return the state
 */
public String getState() {
	return State;
}
/**
 * @param state the state to set
 */
public void setState(String state) {
	State = state;
}
/**
 * @return the city
 */
public String getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the pine
 */
public int getPine() {
	return Pine;
}
/**
 * @param pine the pine to set
 */
public void setPine(int pine) {
	Pine = pine;
}


}
