package com.aor.crossyroad.controller.shop;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.shop.powerups.PowerUp;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.PowerUpsState;

import java.io.IOException;

public class PowerUpController extends Controller<PowerUp> {
    public PowerUpController(PowerUp model) {
        super(model);
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
                if (getModel().isSelectedExit()){
                    game.setState(getModel().getGameState());
                }
                else if(getModel().isSelectedAddTime()){
                    getModel().buyAddedTime(getModel().getGameState());
                }
        }
    }
}
