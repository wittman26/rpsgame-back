package com.games.rpsgamerest.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;
import com.games.rpsgamerest.service.impl.PlayerService;
import com.games.rpsgamerest.utis.ResultEnum;

@SpringBootTest
public class PlayerServiceTest {

	private final String PLAYERID = "PLAYER1";

	@Autowired
	private PlayerService playerService;

	@BeforeEach
	void setUp() {

	}

	@Test
	public void saveOk() throws Exception {
		Player player = new Player(PLAYERID);
		Player playerSaved = playerService.save(player);
		Assertions.assertNotEquals(playerSaved, null);
		playerSaved = playerService.save(player);
		Assertions.assertNotEquals(playerSaved, null);
	}

	@Test
	public void listByIdOk() throws Exception {
		Player playerFound = playerService.listById(PLAYERID);
		Assertions.assertNotEquals(playerFound, null);
	}

	@Test
	public void updatePlayerRoundOk() throws Exception {
		Player player = new Player(PLAYERID);
		RoundGame roundGame = new RoundGame("", "", ResultEnum.LOSE);
		Player playerUpdated = playerService.updatePlayerRound(player, roundGame);

		Assertions.assertNotEquals(playerUpdated, null);
		Assertions.assertEquals(playerUpdated.getTotalLoses(), 1);

		roundGame = new RoundGame("", "", ResultEnum.WIN);
		playerUpdated = playerService.updatePlayerRound(player, roundGame);

		Assertions.assertEquals(playerUpdated.getTotalWins(), 1);

		roundGame = new RoundGame("", "", ResultEnum.TIE);
		playerUpdated = playerService.updatePlayerRound(player, roundGame);

		Assertions.assertEquals(playerUpdated.getTotalDraws(), 1);
	}

	@Test
	public void resetRPSOk() throws Exception {
		Player player = new Player(PLAYERID);
		Player playerUpdated = playerService.resetRPS(player);
		Assertions.assertNotEquals(playerUpdated, null);
		Assertions.assertEquals(playerUpdated.getTotalRoundsPlayed(), 0);
	}

	@Test
	public void getListOk() throws Exception {
		List<Player> playerList = playerService.list();
		Assertions.assertEquals(1, playerList.size());
	}
}
