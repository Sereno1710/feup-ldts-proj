package com.aor.crossyroad.model.game.shop;

import com.aor.crossyroad.states.ShopState;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Skins {
    private final List<String> options;
    private final ShopState shopState;
    private int currentOption=0;
    public Skins(ShopState shopState) {
        this.options = Arrays.asList("Yellow (Default)","Blue","White","Exit");
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
    public boolean isSelectedDefault() {
        return isSelected(0);
    }
    public boolean isSelectedBlue() {
        return isSelected(1);
    }
    public boolean isSelectedWhite() {
        return isSelected(2);
    }
    public ShopState getShopState() {
        return this.shopState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skins skins = (Skins) o;
        return currentOption==skins.currentOption && options.equals(skins.options) && shopState.equals(skins.getShopState());

        //return currentOption==skins.currentOption && options.equals(skins.options) || shopState.equals(skins.getShopState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, shopState, currentOption);
    }
}
