package com.aor.crossyroad.model.game.elements.cars;

import com.aor.crossyroad.model.game.elements.Element;

public abstract class Car extends Element {
    public Car(int x, int y) {
        super(x, y);
    }
    public abstract void move();
}
