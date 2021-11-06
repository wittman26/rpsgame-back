package com.games.rpsgamerest.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.games.rpsgamerest.business.impl.PlayGameBusiness;
import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;
import com.games.rpsgamerest.utis.ResultEnum;

import static com.games.rpsgamerest.utis.Constants.PAPER;
import static com.games.rpsgamerest.utis.Constants.ROCK;
import static com.games.rpsgamerest.utis.Constants.SCISSORS;

@SpringBootTest
public class PlayGameBusinessTest {
	private final String PLAYERID = "PLAYER1";

	@Autowired
	private PlayGameBusiness playGameBusiness;

	@Test
	public void playRPSOk() throws Exception {
		Player player = new Player(PLAYERID);
		RoundGame roundGame = playGameBusiness.playRPS(player);
		Assertions.assertNotEquals(roundGame, null);
	}

	@Test
	public void getResultGameSOk() throws Exception {
		ResultEnum result = PlayGameBusiness.getResultGame(PAPER, ROCK);
		Assertions.assertEquals(result, ResultEnum.WIN);
		result = PlayGameBusiness.getResultGame(PAPER, SCISSORS);
		Assertions.assertEquals(result, ResultEnum.LOSE);
		result = PlayGameBusiness.getResultGame(PAPER, PAPER);
		Assertions.assertEquals(result, ResultEnum.TIE);
	}

}
