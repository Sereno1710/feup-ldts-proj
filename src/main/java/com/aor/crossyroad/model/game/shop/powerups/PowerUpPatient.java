package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;

public interface PowerUpPatient {
    public void activate(Arena arena);
    public Position getNextSafezone();
    public void setNextSafezone(Position nextSafezone);
}
