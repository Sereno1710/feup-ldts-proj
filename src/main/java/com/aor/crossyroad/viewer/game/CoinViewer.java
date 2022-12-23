package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin>{
    @Override
    public void draw(Coin coin, LanternaGUI lanternaGui) {
        lanternaGui.drawCoin(coin.getPosition());
    }

}
