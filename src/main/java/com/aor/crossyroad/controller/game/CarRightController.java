package com.aor.crossyroad.controller.game;
import com.aor.crossyroad.Game;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Road;


import java.io.IOException;

public class CarRightController extends GameController {
    private long lastMovement=0;
    public CarRightController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 300) {
            for (Road i : getModel().getRoadsRight())
                for (Car c: i.getCars())
                    if (moveCar(c, c.getPosition().getRight())){
                        c.setPosition(c.getPosition().getRight());
                    }
            this.lastMovement = time;
        }
    }

    private boolean moveCar(Car car, Position position) {
        if(position.getX()>=99){
            car.setPosition(new Position(2,position.getY()));}
        if (getModel().isEmpty(position)) {
            if (!getModel().getChicken().getPosition().equals(position))
                return true;
        }
        return false;
    }
}
