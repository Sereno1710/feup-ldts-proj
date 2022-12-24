package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.game.arena.Arena;

public class AddTimePowerUp implements PowerUpImmediate {
    private static final long addedTime = 150;
    private static final int cost = 10;

    public static int getCost() {
        return cost;
    }

    public void applyPowerUp(Arena arena) {
        arena.setDefaultTime(addedTime + arena.getDefaultTime());
    }

}
