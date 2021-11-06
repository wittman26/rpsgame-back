package com.games.rpsgamerest.business.impl;

import static com.games.rpsgamerest.utis.Constants.FIRSTPLAYERWINS;
import static com.games.rpsgamerest.utis.Constants.PAPER;
import static com.games.rpsgamerest.utis.Constants.ROCK;
import static com.games.rpsgamerest.utis.Constants.SCISSORS;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.games.rpsgamerest.business.IPlayGameBusiness;
import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;
import com.games.rpsgamerest.utis.ResultEnum;

@Service
public class PlayGameBusiness implements IPlayGameBusiness {

	@Override
	public RoundGame playRPS(Player player) {
		String player1Choice = getRandomChoice();
		String player2Choice = ROCK;

		ResultEnum result = getResultGame(player1Choice, player2Choice);
		
		return new RoundGame(player1Choice, player2Choice, result);

	}

	public static ResultEnum getResultGame(String pl1Choice, String pl2Choice) {
		if (pl1Choice.equalsIgnoreCase(pl2Choice)) {
			return ResultEnum.TIE;
		} else {
			String match = pl1Choice.concat(pl2Choice);
			if (FIRSTPLAYERWINS.contains(match)) {
				return ResultEnum.WIN;
			} else {
				return ResultEnum.LOSE;
			}
		}
	}

	/** **/
	public static String getRandomChoice() {
		Random random = new Random();
		int randChoice = random.nextInt(3);
		switch (randChoice) {
		case 0: {
			return ROCK;
		}
		case 1: {
			return PAPER;
		}
		default: {
			return SCISSORS;
		}
		}
	}

}
