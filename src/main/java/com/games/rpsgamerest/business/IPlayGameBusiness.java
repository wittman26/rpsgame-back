package com.games.rpsgamerest.business;

import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;

public interface IPlayGameBusiness {
	public RoundGame playRPS(Player player);
}
