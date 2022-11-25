package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.lines.Road;

public class RoadViewer implements LineViewer<Road>{
    @Override
    public void draw(Road road, LanternaGUI lanternaGUI) {
        lanternaGUI.drawRoad(road, road.getY());
    }
}
