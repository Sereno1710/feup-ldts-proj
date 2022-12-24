package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.menu.MenuController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class MenuControllerTest {
    private MenuController menuController;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game= new Game();
        menuController= new MenuController(new Menu());
    }
    @Test
    void MenuChickenMovement() throws IOException {
        menuController.step(game, LanternaGUI.ACTION.NONE,0);
        menuController.step(game, LanternaGUI.ACTION.NONE,600);
        assertNotEquals(menuController.getModel().getChicken().getPosition(),new Position(16,25));
    }
    @Test
    void MenuActionDownAndUP() throws IOException {
        menuController.step(game, LanternaGUI.ACTION.DOWN,300);
        assertEquals(menuController.getModel().getCurrentOption(),1);
        menuController.setLastMovement(400);
        menuController.step(game, LanternaGUI.ACTION.DOWN,600);
        assertEquals(menuController.getModel().getCurrentOption(),2);
        menuController.step(game, LanternaGUI.ACTION.UP,1200);
        assertEquals(menuController.getModel().getCurrentOption(),1);
        menuController.step(game, LanternaGUI.ACTION.UP,1800);
        assertEquals(menuController.getModel().getCurrentOption(),0);
    }
}
