package com.games.rpsgamerest.dto;

import java.util.List;

import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {
	private String id;
	private int totalRoundsPlayed;
	private int totalWins;
	private int totalLoses;
	private int totalDraws;
	private List<RoundGame> roundGameList;
	
	public PlayerDTO() {}
	
	public PlayerDTO(Player player) {
		super();
		this.id = player.getId();
		this.totalRoundsPlayed = player.getTotalRoundsPlayed();
		this.totalWins = player.getTotalWins();
		this.totalLoses = player.getTotalLoses();
		this.totalDraws = player.getTotalDraws();
		this.roundGameList = player.getRoundGameList();
	}
}
