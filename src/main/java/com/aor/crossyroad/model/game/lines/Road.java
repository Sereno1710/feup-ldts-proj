package com.aor.crossyroad.model.game.lines;

import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.elements.cars.CarLeft;
import com.aor.crossyroad.model.game.elements.cars.CarRight;
import com.aor.crossyroad.model.game.lines.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Road extends Line {
    private List<Car> cars;
    public Road(int y) {
        super(y, 'R');
        cars=new ArrayList<Car>();
    }

    public List<Car> getCars() {
        return cars;
    }
    public void generateCars(boolean gen) {
        for (int i = 0; i < 3; i++) {
                Car c;
                if (gen) {
                    //left heading
                    c = new CarLeft(new Random().nextInt(100), getY());
                } else {
                    //True - right heading
                    c = new CarRight(new Random().nextInt(100), getY());
                }
                cars.add(c);

        }
    }

}
