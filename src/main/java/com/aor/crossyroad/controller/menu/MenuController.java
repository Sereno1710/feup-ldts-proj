package com.aor.crossyroad.controller.menu;
import com.aor.crossyroad.Game;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.states.GameState;
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
                if (getModel().isSelectedExit()) {game.setState(null);break;}
                if (getModel().isSelectedStart()&& getModel().getOption(0).equals("Play Again")){
                    GameState gameState= new GameState(new Arena(40,40));
                    gameState.getModel().setCoinAmount(getModel().coins/2);
                    game.setState(gameState);
                }
                else  {game.setState(new GameState(new Arena(40,40)));}
        }
    }
}