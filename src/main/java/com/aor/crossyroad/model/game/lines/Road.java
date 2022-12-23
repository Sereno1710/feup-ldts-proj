package com.aor.crossyroad.model.game.lines;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Coin;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.elements.cars.CarLeft;
import com.aor.crossyroad.model.game.elements.cars.CarRight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Road extends Line {
    private List<Car> cars;
    private List<Coin> coins;

    public Road(int y) {
        super(y);
        cars=new ArrayList<Car>();
        coins=new ArrayList<Coin>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


    public void generateCars(boolean gen) {
        for (int i = 0; i < 3; i++) {
                Car c;
                if (gen) {
                    //left heading
                    c = new CarLeft(new Random().nextInt(40), getY());
                } else {
                    //True - right heading
                    c = new CarRight(new Random().nextInt(40), getY());
                }
                cars.add(c);

        }
    }
    public void clearCoins(){
        coins=new ArrayList<Coin>();
    }
    public void removeCoin(Position position){
        for (Coin c:coins){
            if (c.getPosition().equals(position)){
                coins.remove(c);
                break;
            }
        }
    }
    public void addCoin(){
        Random r=new Random();
        int randNum=1+r.nextInt(38);
        Coin c =new Coin(randNum,getY());
        coins.add(c);
    }
    public List<Coin> getCoins(){
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
}
