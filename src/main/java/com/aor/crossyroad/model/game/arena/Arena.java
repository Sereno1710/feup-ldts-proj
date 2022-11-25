package com.aor.crossyroad.model.game.arena;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Line;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    //private char last_safe='D';

    private Chicken chicken;

    private List<Sidewalk> sidewalks;
    private List<Road> roads;
    // private List<Coin> coins;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        LineCreator();
        chicken = new Chicken(width / 2, height - 7);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public List<Road> getRoads() {
        return roads;
    }
    public List<Sidewalk> getSidewalks(){return sidewalks;}

    public void setRoads(List<Road> roads) {
            this.roads = roads;
    }
    public void setSidewalks(List<Sidewalk> sidewalks){this.sidewalks=sidewalks;}
    public boolean isEmpty(Position position) {
        for (Sidewalk s:sidewalks){
            for (Tree e: s.getTrees()){
                if (e.getPosition().equals(position)) {
                    return false;
                }
            }
        }
        /*for (Road r:roads){
            for (Car c: r.getCars()){
                if (c.getPosition().equals(position)) {
                    return false;
                }
            }
        }*/
        return (position.getX() < width && position.getY() < height && position.getX() >= 0 && position.getY() >= 0);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#332244"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        chicken.draw(graphics);
    }
    public void LineCreator() {
        int i = 3;
        List<Road> roads = new ArrayList<>();
        List<Sidewalk> sidewalks = new ArrayList<>();
        while (i >= 3 && i < 31){
            if((i+3) % 5 == 0){
                Sidewalk ns = new Sidewalk(i++);
                sidewalks.add(ns);
            }
            else {
                Road nr = new Road(i++);
                nr.generateCars((i%5>2));
                roads.add(nr);
            }
        }
        setSidewalks(sidewalks);
        RandomizeSidewalks();
        setRoads(roads);

    }
    public void RandomizeSidewalks(){
        for(Sidewalk s:sidewalks){
            s.randomizeTrees();
        }
    }

}
