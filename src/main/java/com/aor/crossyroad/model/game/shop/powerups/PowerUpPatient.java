package com.aor.crossyroad.model.game.shop.powerups;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;

public interface PowerUpPatient {
     void activate(Arena arena);
     Position getNextSafezone();
     void setNextSafezone(Position nextSafezone);
}
