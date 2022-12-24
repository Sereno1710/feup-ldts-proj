package com.aor.crossyroad.model.game.shop;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.states.GameState;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Shop {
    private Position position;
    private final GameState gameState;
    private final List<String> options;
    private int currentOption=0;
    public Shop(GameState gameState){
        this.options= Arrays.asList("Power-Ups","Skins","Exit");
        position = new Position(20,37);
        this.gameState = gameState;

    }
    public Position getPosition() {
        return position;
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
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return position.equals(shop.position) && gameState.equals( shop.gameState) && options.equals(shop.options);
        //return currentOption == shop.currentOption && position.equals(shop.position) && gameState.equals( shop.gameState) && options.equals(shop.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, gameState, options, currentOption);
    }
}
