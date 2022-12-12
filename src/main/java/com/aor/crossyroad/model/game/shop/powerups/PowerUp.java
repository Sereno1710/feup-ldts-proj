package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.states.GameState;
import java.util.Arrays;
import java.util.List;

public class PowerUp {
    private final List<String> options;
    private final GameState gameState;
    private final AddTimePowerUp addTimePowerUp;
    private final CoinsPowerUp coinsPowerUp;
    private final ToNextSafezonePowerUp toNextSafezonePowerUp;
    private int currentOption=0;
    public PowerUp(GameState gameState){
        this.options= Arrays.asList("Add Time","x2 Coins","Teleport","Exit");
        this.gameState=gameState;
        addTimePowerUp =new AddTimePowerUp(150);
        coinsPowerUp = new CoinsPowerUp(2,900);
        toNextSafezonePowerUp =new ToNextSafezonePowerUp();
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

    public void buyToNextSafeZonePowerUp(GameState gameState){
        if (canBuy(10)){
            gameState.getModel().setCoinAmount(gameState.getModel().getCoinAmount()-10);
            if (!gameState.getModel().checkSafeIsBottom(getGameState().getModel().getChicken().getPosition())){
                gameState.getModel().getChicken().setPosition(new Position(20,2));
            }
            gameState.getModel().setLastSafe(gameState.getModel().getChicken());
        }
    }
    public boolean canBuy(int x){
        return gameState.getModel().getCoinAmount() >= x;
    }
}
