package com.aor.crossyroad.controller.game.elements;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.game.GameController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;

import java.io.IOException;

public class CoinController extends GameController {
    private long coinTime = 0;

    public CoinController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        if (time - coinTime > 9000) {
            getModel().RandomizeCoins();
            coinTime = time;
        }
    }
}
