package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.cars.Car;

public class CarViewer implements ElementViewer<Car> {
    @Override
    public void draw(Car car, LanternaGUI lanternaGUI) {
        lanternaGUI.drawCar(car.getPosition());
    }
}
