package com.infinite.hibernate.pojo;

public class Player {
	private int playerId;
	private String playerName;
	private int playerScore;
	private int playerAvarage;
	private int playerWickets;
   
	
	// one to one
private Address address;


	public Player() {

	}

	// parameter Constructor

	
	// Setters and Getters

	public int getPlayerId() {
		return playerId;
	}

	public Player(int playerId, String playerName, int playerScore,
			int playerAvarage, int playerWickets,  Address address) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.playerAvarage = playerAvarage;
		this.playerWickets = playerWickets;
		
		this.address = address;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getPlayerAvarage() {
		return playerAvarage;
	}

	public void setPlayerAvarage(int playerAvarage) {
		this.playerAvarage = playerAvarage;
	}

	public int getPlayerWickets() {
		return playerWickets;
	}

	public void setPlayerWickets(int playerWickets) {
		this.playerWickets = playerWickets;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

 

}
