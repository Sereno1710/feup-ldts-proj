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
        for (int i = 0; i < 4; i++)
            lanternaGUI.drawText(new Position(5, 15 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
    }

    @Override
    protected void drawLines(LanternaGUI lanternaGUI) {

    }
}
