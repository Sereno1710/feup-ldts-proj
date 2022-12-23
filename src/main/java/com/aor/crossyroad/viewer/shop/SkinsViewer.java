package com.aor.crossyroad.viewer.shop;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.shop.Skins;
import com.aor.crossyroad.viewer.Viewer;

import java.util.Objects;

public class SkinsViewer extends Viewer<Skins> {
    public SkinsViewer(Skins skins) {
        super(skins);
    }
    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(15,5),"SKINS","#FFD700");
        lanternaGUI.drawText(new Position(5, 15), getModel().getOption(0), getModel().isSelected(0) ? Objects.equals(Chicken.getColor(), "#FFFF00") ? "#FFFF00": "#39FF14" : "#FFFFFF");
        lanternaGUI.drawText(new Position(5, 15 + 1), getModel().getOption(1), getModel().isSelected(1) ? Objects.equals(Chicken.getColor(), "#1E90FF") ? "#FFFF00": "#39FF14" : "#FFFFFF");
        lanternaGUI.drawText(new Position(5, 15 + 2), getModel().getOption(2), getModel().isSelected(2) ? Objects.equals(Chicken.getColor(), "#FFFFFF") ? "#FFFF00": "#39FF14" : "#FFFFFF");
        lanternaGUI.drawText(new Position(5, 15 + 3), getModel().getOption(3), getModel().isSelected(3) ? "#39FF14" : "#FFFFFF");
    }

    @Override
    public void drawLines(LanternaGUI lanternaGUI) {
        // draw nothing
    }
}
