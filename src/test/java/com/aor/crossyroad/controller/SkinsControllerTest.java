package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.shop.SkinsController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.Skins;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.ShopState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkinsControllerTest {
    private SkinsController skinsController;
    private Game game;
    private GameState gameState;
    private Chicken chicken;
    private Arena arena;
    @BeforeEach
    void setUp(){
        game=new Game();
        arena=new Arena(40,40);
        gameState=new GameState(arena);
        skinsController=new SkinsController(new Skins(new ShopState(new Shop(gameState))));
    }
    @Test

    void MenuActionDownAndUP() throws IOException {
        skinsController.step(game, LanternaGUI.ACTION.DOWN,300);
        assertEquals(skinsController.getModel().getCurrentOption(),1);
        skinsController.step(game, LanternaGUI.ACTION.DOWN,600);
        assertEquals(skinsController.getModel().getCurrentOption(),2);
        skinsController.step(game, LanternaGUI.ACTION.UP,1200);
        assertEquals(skinsController.getModel().getCurrentOption(),1);
        skinsController.step(game, LanternaGUI.ACTION.UP,1800);
        assertEquals(skinsController.getModel().getCurrentOption(),0);
    }
}
