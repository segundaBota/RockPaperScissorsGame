package com.jle.rps.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jle.rps.controllers.GameController;

@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameControllerTest {

    private GameController gameController;

    @Mock
    private ModelMap model;

    @Mock
    RedirectAttributes attributes;

    @Before
    public void before(){
    	gameController = new GameController();
    }

    @Test
    public void checkIndexController(){
        String returnValue = gameController.index(model);

        //verify(model, times(1).addAttribute("",""));
        assertEquals("index", returnValue);
    }

    @Test
    public void checkStatsController() throws Exception{
        String returnValue = gameController.stats(model);

        //verify(model, times(1).addAttribute("",""));
        assertEquals("stats", returnValue);
    }
}
