package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.shop.PowerUpController;
import com.aor.crossyroad.model.menu.PowerUps;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.shop.PowerUpViewer;


public class PowerUpsState extends State<PowerUps>{
    public PowerUpsState(PowerUps powerUps) {
        super(powerUps);
    }
    @Override
    protected Viewer<PowerUps> getViewer() {
        return new PowerUpViewer(getModel());
    }
    @Override
    protected Controller<PowerUps> getController(){
        return new PowerUpController(getModel());
    }
}
