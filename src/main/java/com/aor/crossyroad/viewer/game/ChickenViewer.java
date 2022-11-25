package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Chicken;

public class ChickenViewer implements ElementViewer<Chicken>{
    @Override
    public void draw(Chicken chicken, LanternaGUI lanternaGUI) {
        lanternaGUI.drawChicken(chicken.getPosition());
    }
}
