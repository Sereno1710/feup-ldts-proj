package com.aor.crossyroad.controller.game;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }

}
