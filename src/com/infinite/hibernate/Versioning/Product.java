package com.infinite.hibernate.Versioning;

public class Product {
	private int productId;
	private String productName;
	private int productPrice;
	private int ver;
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productPrice
	 */
	public int getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the ver
	 */
	public int getVer() {
		return ver;
	}
	/**
	 * @param ver the ver to set
	 */
	public void setVer(int ver) {
		this.ver = ver;
	}
	

}
