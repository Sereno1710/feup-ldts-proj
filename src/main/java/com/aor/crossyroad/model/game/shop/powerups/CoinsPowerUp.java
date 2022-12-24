package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.game.arena.Arena;

public class CoinsPowerUp implements PowerUpImmediate {
    private static final long totalTime = 1350;
    private static final int cost = 15;
    private static final int bonusMultiplier = 2;
    public static int getCost() {
        return cost;
    }

    public void applyPowerUp(Arena arena) {
        arena.setCoinMultiplier(bonusMultiplier, totalTime);
        arena.setSpecialUp(true);
    }

}
