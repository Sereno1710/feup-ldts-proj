package com.aor.crossyroad.model.game.shop.powerups;

public class CoinsPowerUp {
    private final int bonusMultiplier;
    private final long totalTime;

    public CoinsPowerUp(int bonusMultiplier, long totalTime) {
        this.bonusMultiplier = bonusMultiplier;
        this.totalTime = totalTime;
    }

    public int getBonusMultiplier() {
        return bonusMultiplier;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
