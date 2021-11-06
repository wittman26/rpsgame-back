package com.games.rpsgamerest.dto;

import java.util.List;

import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoundGameDTO {
	private String id;
	private List<RoundGame> roundGameList;

	public RoundGameDTO(Player player) {
		this.id = player.getId();
		this.roundGameList = player.getRoundGameList();
	}
}
