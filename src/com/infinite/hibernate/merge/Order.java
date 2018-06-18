package com.infinite.hibernate.merge;

public class Order {
	private int orderId;
	private String orderName;
	private int orderCost;

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName
	 *            the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return the orderCost
	 */
	public int getOrderCost() {
		return orderCost;
	}

	/**
	 * @param orderCost
	 *            the orderCost to set
	 */
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
}
