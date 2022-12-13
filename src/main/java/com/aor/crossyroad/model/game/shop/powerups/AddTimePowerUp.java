package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.game.arena.Arena;

public class AddTimePowerUp implements PowerUpImmediate {
    private static final long addedTime = 150;
    private static final int cost = 10;
    public static long getAddedTime(){
        return addedTime;
    }

    public static int getCost() {
        return cost;
    }

    @Override
    public void applyPowerUp(Arena arena) {
        arena.setDefaultTime(addedTime + arena.getDefaultTime());
    }
}
