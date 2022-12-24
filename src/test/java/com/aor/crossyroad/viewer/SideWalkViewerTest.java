package com.aor.crossyroad.viewer;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import com.aor.crossyroad.viewer.game.SidewalkViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SideWalkViewerTest {
    private SidewalkViewer sideWalkViewer;
    private LanternaGUI gui;
    private Sidewalk sidewalk;
    @BeforeEach
    void setUp(){
        gui= Mockito.mock(LanternaGUI.class);
        sideWalkViewer=new SidewalkViewer();
        sidewalk=new Sidewalk(5);
    }
    @Test
    void draw(){
        sideWalkViewer.draw(sidewalk,gui);
        Mockito.verify(gui,Mockito.times(1)).drawSidewalk(sidewalk.getY());
    }
}
