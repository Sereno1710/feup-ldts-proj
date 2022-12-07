package com.aor.crossyroad.model.game.arena;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import java.util.ArrayList;
import java.util.List;
public class Arena {
    private final int width;
    private final int height;
    private char lastSafe;
    private Chicken chicken;
    private List<Sidewalk> sidewalks;
    private List<Road> roadsLeft;
    private List<Road> roadsRight;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        LineCreator();
        chicken = new Chicken(width / 2, height - 7);
        lastSafe = 'B';
    }
    public Chicken getChicken() {
        return chicken;
    }
    public List<Road> getRoadsLeft() {
        return roadsLeft;
    }
    public List<Road> getRoadsRight(){
        return roadsRight;
    }
    public List<Sidewalk> getSidewalks(){return sidewalks;}
    public void setRoadsLeft(List<Road> roads) {
            this.roadsLeft = roads;
    }
    public void setRoadsRight(List<Road> roads) {
        this.roadsRight = roads;
    }
    public void setSidewalks(List<Sidewalk> sidewalks){this.sidewalks=sidewalks;}
    public boolean isEmpty(Position position) {
        for (Sidewalk s:sidewalks){
            for (Tree e: s.getTrees()){
                if (e.getPosition().equals(position)) return false;
            }
        }
        return (position.getX() < width-1 && position.getY() < height-1 && position.getX() > 0 && position.getY() > 0);
    }
    public boolean isCar(Position position) {
        for (Road rl:roadsLeft){
            for (Car cl: rl.getCars()){
                if (cl.getPosition().equals(position)) return true;
            }
        }
        for (Road rr:roadsRight){
            for (Car cr: rr.getCars()){
                if (cr.getPosition().equals(position))
                    return true;}
        }
        return false;
    }
    public void LineCreator() {
        int i = 3;
        List<Road> roadsLeft = new ArrayList<Road>();
        List<Road> roadsRight=new ArrayList<Road>();
        List<Sidewalk> sidewalks = new ArrayList<>();
        while (i >= 3 && i < 31){
            if((i+3) % 5 == 0){
                Sidewalk ns = new Sidewalk(i++);
                sidewalks.add(ns);
            }
            else {
                Road nr = new Road(i++);
                nr.generateCars((i%5>=2));
                if(i%5>=2)roadsLeft.add(nr);
                else roadsRight.add(nr);
            }
        }
        setSidewalks(sidewalks);
        RandomizeSidewalks();
        setRoadsLeft(roadsLeft);
        setRoadsRight(roadsRight);
    }
    public void RandomizeSidewalks(){
        for(Sidewalk s:sidewalks){
            s.randomizeTrees();
        }
    }
    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    private boolean checkSafeIsTop(Position position) {
        return (position.getY() <= 2 && lastSafe != 'T');
    }

    private boolean checkSafeIsBottom(Position position) {
        return (position.getY() >= 31 && lastSafe != 'B');
    }

    public void setLastSafe(Chicken chicken) {
        if (checkSafeIsTop(chicken.getPosition())) {
            lastSafe = 'T';
            for (int i = 0; i < sidewalks.size(); i++) {
                sidewalks.get(i).randomizeTrees();
            }
        }
        else if (checkSafeIsBottom(chicken.getPosition())) {
            lastSafe = 'B';
            for (int i = 0; i < sidewalks.size(); i++) {
                sidewalks.get(i).randomizeTrees();
            }
        }
    }
}
