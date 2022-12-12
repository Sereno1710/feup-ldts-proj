package com.aor.crossyroad.model.game.shop.powerups;

public class CoinsPowerUp implements PowerUpImmediate {
    private final int bonusMultiplier;
    private final long totalTime;
    private final int cost=30;
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

    @Override
    public void applyPowerUp() {

    }
}
