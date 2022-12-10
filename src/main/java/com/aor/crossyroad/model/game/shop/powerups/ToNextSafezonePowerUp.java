package com.aor.crossyroad.model.game.shop.powerups;

public class ToNextSafezonePowerUp implements PowerUp {
    private final char nextSafe;

    public ToNextSafezonePowerUp(char nextSafe) {
        this.nextSafe = nextSafe;
    }
    @Override
    public void activate() {
        // teleport to next safezone
    }
}
