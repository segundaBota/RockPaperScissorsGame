package com.jle.rps.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jle.rps.Game;
import com.jle.rps.Game.RESULTS;
import com.jle.rps.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	private int computerWinsAcc;
	private int playerWinsAcc;
	private int gamesAcc;

	public GameService() {
		computerWinsAcc = 0;
		playerWinsAcc = 0;
		gamesAcc = 0;
	}

	public ArrayList<Game> playGame() {
		Game game = new Game();
		game.play();
		gameRepository.addGame(game);
		
		this.gamesAcc++;
		if (game.getResult().equals(RESULTS.WIN))
			playerWinsAcc++;
		if (game.getResult().equals(RESULTS.LOSE))
			computerWinsAcc++;
	
		
		return gameRepository.getGames();
	}

	public void restartGame() {
		gameRepository.restart();
	}

	public int getComputerWinsAcc() {
		return computerWinsAcc;
	}

	public void setComputerWinsAcc(int computerWinsAcc) {
		this.computerWinsAcc = computerWinsAcc;
	}

	public int getPlayerWinsAcc() {
		return playerWinsAcc;
	}

	public void setPlayerWinsAcc(int playerWinsAcc) {
		this.playerWinsAcc = playerWinsAcc;
	}

	public int getGamesAcc() {
		return gamesAcc;
	}

	public void setGamesAcc(int gamesAcc) {
		this.gamesAcc = gamesAcc;
	}

}
