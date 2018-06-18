package com.infinite.hibernate.customgenerator;

public class Book 
{

	private int bookId;
	private String bookName;
	private int bookPrice;
	
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the bookPrice
	 */
	public int getBookPrice() {
		return bookPrice;
	}
	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
}
