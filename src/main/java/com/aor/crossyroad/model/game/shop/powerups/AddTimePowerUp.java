package com.aor.crossyroad.model.game.shop.powerups;

public class AddTimePowerUp {
    private final long addedTime;
    private final int cost=20;
    public AddTimePowerUp(long addedTime) {
        this.addedTime = addedTime;
    }
    public long getAddedTime(){
        return addedTime;
    }

    public int getCost() {
        return cost;
    }
}
