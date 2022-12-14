package com.aor.crossyroad.controller.shop;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Skins;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.PowerUpsState;
import com.aor.crossyroad.states.ShopState;
import com.aor.crossyroad.states.SkinsState;
import com.aor.crossyroad.viewer.shop.SkinsViewer;

import java.io.IOException;

public class SkinsController extends Controller<Skins> {
    public SkinsController(Skins skins) {
        super(skins);
    }
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) {
                    game.setState(getModel().getShopState());
                } else if (getModel().isSelectedDefault()) {
                    Chicken.setColor("#FFFF00");
                } else if (getModel().isSelectedBlue()) {
                    Chicken.setColor("#1E90FF");
                } else if (getModel().isSelectedWhite()) {
                    Chicken.setColor("#FFFFFF");
                }
        }
    }
}
