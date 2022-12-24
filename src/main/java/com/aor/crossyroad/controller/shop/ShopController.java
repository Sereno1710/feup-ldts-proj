package com.aor.crossyroad.controller.shop;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Skins;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.PowerUpsState;
import com.aor.crossyroad.states.ShopState;
import com.aor.crossyroad.states.SkinsState;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop shop) {
        super(shop);
    }
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        switch (action) {
            case UP -> getModel().previousOption();
            case DOWN -> getModel().nextOption();
            case SELECT -> {
                if (getModel().isSelectedExit()) {
                    GameState gameState = getModel().getGameState();
                    gameState.getModel().resetTime();
                    int x = gameState.getModel().getChicken().getPosition().getX();
                    int y = gameState.getModel().getChicken().getPosition().getY() - 1;
                    gameState.getModel().setChicken(new Chicken(x, y));
                    game.setState(gameState);
                }
                if (getModel().isSelectedPowerUp()) {
                    game.setState(new PowerUpsState(new PowerUps(new ShopState(getModel()))));
                }
                if (getModel().isSelectedSkins()) {
                    game.setState(new SkinsState(new Skins(new ShopState(getModel()))));
                }
            }
        }
    }
}
