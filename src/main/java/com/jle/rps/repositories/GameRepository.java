package com.jle.rps.repositories;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.jle.rps.Game;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GameRepository {
	
	private ArrayList<Game> gameList;

	public GameRepository() {
		gameList = new ArrayList<>();
	}

	public void restart() {
		gameList.clear();
	}

	public ArrayList<Game> getGames() {
		return gameList;
	}

	public void addGame(Game game) {
		gameList.add(game);
	}

}
