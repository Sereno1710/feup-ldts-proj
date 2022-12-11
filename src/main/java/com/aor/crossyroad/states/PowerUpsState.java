package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.shop.PowerUpController;
import com.aor.crossyroad.model.game.shop.powerups.PowerUp;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.shop.PowerUpViewer;


public class PowerUpsState extends State<PowerUp>{
    public PowerUpsState(PowerUp powerUp) {
        super(powerUp);
    }
    @Override
    protected Viewer<PowerUp> getViewer() {
        return new PowerUpViewer(getModel());
    }
    @Override
    protected Controller<PowerUp> getController(){
        return new PowerUpController(getModel());
    }
}
