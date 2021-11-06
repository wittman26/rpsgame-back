package com.games.rpsgamerest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;
import com.games.rpsgamerest.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

	/** Simulates listPlayer Data */
	List<Player> listPlayer = new ArrayList<Player>();

	@Override
	public Player save(Player t) {
		if (!listPlayer.contains(t)) {
			listPlayer.add(t);
		}
		return t;
	}

	@Override
	public Player updatePlayerRound(Player player, RoundGame roundGame) {
		player.getRoundGameList().add(roundGame);
		player.IncreaseTotalRoundsPlayed();

		switch (roundGame.getResult()) {
		case WIN: {
			player.IncreaseWins();
			break;
		}
		case LOSE: {
			player.IncreaseLoses();
			break;
		}
		default: {
			player.IncreaseDraws();
			break;
		}
		}
		return player;
	}
	
	@Override
	public Player resetRPS(Player player) {
		player.setRoundGameList(new ArrayList<RoundGame>());
		return player;
	}	

	@Override
	public Player update(Player t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player listById(String id) {
		Player playerFound = listPlayer.stream().filter(player -> id.equalsIgnoreCase(player.getId())).findAny()
				.orElse(null);
		return playerFound;
	}

	@Override
	public List<Player> list() {
		return listPlayer;
	}

}
