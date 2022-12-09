package com.aor.crossyroad.model.game.shop;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop{
    private Position position;
    private List<String> options;
    private int currentOption=0;
    public Shop(){
        this.options= Arrays.asList("Power-Ups","Skins","Exit");
    }
    public Shop(int x,int y){
        position=new Position(2,38);
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<String> getOptions() {
        return options;
    }
    public void nextOption() {currentOption++;if (currentOption > this.options.size() - 1) currentOption = 0;}
    public void previousOption() {currentOption--;if (currentOption < 0) currentOption = this.options.size() - 1;}
    public String getOption(int i) {
        return options.get(i);
    }
    public boolean isSelected(int i) {
        return currentOption == i;
    }
    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedPowerUp() {
        return isSelected(0);
    }
    public boolean isSelectedSkins() {
        return isSelected(1);
    }
    public int getNumberOptions() {
        return this.options.size();
    }
}
