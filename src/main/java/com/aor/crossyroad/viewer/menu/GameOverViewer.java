package com.aor.crossyroad.viewer.menu;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.menu.GameOver;
import com.aor.crossyroad.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(15, 4), "You Lost", "#FF0000");

        for (int i = 0; i < 2; i++)
            lanternaGUI.drawText(new Position(5, 15 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
        lanternaGUI.drawText(new Position(2,20), getModel().getOption(2),"#39FF14");
        lanternaGUI.drawText(new Position(22,20), getModel().getOption(3),"#39FF14");
    }

    @Override
    protected void drawLines(LanternaGUI lanternaGUI) {

    }
}
