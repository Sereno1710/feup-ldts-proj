package com.aor.crossyroad;

import com.aor.crossyroad.gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class GameTest {
    private Game game;
    private LanternaGUI lanternaGUI;
    private int FPS;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        lanternaGUI = Mockito.mock(LanternaGUI.class);
        FPS=30;
    }
    @Test
    void setNull() throws IOException, URISyntaxException, FontFormatException {
        game.setState(null);
        assertEquals(null,game.getState());
    }
}
