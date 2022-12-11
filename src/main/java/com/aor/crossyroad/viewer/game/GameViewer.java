package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Coin;
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
        lanternaGUI.drawText(new Position(1, 1), "\t$$$=" + getModel().getCoinAmount(), "#FFD700");
        lanternaGUI.drawText(new Position(80, 1), "\tScore=" + getModel().getScore(), "#FFD700");
        drawTime(lanternaGUI);
        for(Road r: getModel().getRoadsLeft()){
            if(!r.getCoins().isEmpty()){
                for(Coin c: r.getCoins()){
                    drawElement(lanternaGUI,c,new CoinViewer());
                }
            }
        }
        for(Road r: getModel().getRoadsRight()){
            if(!r.getCoins().isEmpty()){
                for(Coin c: r.getCoins()){
                    drawElement(lanternaGUI,c,new CoinViewer());
                }
            }
        }
    }
    @Override
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
    private void drawTime(LanternaGUI lanternaGUI){
        long t=getModel().getTime();
        if(t>800) lanternaGUI.drawText(new Position(1,2),"\tTime="+getModel().getTime()/40,"#32CD32");
        else if (t>400) lanternaGUI.drawText(new Position(1,2),"\tTime="+getModel().getTime()/40,"#FFD700");
        else lanternaGUI.drawText(new Position(1,2),"\tTime="+getModel().getTime()/40,"#FF0000");
    }
}
