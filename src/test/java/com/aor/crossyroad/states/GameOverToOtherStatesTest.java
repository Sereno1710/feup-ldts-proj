package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.menu.GameOverController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverToOtherStatesTest {
    private GameOverController gameOverController;
    private Game game;
    private GameOverState gameOverState;
    private Arena arena;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        arena= new Arena(40,40);
        gameOverState=new GameOverState(new GameOver("4","4"));
        game.setState(gameOverState);
        gameOverController= new GameOverController(new GameOver("4","4"));
    }
    @Test
    void ChangeToNull() throws IOException {
        gameOverController.step(game, LanternaGUI.ACTION.DOWN,0);
        gameOverController.step(game, LanternaGUI.ACTION.SELECT,0);
        State actual= game.getState();
        assertEquals(null,actual);
    }
    @Test
    void ChangeToGame() throws IOException {
        gameOverController.step(game, LanternaGUI.ACTION.SELECT,0);
        State actual=game.getState();
        State expected= new GameState(new Arena(40,40));
        assertEquals(expected,actual);
    }
}
