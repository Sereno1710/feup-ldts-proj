package com.aor.crossyroad.model.game.shop.powerups;

public class AddTimePowerUp implements PowerUpImmediate {
    private final long addedTime;
    private final int cost = 1;
    public AddTimePowerUp(long addedTime) {
        this.addedTime = addedTime;
    }
    public long getAddedTime(){
        return addedTime;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public void applyPowerUp() {

    }
}
