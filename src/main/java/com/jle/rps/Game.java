package com.jle.rps;

import java.util.Random;

public class Game {
	
	public enum CHOICES {ROCK, PAPER, SCISSORS};
	public enum RESULTS {WIN, LOSE, DRAW};
	
	private CHOICES playerChoice;
	private CHOICES computerChoice;
	private RESULTS result;
	private int wins, loses, draws;
	
	public Game() {
		wins=0; loses=0; draws=0;
	}

	public void play() {
		//First step: generation of random choice for the player
		Random ran = new Random();
		int choice = 1 + ran.nextInt(3);
		switch (choice) {
		case 1:
			playerChoice = CHOICES.ROCK;
		case 2:
			playerChoice = CHOICES.PAPER;
		case 3:
			playerChoice = CHOICES.SCISSORS;
		}

		//Second step: Computer choice is always ROCK
		computerChoice = CHOICES.ROCK;

		//Third step: Obtain the result
		result = getResult();

		//Last step: Calculate stats
		calculateStats();
	}

	public RESULTS getResult() {
		if (playerChoice == computerChoice)
			return RESULTS.DRAW;
		else if (playerChoice == CHOICES.PAPER)
			return RESULTS.WIN;
		else
			return RESULTS.LOSE;
	}

	public void calculateStats() {
		if (result == RESULTS.WIN)
			wins++;
		else if (result == RESULTS.LOSE)
			loses++;
		else
			draws++;
	}
}
