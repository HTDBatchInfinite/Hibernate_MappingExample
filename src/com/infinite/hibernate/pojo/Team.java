package com.infinite.hibernate.pojo;

import java.util.List;

public class Team {
	private int teamNo;
	private String teamName;

	// one to many
	private List<Player> players;

	// one to one
	private Bord bord;

	// Default constructor

	public Team() {
	}

	// parameter constructor
	public Team(int teamNo, String teamName, List<Player> players, Bord bord) {
		super();
		this.teamNo = teamNo;
		this.teamName = teamName;
		this.players = players;
		this.bord = bord;
	}

	public int getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Bord getBord() {
		return bord;
	}

	public void setBord(Bord bord) {
		this.bord = bord;
	}

	/*@Override
	public String toString() {
		return "Team [teamNo=" + teamNo + ", teamName=" + teamName
				+ ", players=" + players + ", bord=" + bord + "]";
	}*/
	
	

}
