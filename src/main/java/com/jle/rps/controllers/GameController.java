package com.jle.rps.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.jle.rps.Game;
import com.jle.rps.services.GameService;

@Controller
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GameController {

	private ArrayList<Game> games;

	private int numGames=0;

	@Autowired
	GameService gameService;

	@Value("${application.controller.title}")
	private String title;

	@Value("${application.controller.welcomeMessage}")
	private String welcome;

	@Value("${application.controller.playerChoice}")
	private String playerChoice;
	
	@Value("${application.controller.computerChoice}")
	private String computerChoice;
	
	@Value("${application.controller.result}")
	private String result;

	@Value("${application.controller.playButton}")
	private String playButton;

	@Value("${application.controller.restartButton}")
	private String restartButton;

	@Value("${application.controller.rounds}")
	private String rounds;

	@Value("${application.controller.stats}")
	private String goToStats;

	@Value("${application.controller.statsTitle}")
	private String statsTitle;

	@Value("${application.controller.return}")
	private String ret;

	@Value("${application.controller.computerAcc}")
	private String computerAcc;

	@Value("${application.controller.playerAcc}")
	private String playerrAcc;

	@Value("${application.controller.totalAcc}")
	private String totalAcc;

	@Value("${application.controller.drawsAcc}")
	private String drawsAcc;

	@RequestMapping("/")
	public String index(ModelMap model) {
        model.addAttribute("title", this.title);
        model.addAttribute("welcome", this.welcome);
		model.addAttribute("playButton", this.playButton);
		model.addAttribute("playerChoice", this.playerChoice);
		model.addAttribute("computerChoice", this.computerChoice);
		model.addAttribute("result", this.result);
		model.addAttribute("restartButton", this.restartButton);
		model.addAttribute("games", this.games);
		model.addAttribute("rounds", this.rounds);
		model.addAttribute("numGames", this.numGames);
		model.addAttribute("gameService", this.gameService);
		model.addAttribute("goToStats", this.goToStats);
		return "index";
	}
	
	@RequestMapping(value = "/play")
    public RedirectView play(RedirectAttributes attributes) throws Exception {
        this.games = gameService.playGame();
        this.numGames++;
		RedirectView redirect = new RedirectView("/");
        return redirect;
    }

	@RequestMapping(value = "/restart")
    public RedirectView restart(RedirectAttributes attributes) throws Exception {
        gameService.restartGame();
        this.numGames=0;
		RedirectView redirect = new RedirectView("/");
        return redirect;
    }

	@RequestMapping(value = "/stats")
    public String stats(ModelMap model) throws Exception {
		model.addAttribute("title", this.title);
        model.addAttribute("statsTitle", this.statsTitle);
        model.addAttribute("computerAcc", this.computerAcc);
        model.addAttribute("playerrAcc", this.playerrAcc);
        model.addAttribute("totalAcc", this.totalAcc);
        model.addAttribute("drawsAcc", this.drawsAcc);
		model.addAttribute("ret", this.ret);
		model.addAttribute("gameService", this.gameService);
		return "stats";
    }

	@RequestMapping(value = "/goBack")
    public RedirectView goBack(RedirectAttributes attributes) throws Exception {
		RedirectView redirect = new RedirectView("/");
        return redirect;
    }

	public int getNumGames() {
		return numGames;
	}

	public void setNumGames(int numGames) {
		this.numGames = numGames;
	}

}
