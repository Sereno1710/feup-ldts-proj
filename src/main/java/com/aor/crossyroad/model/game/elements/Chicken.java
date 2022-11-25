package com.aor.crossyroad.model.game.elements;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Element;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Chicken extends Element {
    public Chicken(int x, int y){
        super(x,y);
    }
    public Position getChicken() {
        return getPosition();
    }
    public Position MoveUp(){
        return new Position(getPosition().getX(), getPosition().getY()-1);
    }
    public Position MoveDown(){
        return new Position(getPosition().getX(), getPosition().getY()+1);
    }
    public Position MoveLeft(){
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position MoveRight(){
        return new Position(getPosition().getX()+1, getPosition().getY());
    }
    public void draw(TextGraphics graphics){
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), TextCharacter.fromCharacter('X')[0]);
    }

}
