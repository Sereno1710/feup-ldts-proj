package com.aor.crossyroad.model.game.elements;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Element;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Chicken extends Element {
    private static String color = "#FFFF00";
    private char direction; // &-> back, *-> front, / -> left , % -> right
    public Chicken(int x, int y){
        super(x, y);
        direction = '&';
    }
    public char getDirection() {
        return direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }
    public static String getColor() {
        return color;
    }
    public static void setColor(String color) {
        Chicken.color = color;
    }
}
