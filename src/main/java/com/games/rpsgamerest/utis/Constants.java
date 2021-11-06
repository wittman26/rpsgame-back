package com.games.rpsgamerest.utis;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String ROCK = "R";
	public static final String PAPER = "P";
	public static final String SCISSORS = "S";
	public static final List<String> FIRSTPLAYERWINS = Arrays.asList(
			ROCK.concat(SCISSORS), 
			PAPER.concat(ROCK),
			SCISSORS.concat(PAPER));
}
