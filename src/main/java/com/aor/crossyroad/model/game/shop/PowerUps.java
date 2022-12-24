package com.aor.crossyroad.model.game.shop;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.powerups.AddTimePowerUp;
import com.aor.crossyroad.model.game.shop.powerups.CoinsPowerUp;
import com.aor.crossyroad.model.game.shop.powerups.NextSafezonePowerUp;
import com.aor.crossyroad.states.ShopState;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PowerUps {
    private final List<String> options;
    private final ShopState shopState;
    private int currentOption=0;
    private Arena arena;
    public PowerUps(ShopState shopState) {
        this.options = Arrays.asList("Add Time","x2 Coins","Teleport","Exit");
        this.shopState = shopState;
        arena=shopState.getModel().getGameState().getModel();
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
            arena.setCoinAmount(arena.getCoinAmount() - AddTimePowerUp.getCost());
            AddTimePowerUp addTimePowerUp = new AddTimePowerUp();
            addTimePowerUp.applyPowerUp(shopState.getModel().getGameState().getModel());
        }
    }
    public void buyCoinsPowerUp() {
        if (canBuy(CoinsPowerUp.getCost())) {
            arena.setCoinAmount(arena.getCoinAmount() - CoinsPowerUp.getCost());
            CoinsPowerUp coinsPowerUp = new CoinsPowerUp();
            coinsPowerUp.applyPowerUp(arena);
        }
    }
    public void buyNextSafezonePowerUp() {
        if (canBuy(NextSafezonePowerUp.getCost())) {
            arena.setCoinAmount(arena.getCoinAmount() - NextSafezonePowerUp.getCost());
            if (!arena.checkSafeIsBottom(arena.getChicken().getPosition())) {
                NextSafezonePowerUp nextSafezonePowerUp = new NextSafezonePowerUp(new Position(20, 2));
                arena.addPowerUp(nextSafezonePowerUp);
            }
        }
    }
    public boolean canBuy(int cost) {
        return arena.getCoinAmount() >= cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerUps powerUps = (PowerUps) o;
        return currentOption == powerUps.currentOption && options.equals(powerUps.options) && shopState.equals(powerUps.shopState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, shopState, currentOption);
    }

    public int getCurrentOption() {return  currentOption;
    }
}
