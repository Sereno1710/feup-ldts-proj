package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.menu.MenuController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuStateToOtherStatesTest {
    private MenuController menuController;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game= new Game();
        menuController= new MenuController(new Menu());
    }
    @Test
    void ChangingToGameState() throws IOException, URISyntaxException, FontFormatException {
        menuController.step(game, LanternaGUI.ACTION.SELECT,0);
        State expected= new GameState(new Arena(40,40));
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
    @Test
    void ChangingToInstructionsState() throws IOException, URISyntaxException, FontFormatException {
        menuController.step(game, LanternaGUI.ACTION.DOWN,0);
        menuController.step(game, LanternaGUI.ACTION.SELECT,0);
        State expected= new IntructionsState(new InstructionsMenu());
        State actual= game.getState();
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }
    @Test
    void ChangingToNullState() throws IOException, URISyntaxException, FontFormatException {
        menuController.step(game, LanternaGUI.ACTION.DOWN,0);
        menuController.step(game, LanternaGUI.ACTION.DOWN,0);
        menuController.step(game, LanternaGUI.ACTION.SELECT,0);
        State actual= game.getState();
        assertEquals(actual,null);
    }
}
