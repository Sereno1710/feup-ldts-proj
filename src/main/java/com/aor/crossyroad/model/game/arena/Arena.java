package com.aor.crossyroad.model.game.arena;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.Coin;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.powerups.PowerUp;
import com.aor.crossyroad.states.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Arena {
    private long totalTime=0;
    private int bonusMultiplier=1;
    private final int width;
    private final int height;
    private char lastSafe;
    private Chicken chicken;
    private List<Sidewalk> sidewalks;
    private List<Road> roadsLeft;
    private List<Road> roadsRight;
    private Integer coinAmount=0;
    private Integer score=0;
    private Shop shop;
    private long DefaultTime = 900;
    private long time;
    private List<PowerUp> powerUps;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        LineCreator();
        chicken = new Chicken(width / 2, height -6);
        lastSafe = 'B';
        shop = new Shop(new GameState(this));
        powerUps = new ArrayList<>();
        time =1050;
    }

    public void addPowerUp(PowerUp powerUp) {
        powerUps.add(powerUp);
    }
    public Integer getCoinAmount() {
        return coinAmount;
    }
    public Integer getScore(){return score;}
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
            for (Coin c: rl.getCoins()){
                if (c.getPosition().equals(position)) {
                    rl.removeCoin(c.getPosition());
                    coinAmount=coinAmount+1*bonusMultiplier;
                    break;
                }
            }
        }
        for (Road rr:roadsRight){
            for (Car cr: rr.getCars()){
                if (cr.getPosition().equals(position))
                    return true;}
            for (Coin c: rr.getCoins()){
                if (c.getPosition().equals(position)) {
                    rr.removeCoin(c.getPosition());
                    coinAmount=coinAmount+1*bonusMultiplier;
                    break;
                }
            }
        }
        return false;
    }
    public void LineCreator() {
        int i = 4; //starts after safezone, ends before one
        List<Road> roadsLeft = new ArrayList<Road>();
        List<Road> roadsRight=new ArrayList<Road>();
        List<Sidewalk> sidewalks = new ArrayList<>();
        while (i >=  4 && i <= 31){
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
        RandomizeCoins();
    }
    public void tickTime(){
        this.time--;
        this.totalTime--;
        checkTotalBonusTime();
    }
    public void resetTime(){
        time=getDefaultTime();
    }
    public long getTime() {
        return time;
    }
    public void RandomizeSidewalks(){
        for(Sidewalk s:sidewalks){
            s.randomizeTrees();
        }
    }
    public void RandomizeCoins(){
        for(Road r:roadsLeft){
            r.clearCoins();
        }
        for(Road r:roadsRight){
            r.clearCoins();
        }
        for(int i=0;i<2;i++){
            Random r=new Random();
            int randNum=r.nextInt(roadsLeft.size());
            roadsLeft.get(randNum).addCoin();
            r=new Random();
            randNum=r.nextInt(roadsRight.size());
            roadsRight.get(randNum).addCoin();
        }
    }
    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public boolean checkSafeIsTop(Position position) {
        return (position.getY() <= 3 && lastSafe != 'T');
    }

    public boolean checkSafeIsBottom(Position position) {
        return (position.getY() >= 32 && lastSafe != 'B');
    }

    public void setLastSafe(Chicken chicken) {
        if (checkSafeIsTop(chicken.getPosition())) {
            lastSafe = 'T';
            afterReachingSafe();
        }
        else if (checkSafeIsBottom(chicken.getPosition())) {
            lastSafe = 'B';
            afterReachingSafe();
        }
    }
    public void afterReachingSafe(){
        score++;
        resetTime();
        for (int i = 0; i < sidewalks.size(); i++) {
            sidewalks.get(i).randomizeTrees();
        }
    }
    public Shop getShop(){
        return shop;
    }

    public void setCoinAmount(Integer i) {
        coinAmount=i;
    }

    public long getDefaultTime() {
        return DefaultTime;
    }

    public void setDefaultTime(long defaultTime) {
        DefaultTime = defaultTime;
    }

    public void setCoinMultiplier(int bonusMultiplier, long totalTime) {
        this.bonusMultiplier=bonusMultiplier;
        this.totalTime=totalTime;
    }
    public void checkTotalBonusTime(){
        if (totalTime ==0){
            setCoinMultiplier(1,0);
        }
    }
}
