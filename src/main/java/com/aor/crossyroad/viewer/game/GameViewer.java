package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Element;
import com.aor.crossyroad.model.game.lines.Line;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import com.aor.crossyroad.viewer.Viewer;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena){
        super(arena);
    }
    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        drawElement(lanternaGUI, getModel().getChicken(), new ChickenViewer());

    }
    public void drawLines(LanternaGUI lanternaGUI){
        SidewalkViewer sidewalkViewer = new SidewalkViewer();
        RoadViewer roadViewer = new RoadViewer();
        for(Sidewalk s:getModel().getSidewalks()){
            sidewalkViewer.draw(s,lanternaGUI);
        }
        for(Road rl: getModel().getRoadsLeft()){
            roadViewer.draw(rl,lanternaGUI);
        }
        for(Road rd: getModel().getRoadsRight()){
            roadViewer.draw(rd,lanternaGUI);
        }
        lanternaGUI.drawSafe();
    }

    private <T extends Element> void drawElement(LanternaGUI lanternaGUI, T element, ElementViewer<T> viewer) {
        viewer.draw(element, lanternaGUI);
    }
}
