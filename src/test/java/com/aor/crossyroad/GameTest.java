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

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game=new Game();
        LanternaGUI lanternaGUI = Mockito.mock(LanternaGUI.class);
        int FPS = 30;
    }
    @Test
    void setNull() {
        game.setState(null);
        assertEquals(null,game.getState());
    }
}
