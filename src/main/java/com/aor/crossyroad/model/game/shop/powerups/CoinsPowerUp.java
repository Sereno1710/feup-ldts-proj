package com.aor.crossyroad.model.game.shop.powerups;

public class CoinsPowerUp implements PowerUp {
    private final int bonusMultiplier;
    private final long totalTime;

    public CoinsPowerUp(int bonusMultiplier, long totalTime) {
        this.bonusMultiplier = bonusMultiplier;
        this.totalTime = totalTime;
    }

    @Override
    public void activate() {
        // bonusMultiplier x coins during totalTime
    }
}
