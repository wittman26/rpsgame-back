package com.games.rpsgamerest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.rpsgamerest.business.IPlayGameBusiness;
import com.games.rpsgamerest.dto.PlayerDTO;
import com.games.rpsgamerest.dto.RoundGameDTO;
import com.games.rpsgamerest.model.Player;
import com.games.rpsgamerest.model.RoundGame;
import com.games.rpsgamerest.service.IPlayerService;

@RestController
@CrossOrigin
@RequestMapping("${basepath}")
public class PlayerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

	/** Service **/
	@Autowired
	private IPlayerService playerService;

	/** Business **/
	@Autowired
	private IPlayGameBusiness playGameBusiness;

	/**
	 * Get Player List
	 * 
	 * @return List<Player> playerList
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Player>> getListPlayers() {
		List<Player> playerList = new ArrayList<>();
		playerList = playerService.list();
		return new ResponseEntity<List<Player>>(playerList, HttpStatus.OK);
	}

	/**
	 * Get Player Object
	 * 
	 * @param id Player id
	 * @return Player player
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable("id") String id) {
		Player playerFound = playerService.listById(id);
		PlayerDTO playerDTO = new PlayerDTO();
		if (playerFound != null) {
			playerDTO = new PlayerDTO(playerFound);
		}
		return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.OK);
	}

	/**
	 * Post Save player info and plays a round
	 * 
	 * @param playerDTO
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoundGameDTO> postSavePlayer(@RequestBody PlayerDTO playerDTO) {
		LOGGER.info("postSavePlayer: " + playerDTO.getId());
		Player playerFound = playerService.listById(playerDTO.getId());
		if (playerFound == null) {
			playerFound = playerService.save(new Player(playerDTO.getId()));
		}
		
		RoundGame roundGame = playGameBusiness.playRPS(playerFound);
		playerService.updatePlayerRound(playerFound, roundGame);

		RoundGameDTO roundGameDTO = new RoundGameDTO(playerFound);

		return new ResponseEntity<RoundGameDTO>(roundGameDTO, HttpStatus.OK);
	}

	/**
	 * Patch Restart game round for a player
	 * 
	 * @param playerDTO
	 * @return
	 */
	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoundGameDTO> patchRestartGame(@RequestBody PlayerDTO playerDTO) {
		LOGGER.info("Reset Game");
		Player playerFound = playerService.listById(playerDTO.getId());
		if (playerFound == null) {
			playerFound = playerService.save(new Player(playerDTO.getId()));
		}

		playerService.resetRPS(playerFound);

		RoundGameDTO roundGameDTO = new RoundGameDTO(playerFound);

		return new ResponseEntity<RoundGameDTO>(roundGameDTO, HttpStatus.OK);
	}

}