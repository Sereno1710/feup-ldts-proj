package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.shop.PowerUpController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ALL")
public class PowerUpStateToShopTest {
    private PowerUpController powerUpController;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        ShopState shopState = new ShopState(new Shop(new GameState(new Arena(40, 40))));
        game.setState(shopState);
        powerUpController= new PowerUpController(new PowerUps(new ShopState(new Shop(new GameState(new Arena(40,40))))));
    }
    @SuppressWarnings("rawtypes")
    @Test
    void ChangeToShop() throws IOException {
        powerUpController.step(game, LanternaGUI.ACTION.DOWN,0);
        powerUpController.step(game, LanternaGUI.ACTION.DOWN,0);
        powerUpController.step(game, LanternaGUI.ACTION.SELECT,0);
        State<Shop> expected= new ShopState(new Shop(new GameState(new Arena(40,40))));
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
}
