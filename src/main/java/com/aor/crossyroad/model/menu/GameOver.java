package com.aor.crossyroad.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver extends MenuPhases {
    private Integer coins;
    private List<String> results;
    private int currentOption=0;
    public GameOver(String coins,String score) {
        super(Arrays.asList("Play Again","Exit"));
        this.coins= Integer.parseInt(coins);
        this.results= Arrays.asList("Coins lost: " + coins,"Score: "+ score);
    }
    public Integer getCoins() {
        return coins;
    }
    public List<String> getResults() {
        return results;
    }
}
