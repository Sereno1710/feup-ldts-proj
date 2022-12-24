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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SuppressWarnings("ALL")
public class GameOverToOtherStatesTest {
    private GameOverController gameOverController;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        Arena arena = new Arena(40, 40);
        GameOverState gameOverState = new GameOverState(new GameOver("4", "4"));
        game.setState(gameOverState);
        gameOverController= new GameOverController(new GameOver("4","4"));
    }
    @SuppressWarnings("rawtypes")
    @Test
    void ChangeToNull() throws IOException {
        gameOverController.step(game, LanternaGUI.ACTION.DOWN,0);
        gameOverController.step(game, LanternaGUI.ACTION.SELECT,0);
        State actual= game.getState();
        assertEquals(null,actual);
    }
    @SuppressWarnings("rawtypes")
    @Test
    void ChangeToGame() throws IOException {
        gameOverController.step(game, LanternaGUI.ACTION.SELECT,0);
        State actual=game.getState();
        State<Arena> expected= new GameState(new Arena(40,40));
        assertEquals(expected,actual);
    }
    @SuppressWarnings("rawtypes")
    @Test
    void FixingMutation() throws IOException {
        gameOverController.step(game, LanternaGUI.ACTION.NONE,0);
        State actual= game.getState();
        State<Arena> expected= new GameState(new Arena(40,40));
        assertNotEquals(expected,actual);
    }
}
