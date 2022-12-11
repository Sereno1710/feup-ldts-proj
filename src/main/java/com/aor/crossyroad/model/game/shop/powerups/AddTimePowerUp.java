package com.aor.crossyroad.model.game.shop.powerups;

public class AddTimePowerUp {
    private final long addedTime;
    public AddTimePowerUp(long addedTime) {
        this.addedTime = addedTime;
    }
    public long getAddedTime(){
        return addedTime;
    }
}
