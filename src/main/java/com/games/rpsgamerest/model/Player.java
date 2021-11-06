package com.games.rpsgamerest.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	private String id;
	private List<RoundGame> roundGameList;
	private int totalRoundsPlayed;
	private int totalWins;
	private int totalLoses;
	private int totalDraws;

	public Player(String id) {
		super();
		this.id = id.toUpperCase();
		this.roundGameList = new ArrayList<RoundGame>();
		this.totalRoundsPlayed = 0;
		this.totalWins = 0;
		this.totalLoses = 0;
		this.totalDraws = 0;
	}

	public void IncreaseTotalRoundsPlayed() {
		this.totalRoundsPlayed++;
	}

	public void IncreaseWins() {
		this.totalWins++;
	}

	public void IncreaseLoses() {
		this.totalLoses++;
	}

	public void IncreaseDraws() {
		this.totalDraws++;
	}

}
