package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.menu.InstructionsController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsStateToMenuStateTest {
    private InstructionsController instructionsController;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        game.setState(new IntructionsState(new InstructionsMenu()));
        instructionsController= new InstructionsController(new InstructionsMenu());
    }
    @Test
    void ChangeToMenu() throws IOException {
        instructionsController.step(game, LanternaGUI.ACTION.NONE,100);
        State actual=game.getState();
        State expected=new IntructionsState(new InstructionsMenu());
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
        instructionsController.step(game, LanternaGUI.ACTION.SELECT,0);
        actual=game.getState();
        expected=new MenuState(new Menu());
        assertEquals(actual.getController(),expected.getController());
        assertEquals(actual.getViewer(),expected.getViewer());
        assertEquals(actual.getModel(),expected.getModel());
    }

}
