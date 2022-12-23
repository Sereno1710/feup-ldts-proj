package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;

public class NextSafezonePowerUp implements PowerUpPatient {
    private Position nextSafezone;
    private static final int cost = 20;
    public NextSafezonePowerUp(Position nextSafezone) {
        this.nextSafezone = nextSafezone;
    }
    public static int getCost() {
        return cost;
    }
    @Override
    public void setNextSafezone(Position nextSafezone) {
        this.nextSafezone = nextSafezone;
    }
    @Override
    public Position getNextSafezone() {
        return nextSafezone;
    }

    @Override
    public void activate(Arena arena) {
        arena.setChicken(new Chicken(nextSafezone.getX(), nextSafezone.getY()));
    }

}
