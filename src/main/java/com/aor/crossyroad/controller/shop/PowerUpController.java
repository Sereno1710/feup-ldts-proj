package com.aor.crossyroad.controller.shop;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.menu.PowerUps;

import java.io.IOException;

public class PowerUpController extends Controller<PowerUps> {
    public PowerUpController(PowerUps model) {
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
                if (getModel().isSelectedExit()) {
                    game.setState(getModel().getShopState());
                }
                else if(getModel().isSelectedAddTime()) {
                    getModel().buyAddedTime();
                }
                else if(getModel().isSelectedx2Coins()){
                    getModel().buyCoinsPowerUp();
                }
                else if(getModel().isSelectedTeleport()){
                    getModel().buyNextSafezonePowerUp();
                }
        }
    }
}
