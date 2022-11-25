package com.aor.crossyroad.controller.game;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.states.MenuState;


import java.io.IOException;

public class ArenaController extends GameController {
    private final ChickenController chickenController;
    private final CarRightController carRightController;
    private final CarLeftController carLeftController;

    public ArenaController(Arena arena) {
        super(arena);

        this.chickenController = new ChickenController(arena);
        this.carRightController = new CarRightController(arena);
        this.carLeftController = new CarLeftController(arena);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        if (action == LanternaGUI.ACTION.QUIT) {
            game.setState(new MenuState(new Menu()));
        }
        else {
            chickenController.step(game, action, time);
            carRightController.step(game, action, time);
            carLeftController.step(game,action,time);
        }
    }
}
