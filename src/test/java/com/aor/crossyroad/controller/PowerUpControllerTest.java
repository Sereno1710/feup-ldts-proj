package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.shop.PowerUpController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.ShopState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class PowerUpControllerTest {
    private PowerUpController powerUpsController;
    private Game game;
    private GameState gameState;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game= new Game();
        gameState= new GameState(new Arena(40,40));
        powerUpsController= new PowerUpController(new PowerUps(new ShopState(new Shop(gameState))));
    }
    @Test
    void MenuActionDownAndUP() throws IOException {
        powerUpsController.step(game, LanternaGUI.ACTION.DOWN,300);
        assertEquals(powerUpsController.getModel().getCurrentOption(),1);
        powerUpsController.step(game, LanternaGUI.ACTION.DOWN,600);
        assertEquals(powerUpsController.getModel().getCurrentOption(),2);
        powerUpsController.step(game, LanternaGUI.ACTION.UP,1200);
        assertEquals(powerUpsController.getModel().getCurrentOption(),1);
        powerUpsController.step(game, LanternaGUI.ACTION.UP,1800);
        assertEquals(powerUpsController.getModel().getCurrentOption(),0);
    }
    @Test
    void BuyingCoinPowerUp() throws IOException {
        gameState.getModel().setCoinAmount(1000);
        powerUpsController.step(game, LanternaGUI.ACTION.DOWN,0);
        powerUpsController.step(game, LanternaGUI.ACTION.SELECT,0);
        assertNotEquals(1000,gameState.getModel().getCoinAmount());
        assertNotEquals(false,gameState.getModel().isSpecialUp());
    }
    @Test
    void BuyingAddTimePowerUp() throws IOException {
        gameState.getModel().setCoinAmount(1000);
        powerUpsController.step(game, LanternaGUI.ACTION.SELECT,0);
        assertNotEquals(1000,gameState.getModel().getCoinAmount());
        assertNotEquals(900,gameState.getModel().getDefaultTime());
    }
    @Test
    void BuyingTeleport() throws IOException {
        gameState.getModel().setCoinAmount(1000);
        powerUpsController.step(game, LanternaGUI.ACTION.DOWN,0);
        powerUpsController.step(game, LanternaGUI.ACTION.DOWN,0);
        powerUpsController.step(game, LanternaGUI.ACTION.SELECT,0);
        assertNotEquals(1000,gameState.getModel().getCoinAmount());
        assertEquals(1,gameState.getModel().getPowerUps().size());
    }

}
