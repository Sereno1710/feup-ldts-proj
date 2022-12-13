package com.aor.crossyroad.model.game.elements;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Element;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Chicken extends Element {
    private char direction; // &-> back, *-> front, / -> left , %->right
    public Chicken(int x, int y){
        super(x,y);
        direction='&';
    }
    public char getDirection() {
        return direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }
}
