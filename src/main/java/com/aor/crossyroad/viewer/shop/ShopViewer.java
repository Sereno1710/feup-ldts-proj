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
    public void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawShop(new Position(17,5),"SHOP","#FFD700");
        for (int i = 0; i < 3; i++)
            lanternaGUI.drawShop(new Position(5, 15 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
    }
    @Override
    public void drawLines(LanternaGUI lanternaGUI){
    //do nothing
    }
}
