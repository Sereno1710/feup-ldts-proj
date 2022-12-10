package com.aor.crossyroad.model.game.shop.powerups;

public class AddTimePowerUp implements PowerUp {

    private final long addedTime;
    public AddTimePowerUp(long addedTime) {
        this.addedTime = addedTime;
    }
    @Override
    public void activate() {
        // add addedTime to time left
    }
}
