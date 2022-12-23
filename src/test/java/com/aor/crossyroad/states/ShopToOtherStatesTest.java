package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.shop.ShopController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.Skins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopToOtherStatesTest {
    private ShopController shopController;
    private Game game;
    private GameState gameState;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        gameState=new GameState(new Arena(40,40));
        shopController= new ShopController(new Shop(gameState));
    }
    @Test
    void ChangeToGameState() throws IOException {
        shopController.step(game, LanternaGUI.ACTION.DOWN,0);
        shopController.step(game, LanternaGUI.ACTION.DOWN,0);
        shopController.step(game, LanternaGUI.ACTION.SELECT,0);
        State expected= new GameState(new Arena(40,40));
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
    @Test
    void ChangeToPowerUpState() throws IOException {
        shopController.step(game, LanternaGUI.ACTION.SELECT,0);
        State expected= new PowerUpsState(new PowerUps(new ShopState(new Shop(new GameState(new Arena(40,40))))));
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
    @Test
    void ChangeToSkinState() throws IOException {
        shopController.step(game, LanternaGUI.ACTION.DOWN,0);
        shopController.step(game, LanternaGUI.ACTION.SELECT,0);
        State expected= new SkinsState(new Skins(new ShopState(new Shop(new GameState(new Arena(40,40))))));
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
}
