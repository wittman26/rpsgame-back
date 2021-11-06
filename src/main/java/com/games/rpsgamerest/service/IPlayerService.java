package com.games.rpsgamerest.service;

import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;

public interface IPlayerService extends ICRUD<Player>{
	public Player updatePlayerRound(Player player, RoundGame roundGame);
	public Player resetRPS(Player player);
}
