package com.aor.crossyroad.viewer;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.viewer.game.ChickenViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChickenViewerTest {
        private Chicken chicken;
        private ChickenViewer viewer;
        private LanternaGUI gui;
        @BeforeEach
        void setUp() {
            chicken = new Chicken(10, 10);
            viewer = new ChickenViewer();
            gui = Mockito.mock(LanternaGUI.class);
        }
        @Test
        void notNull(){
                assertNotNull(viewer);
                assertNotNull(gui);
                assertNotNull(chicken);
        }
        @Test
        void drawElement() {
            viewer.draw(chicken, gui);
            Mockito.verify(gui, Mockito.times(1)).drawChicken(chicken.getPosition(),'&');
        }
}
