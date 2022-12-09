package com.aor.crossyroad.viewer.shop;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;

import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.viewer.Viewer;
import java.io.IOException;

public class ShopViewer extends Viewer<Shop> {
    public ShopViewer(Shop shop) {
        super(shop);
    }
    public void draw(LanternaGUI lanternaGUI) throws IOException {
        lanternaGUI.clear();
        drawElements(lanternaGUI);
        drawLines(lanternaGUI);
        lanternaGUI.refresh();
    }
    @Override
    protected void drawElements(LanternaGUI lanternaGUI){
        for (int i = 0; i < 3; i++)
            lanternaGUI.drawText(new Position(5, 15 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
    }
    @Override
    protected void drawLines(LanternaGUI lanternaGUI){
    }

}
