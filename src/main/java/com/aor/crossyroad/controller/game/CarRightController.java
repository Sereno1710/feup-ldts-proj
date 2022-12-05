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
                    verifyPosCar(c,c.getPosition().getRight());
            this.lastMovement = time;
        }
    }
    private void verifyPosCar(Car car, Position position) {
        if(position.getX()>=99){
            car.setPosition(new Position(2,position.getY()));
        }
        else {car.setPosition(new Position(car.getPosition().getX()+1, position.getY()));}
    }
}
