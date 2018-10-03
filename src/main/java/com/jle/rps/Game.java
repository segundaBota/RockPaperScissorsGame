package com.jle.rps;

import java.util.Random;

public class Game {
	
	public enum CHOICES {ROCK, PAPER, SCISSORS};
	public enum RESULTS {WIN, LOSE, DRAW};
	
	private CHOICES playerChoice;
	private CHOICES computerChoice;
	private RESULTS result;
	
	public Game() {
	}

	public void play() {
		//First step: generation of random choice for the player
		Random ran = new Random();
		int choice = 1 + ran.nextInt(3);
		switch (choice) {
		case 1:
			playerChoice = CHOICES.ROCK;
			break;
		case 2:
			playerChoice = CHOICES.PAPER;
			break;
		case 3:
			playerChoice = CHOICES.SCISSORS;
			break;
		}

		//Second step: Computer choice is always ROCK
		computerChoice = CHOICES.ROCK;

		//Third step: Obtain the result
		this.result = getResult();
	}

	public RESULTS getResult() {
		if (playerChoice == computerChoice)
			return RESULTS.DRAW;
		else if (playerChoice == CHOICES.PAPER)
			return RESULTS.WIN;
		else
			return RESULTS.LOSE;
	}

	public CHOICES getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(CHOICES playerChoice) {
		this.playerChoice = playerChoice;
	}

	public CHOICES getComputerChoice() {
		return computerChoice;
	}

	public void setComputerChoice(CHOICES computerChoice) {
		this.computerChoice = computerChoice;
	}

	public void setResult(RESULTS result) {
		this.result = result;
	}
}
