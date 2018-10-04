package com.jle.rps.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jle.rps.Game;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTests {

	@Autowired
	private GameService gameService;

	@Test
	public void checkAccumulatorsAreUpdated() {

		List<Game> games = new ArrayList<Game>();
		games = gameService.playGame();
		
		assertEquals(games.size(), 1);
		assertEquals(gameService.getGamesAcc(), 1);
		assertEquals(gameService.getComputerWinsAcc() +
				gameService.getPlayerWinsAcc() + gameService.getDrawsAcc(), 1);
	}
}
