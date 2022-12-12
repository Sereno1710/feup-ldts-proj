package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Coin;
import com.aor.crossyroad.model.game.elements.Element;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.elements.cars.Car;
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
        lanternaGUI.drawShop(getModel().getShop().getPosition());
        drawElement(lanternaGUI, getModel().getChicken(), new ChickenViewer());
        drawTables(lanternaGUI);
        drawTime(lanternaGUI);
        drawBorder(lanternaGUI);
        drawCoins(lanternaGUI);
    }
    @Override
    public void drawLines(LanternaGUI lanternaGUI){
        SidewalkViewer sidewalkViewer = new SidewalkViewer();
        RoadViewer roadViewer = new RoadViewer();
        for(Sidewalk s:getModel().getSidewalks()){
            sidewalkViewer.draw(s,lanternaGUI);
            drawTrees(lanternaGUI,s);
        }
        for(Road rl: getModel().getRoadsLeft()){
            roadViewer.draw(rl,lanternaGUI);
            drawCars(lanternaGUI,rl);
        }
        for(Road rd: getModel().getRoadsRight()){
            roadViewer.draw(rd,lanternaGUI);
            drawCars(lanternaGUI,rd);
        }
        lanternaGUI.drawSafe();
    }

    private <T extends Element> void drawElement(LanternaGUI lanternaGUI, T element, ElementViewer<T> viewer) {
        viewer.draw(element, lanternaGUI);
    }
    private void drawTime(LanternaGUI lanternaGUI){
        long t=getModel().getTime();
        if(t>600) lanternaGUI.drawText(new Position(0,0)," Time="+getModel().getTime()/30,"#32CD32");
        else if (t>300) lanternaGUI.drawText(new Position(0,0)," Time="+getModel().getTime()/30,"#FFD700");
        else lanternaGUI.drawText(new Position(0,0)," Time="+getModel().getTime()/30,"#FF0000");
    }
    private void drawBorder(LanternaGUI lanternaGUI){
        for (int j=0;j<40;j++){
            lanternaGUI.drawBorder(0,j);
            lanternaGUI.drawBorder(39,j);
        }
        for( int i=0 ; i<40;i++){
            lanternaGUI.drawBorder(i,0);
            lanternaGUI.drawBorder(i,39);
        }
    }
    private void drawTables(LanternaGUI lanternaGUI){
        lanternaGUI.drawText(new Position(15, 0), "\t$$$=" + getModel().getCoinAmount(), "#FFD700");
        lanternaGUI.drawText(new Position(30, 0), "\tScore=" + getModel().getScore(), "#FFD700");
    }
    private void drawCoins(LanternaGUI lanternaGUI){
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
    private void drawTrees(LanternaGUI lanternaGUI,Sidewalk sidewalk){
        for (Tree tree:sidewalk.getTrees()){
            drawElement(lanternaGUI,tree,new TreeViewer());
        }
    }
    private void drawCars(LanternaGUI lanternaGUI,Road road){
        for (Car c: road.getCars())
            drawElement(lanternaGUI,c,new CarViewer());
    }
}
