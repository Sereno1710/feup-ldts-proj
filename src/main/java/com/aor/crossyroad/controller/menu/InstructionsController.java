package com.aor.crossyroad.controller.menu;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller <InstructionsMenu>{
    public InstructionsController(InstructionsMenu model) {
        super(model);
    }
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        if ( action == LanternaGUI.ACTION.SELECT) game.setState(new MenuState(new Menu()));
    }

}
