package com.aor.crossyroad.viewer.shop;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.shop.powerups.PowerUp;
import com.aor.crossyroad.viewer.Viewer;

public class PowerUpViewer extends Viewer<PowerUp> {
    public PowerUpViewer(PowerUp powerUp){
        super(powerUp);
    }
    @Override
    protected void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(5, 15 ), getModel().getOption(0), getModel().isSelected(0) ? getModel().canBuy(20) ? "#39FF14":"#FF0000" :"#FFFFFF" );
        lanternaGUI.drawText(new Position(5, 15 + 1), getModel().getOption(1), getModel().isSelected(1) ? getModel().canBuy(30)? "#39FF14":"#FF0000" :"#FFFFFF" );
        lanternaGUI.drawText(new Position(5, 15 + 2), getModel().getOption(2), getModel().isSelected(2) ? getModel().canBuy(10)? "#39FF14":"#FF0000" :"#FFFFFF" );
        lanternaGUI.drawText(new Position(5, 15 + 3), getModel().getOption(3), getModel().isSelected(3)? "#39FF14" :"#FFFFFF" );
    }
    @Override
    protected void drawLines(LanternaGUI lanternaGUI) {
      //do nothing
    }
}
