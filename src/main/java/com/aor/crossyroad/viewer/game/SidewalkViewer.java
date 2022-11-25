package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.lines.Sidewalk;

public class SidewalkViewer implements LineViewer<Sidewalk>{
    @Override
    public void draw(Sidewalk sidewalk, LanternaGUI lanternaGUI) {
        lanternaGUI.drawSidewalk(sidewalk, sidewalk.getY());
    }
}
