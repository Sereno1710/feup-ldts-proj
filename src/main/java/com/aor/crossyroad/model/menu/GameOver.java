package com.aor.crossyroad.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver extends MenuPhases {
    private Integer coins;
    private int currentOption=0;


    public GameOver(String coins,String score) {
        super(Arrays.asList("Play Again","Exit","Coins: " + coins,"Score: "+ score));
        this.coins= Integer.parseInt(coins);
    }
    public Integer getCoins() {
        return coins;
    }
    @Override
    public void nextOption() {currentOption++;if (currentOption > 1) currentOption = 0;}
    @Override
    public void previousOption() {currentOption--;if (currentOption < 0) currentOption = 1;}
    @Override
    public String getOption(int i) {
        return getOptions().get(i);
    }
    @Override
    public boolean isSelected(int i) {
        return currentOption == i;
    }
    @Override
    public boolean isSelectedExit() {
        return isSelected(1);
    }
    @Override
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    @Override
    public int getNumberOptions() {
        return this.getOptions().size();
    }
}
