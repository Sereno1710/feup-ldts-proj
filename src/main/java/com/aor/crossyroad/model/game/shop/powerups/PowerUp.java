package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.states.GameState;
import java.util.Arrays;
import java.util.List;

public class PowerUp {
    private List<String> options;
    private GameState gameState;
    private AddTimePowerUp addTimePowerUp;
    private CoinsPowerUp coinsPowerUp;
    private int currentOption=0;
    public PowerUp(GameState gameState){
        this.options= Arrays.asList("Add Time","x2 Coins","Teleport","Exit");
        this.gameState=gameState;
        addTimePowerUp =new AddTimePowerUp(150);
        coinsPowerUp = new CoinsPowerUp(2,900);
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
        return isSelected(3);
    }
    public boolean isSelectedAddTime() {
        return isSelected(0);
    }
    public boolean isSelectedx2Coins() {
        return isSelected(1);
    }
    public boolean isSelectedTeleport() {
        return isSelected(2);
    }
    public GameState getGameState() {
        return this.gameState;
    }
    public void buyAddedTime(GameState gameState){
        if(canBuy(20)){
            gameState.getModel().setCoinAmount((gameState.getModel().getCoinAmount()-20));
            gameState.getModel().setDefaultTime(addTimePowerUp.getAddedTime()+gameState.getModel().getDefaultTime());
        }
    }
    public void buyCoinsPowerUp(GameState gameState){
        if(canBuy(30)){
            gameState.getModel().setCoinAmount(gameState.getModel().getCoinAmount()-30);
            gameState.getModel().setCoinMultiplier(coinsPowerUp.getBonusMultiplier(),coinsPowerUp.getTotalTime());
        }
    }
    public boolean canBuy(int x){
        return gameState.getModel().getCoinAmount() >= x;
    }
}
