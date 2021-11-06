package com.games.rpsgamerest.model;

import com.games.rpsgamerest.utis.ResultEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoundGame {
	private String player1Choice;
	private String player2Choice;
	private ResultEnum result;

}
