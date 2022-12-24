package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.game.ArenaController;
import com.aor.crossyroad.controller.game.GameController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.menu.GameOver;
import com.aor.crossyroad.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateToOtherStatesTest {
    private GameController gameController;
    private Game game;
    private GameState gameState;
    private Arena arena;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        arena= new Arena(40,40);
        gameState=new GameState(arena);
        game.setState(gameState);
        gameController= new ArenaController(arena,gameState);
    }
    @Test
    void ChangeToMenu() throws IOException {
        gameController.step(game, LanternaGUI.ACTION.QUIT,0);
        State actual=game.getState();
        State expected = new MenuState(new Menu());
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
    @Test
    void ChangeToGameOver() throws IOException {
        gameController.getModel().setDefaultTime(2);
        gameController.getModel().resetTime();
        gameController.step(game, LanternaGUI.ACTION.NONE,0);
        State actual=game.getState();
        Integer CoinAmount= gameState.getModel().getCoinAmount()/2;
        State expected = new GameOverState(new GameOver(CoinAmount.toString(),"0"));
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
    @Test
    void ChangeToShop() throws IOException {
        gameController.step(game, LanternaGUI.ACTION.DOWN,0);
        gameController.step(game, LanternaGUI.ACTION.DOWN,0);
        gameController.step(game, LanternaGUI.ACTION.DOWN,0);
        gameController.step(game, LanternaGUI.ACTION.NONE,0);
        State actual=game.getState();
        State expected = new ShopState(new Shop(gameState));
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
}
