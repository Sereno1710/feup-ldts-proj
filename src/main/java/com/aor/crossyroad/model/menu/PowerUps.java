package com.aor.crossyroad.model.menu;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Coin;
import com.aor.crossyroad.model.game.shop.powerups.AddTimePowerUp;
import com.aor.crossyroad.model.game.shop.powerups.CoinsPowerUp;
import com.aor.crossyroad.model.game.shop.powerups.NextSafezonePowerUp;
import com.aor.crossyroad.states.ShopState;

import java.util.Arrays;
import java.util.List;

public class PowerUps {
    private final List<String> options;
    private final ShopState shopState;
    private int currentOption=0;
    public PowerUps(ShopState shopState) {
        this.options = Arrays.asList("Add Time","x2 Coins","Teleport","Exit");
        this.shopState = shopState;
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
    public ShopState getShopState() {
        return this.shopState;
    }
    public void buyAddedTime() {
        if (canBuy(AddTimePowerUp.getCost())) {
            shopState.getModel().getGameState().getModel().setCoinAmount(shopState.getModel().getGameState().getModel().getCoinAmount() - AddTimePowerUp.getCost());
            AddTimePowerUp addTimePowerUp = new AddTimePowerUp();
            addTimePowerUp.applyPowerUp(shopState.getModel().getGameState().getModel());
        }
    }
    public void buyCoinsPowerUp() {
        if (canBuy(CoinsPowerUp.getCost())) {
            shopState.getModel().getGameState().getModel().setCoinAmount(shopState.getModel().getGameState().getModel().getCoinAmount() - CoinsPowerUp.getCost());
            CoinsPowerUp coinsPowerUp = new CoinsPowerUp();
            coinsPowerUp.applyPowerUp(shopState.getModel().getGameState().getModel());
        }
    }
    public void buyNextSafezonePowerUp() {
        if (canBuy(NextSafezonePowerUp.getCost())) {
            shopState.getModel().getGameState().getModel().setCoinAmount(shopState.getModel().getGameState().getModel().getCoinAmount() - NextSafezonePowerUp.getCost());
            if (!shopState.getModel().getGameState().getModel().checkSafeIsBottom(shopState.getModel().getGameState().getModel().getChicken().getPosition())) {
                NextSafezonePowerUp nextSafezonePowerUp = new NextSafezonePowerUp(new Position(20, 2));
                shopState.getModel().getGameState().getModel().addPowerUp(nextSafezonePowerUp);
            }
        }
    }
    public boolean canBuy(int cost) {
        return shopState.getModel().getGameState().getModel().getCoinAmount() >= cost;
    }
}
