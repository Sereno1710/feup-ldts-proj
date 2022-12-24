package com.aor.crossyroad.viewer;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class ArenaViewerTest {
    private LanternaGUI gui;
    private GameViewer viewer;

    @BeforeEach
    void setUp() {
        Arena arena = new Arena(10, 10);
        gui = Mockito.mock(LanternaGUI.class);
        viewer = new GameViewer(arena);
        arena.LineCreator();
        Chicken chicken = new Chicken(5, 8);
        arena.setChicken(chicken);
        arena.RandomizeSidewalks();
    }
    @Test
    void drawChicken() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawChicken(new Position(5, 8),'&');
        Mockito.verify(gui, Mockito.times(1)).drawChicken(Mockito.any(Position.class), Mockito.anyChar());
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}