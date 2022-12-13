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
}
