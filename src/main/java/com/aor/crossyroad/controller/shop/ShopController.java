package com.aor.crossyroad.controller.shop;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.powerups.PowerUp;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.PowerUpsState;
import com.aor.crossyroad.states.ShopState;

import java.io.IOException;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop shop) {
        super(shop);
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
                    GameState gameState = getModel().getGameState();
                    gameState.getModel().resetTime();
                    gameState.getModel().setChicken(new Chicken(gameState.getModel().getChicken().getPosition().getX()+1,gameState.getModel().getChicken().getPosition().getY()));
                    game.setState(gameState);
                }
                if (getModel().isSelectedPowerUp()){
                    game.setState(new PowerUpsState(new PowerUp(new ShopState(getModel()))));
                }
        }
    }
}
