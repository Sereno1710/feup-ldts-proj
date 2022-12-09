package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.game.ArenaController;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }
    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }
    @Override
    protected Controller<Arena> getController(){
        return new ArenaController(getModel(), this);
    }
}