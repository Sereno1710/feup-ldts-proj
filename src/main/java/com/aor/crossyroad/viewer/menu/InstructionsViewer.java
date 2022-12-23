package com.aor.crossyroad.viewer.menu;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.viewer.Viewer;

public class InstructionsViewer extends Viewer<InstructionsMenu> {
    public InstructionsViewer(InstructionsMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(15,3),"Instructions","#00FF4D");
        lanternaGUI.drawText(new Position(1,6),"Goal:","#FFD700");
        lanternaGUI.drawText(new Position(7,6),"Cross the road as many times as", "#FFFFFF");
        lanternaGUI.drawText(new Position(7,7),"you can without getting hit.","#FFFFFF");
        lanternaGUI.drawText(new Position(2,10),"You have limited time to cross to the","#FFFFFF");
        lanternaGUI.drawText(new Position(1,11),"other side, so hurry up!","#FFFFFF");
        lanternaGUI.drawText(new Position(2,13),"Grab the coins to buy power-ups to","#FFFFFF");
        lanternaGUI.drawText(new Position(1,14),"help you get the best score possible!","#FFFFFF");
        lanternaGUI.drawText(new Position(1,17),"Power-Ups:","#EE4B2B");
        lanternaGUI.drawText(new Position(3,19),"AddTime-> Get permanent extra time","#FFFFFF");
        lanternaGUI.drawText(new Position(13,20),"to cross;","#FFFFFF");
        lanternaGUI.drawText(new Position(3,21),"x2 Coins-> Gain double the coins for a period of time;","#FFFFFF");
        lanternaGUI.drawText(new Position(14,22),"a period of time;","#FFFFFF");
        lanternaGUI.drawText(new Position(3,23),"Teleport-> Teleport to the next","#FFFFFF");
        lanternaGUI.drawText(new Position(14,24),"safezone.","#FFFFFF");
        lanternaGUI.drawText(new Position(1,27),"Controls:","#00DDFF");
        lanternaGUI.drawText(new Position(3,29),"ArrowUp-> Move Up;","#FFFFFF");
        lanternaGUI.drawText(new Position(3,30),"ArrowDown-> Move Down;","#FFFFFF");
        lanternaGUI.drawText(new Position(3,31),"ArrowLeft-> Move to the Left;","#FFFFFF");
        lanternaGUI.drawText(new Position(3,32),"ArrowRight-> Move to the Right;","#FFFFFF");

        lanternaGUI.drawText(new Position(9,37),"( Press ENTER to EXIT )","#FFFFFF");
    }

    @Override
    public void drawLines(LanternaGUI lanternaGUI) {
    //do nothing
    }
}
