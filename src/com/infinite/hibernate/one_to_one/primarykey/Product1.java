package com.infinite.hibernate.one_to_one.primarykey;

public class Product1 {
	private int id;
	private String pname;
	private float price;
	private ProductDetail productDetail;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the productDetail
	 */
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	/**
	 * @param productDetail the productDetail to set
	 */
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	
}
  