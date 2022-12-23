package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.cars.Car;

public class CarRightViewer implements ElementViewer<Car> {

    @Override
    public void draw(Car element, LanternaGUI lanternaGui) {
        lanternaGui.drawCarRight(element.getPosition());
    }

}
