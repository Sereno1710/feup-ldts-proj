package com.aor.crossyroad.viewer.shop;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.powerups.AddTimePowerUp;
import com.aor.crossyroad.model.game.shop.powerups.CoinsPowerUp;
import com.aor.crossyroad.model.game.shop.powerups.NextSafezonePowerUp;
import com.aor.crossyroad.viewer.Viewer;

public class PowerUpViewer extends Viewer<PowerUps> {
    public PowerUpViewer(PowerUps powerUps){
        super(powerUps);
    }
    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawPowerUp(new Position(15,5),"POWER-UPS","#FFD700");
        lanternaGUI.drawPowerUp(new Position(5, 15 ), getModel().getOption(0), getModel().isSelected(0) ? getModel().canBuy(AddTimePowerUp.getCost()) ? "#39FF14":"#FF0000" :"#FFFFFF" );
        lanternaGUI.drawPowerUp(new Position(13, 15 ), "(" + AddTimePowerUp.getCost() + "$)","#FFD700");
        lanternaGUI.drawPowerUp(new Position(5, 15 + 1), getModel().getOption(1), getModel().isSelected(1) ? getModel().canBuy(CoinsPowerUp.getCost())? "#39FF14":"#FF0000" :"#FFFFFF" );
        lanternaGUI.drawPowerUp(new Position(13, 15+1 ), "(" + CoinsPowerUp.getCost() + "$)","#FFD700");
        lanternaGUI.drawPowerUp(new Position(5, 15 + 2), getModel().getOption(2), getModel().isSelected(2) ? getModel().canBuy(NextSafezonePowerUp.getCost())? "#39FF14":"#FF0000" :"#FFFFFF" );
        lanternaGUI.drawPowerUp(new Position(13, 15 + 2 ), "(" + NextSafezonePowerUp.getCost() + "$)","#FFD700");
        lanternaGUI.drawPowerUp(new Position(19,15+2),"Press SPACEBAR to use", getModel().isSelected(2) ? "#00D4FF":"#FFFFFF");
        lanternaGUI.drawPowerUp(new Position(5, 15 + 3), getModel().getOption(3), getModel().isSelected(3)? "#39FF14" :"#FFFFFF");
    }
    @Override
    public void drawLines(LanternaGUI lanternaGUI) {
      //do nothing
    }

}
