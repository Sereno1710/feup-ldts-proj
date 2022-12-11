package com.aor.crossyroad.controller.game;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Road;


import java.io.IOException;

public class CarLeftController extends GameController {
    private long lastMovement = 0;

    public CarLeftController(Arena arena) {
        super(arena);
    }

    //falta um getCars na arena ou no Roads
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 300/(1+getModel().getScore()/10.0)) {
            for (Road i : getModel().getRoadsLeft())
                for (Car c : i.getCars())
                        verifyPosCar(c,c.getPosition().getLeft());
            this.lastMovement = time;
        }
    }
    private void verifyPosCar(Car car, Position position) {
        if (position.getX() <0) {
            car.setPosition(new Position(100, position.getY()));
        }
        else {car.setPosition(new Position(car.getPosition().getX()-1,position.getY() ));}
    }
}

