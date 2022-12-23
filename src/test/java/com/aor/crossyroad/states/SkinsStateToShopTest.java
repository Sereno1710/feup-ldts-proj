package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.shop.SkinsController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.Skins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkinsStateToShopTest {
    private SkinsController skinsController;
    private Game game;
    private ShopState shopState;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        shopState=new ShopState(new Shop(new GameState(new Arena(40,40))));
        game.setState(shopState);
        skinsController= new SkinsController(new Skins(new ShopState(new Shop(new GameState(new Arena(40,40))))));
    }
    @Test
    void ChangeToShop() throws IOException {
        skinsController.step(game, LanternaGUI.ACTION.DOWN,0);
        skinsController.step(game, LanternaGUI.ACTION.DOWN,0);
        skinsController.step(game, LanternaGUI.ACTION.SELECT,0);
        State expected= new ShopState(new Shop(new GameState(new Arena(40,40))));
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
}
