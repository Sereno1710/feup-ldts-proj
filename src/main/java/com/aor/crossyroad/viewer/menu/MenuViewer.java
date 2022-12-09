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
    protected void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(5, 4), "\t\tCrossy Road : Menu", "#FFD700");

        for (int i = 0; i < 2; i++)
            lanternaGUI.drawText(new Position(5, 15 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
        if (getModel().getNumberOptions()==4){
            lanternaGUI.drawText(new Position(3,25 ), getModel().getOption(2), "#39FF14");
            lanternaGUI.drawText(new Position(25, 25), getModel().getOption(3) ,"#39FF14");
        }
    }
    @Override
    protected void drawLines(LanternaGUI lanternaGUI){
        return;
    }
}
