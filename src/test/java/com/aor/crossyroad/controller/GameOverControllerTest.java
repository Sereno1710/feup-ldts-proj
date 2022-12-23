package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.menu.GameOverController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.menu.GameOver;
import com.aor.crossyroad.states.GameOverState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverControllerTest {
    private GameOverController gameOverController;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game= new Game();
        gameOverController=new GameOverController(new GameOver("0","0"));
        game.setState(new GameOverState(new GameOver("0","0")));
    }
    @Test
    void UpAndDown() throws IOException {
        gameOverController.step(game, LanternaGUI.ACTION.DOWN,0);
        assertEquals(gameOverController.getModel().getCurrentOption(),1);
        gameOverController.step(game, LanternaGUI.ACTION.UP,600);
        assertEquals(gameOverController.getModel().getCurrentOption(),0);
        gameOverController.step(game, LanternaGUI.ACTION.UP,900);
        assertEquals(gameOverController.getModel().getCurrentOption(),1);
    }
}
