package com.aor.crossyroad.controller.menu;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.menu.GameOver;
import com.aor.crossyroad.states.GameState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        switch (action) {
            case UP -> getModel().previousOption();
            case DOWN -> getModel().nextOption();
            case SELECT -> {
                if (getModel().isSelectedExit()) {
                    game.setState(null);
                }
                if (getModel().isSelectedStart()) {
                    GameState gameState = new GameState(new Arena(40, 40));
                    gameState.getModel().setCoinAmount(getModel().getCoins());
                    game.setState(gameState);
                }
            }
        }
    }

}
