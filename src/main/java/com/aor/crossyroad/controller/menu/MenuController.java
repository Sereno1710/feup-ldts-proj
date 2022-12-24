package com.aor.crossyroad.controller.menu;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.InstructionsState;
import java.util.Random;

public class MenuController extends Controller<Menu> {
    private long lastMovement=0;
    public MenuController(Menu menu) {
        super(menu);
    }

    public void setLastMovement(long lastMovement) {
        this.lastMovement = lastMovement;
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        switch (action) {
            case NONE:
                if(time-lastMovement > 300){
                    lastMovement=time;
                    RandomMovement();
                }
                break;
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelected(2)) {game.setState(null);break;}
                if (getModel().isSelected(1)) {game.setState(new InstructionsState(new InstructionsMenu()));}
                if (getModel().isSelected(0)){game.setState(new GameState(new Arena(40,40)));}
        }
    }
    public void RandomMovement(){
        Random random= new Random();
        int ran= random.nextInt(4);
        switch (ran) {
            case 0 :{
                if (getModel().getChicken().getPosition().getY() + 1 < 30)
                    getModel().getChicken().setPosition(getModel().getChicken().getPosition().getDown());
                getModel().getChicken().setDirection('*');
                break;
            }
            case 1 : {
                if (getModel().getChicken().getPosition().getY() - 1 > 22)
                    getModel().getChicken().setPosition(getModel().getChicken().getPosition().getUp());
                getModel().getChicken().setDirection('&');
            }
            case 2 : {
                if (getModel().getChicken().getPosition().getX() - 1 > 2)
                    getModel().getChicken().setPosition(getModel().getChicken().getPosition().getLeft());
                getModel().getChicken().setDirection('/');
            }
            case 3 : {
                if (getModel().getChicken().getPosition().getX() + 1 < 35)
                    getModel().getChicken().setPosition(getModel().getChicken().getPosition().getRight());
                getModel().getChicken().setDirection('%');
            }
        }
    }
}