package com.aor.crossyroad.viewer.menu;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawMenu(new Position(5, 4), "\t\tCrossy Road : Menu", "#FFD700");
        for (int i = 0; i < getModel().getNumberOptions(); i++)
            lanternaGUI.drawMenu(new Position(5, 15 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
        lanternaGUI.drawChicken(getModel().getChicken().getPosition(),getModel().getChicken().getDirection());
    }
    @Override
    public void drawLines(LanternaGUI lanternaGUI){
        //do nothing
    }
}
