package com.infinite.hibernate.timerstamp;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String userAddress;
	private Date LastModifyedBy;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress
	 *            the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the lastModifyedBy
	 */
	/**
	 * @return the lastModifyedBy
	 */
	public Date getLastModifyedBy() {
		return LastModifyedBy;
	}

	/**
	 * @param lastModifyedBy
	 *            the lastModifyedBy to set
	 */
	public void setLastModifyedBy(Date lastModifyedBy) {
		LastModifyedBy = lastModifyedBy;
	}

}
