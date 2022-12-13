package com.aor.crossyroad.controller.menu;
import com.aor.crossyroad.Game;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.IntructionsState;

import java.io.IOException;
public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelected(2)) {game.setState(null);break;}
                if (getModel().isSelected(1)) {game.setState(new IntructionsState(new InstructionsMenu()));}
                if (getModel().isSelected(0)){game.setState(new GameState(new Arena(40,40)));}
        }
    }
}