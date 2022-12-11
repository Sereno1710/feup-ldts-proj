package com.aor.crossyroad.controller.game;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;

import java.io.IOException;

public class ChickenController extends GameController {
    public ChickenController(Arena arena) {
        super(arena);
    }
    private void moveChicken(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getChicken().setPosition(position);
        }
    }
    public void moveChickenLeft() {
        moveChicken(getModel().getChicken().getPosition().getLeft());
    }
    public void moveChickenUp() {
        moveChicken(getModel().getChicken().getPosition().getUp());
    }
    public void moveChickenRight() {
        moveChicken(getModel().getChicken().getPosition().getRight());
    }
    public void moveChickenDown() {
        moveChicken(getModel().getChicken().getPosition().getDown());
    }
    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
            if (action == LanternaGUI.ACTION.UP) {
                moveChickenUp();
                getModel().setLastSafe(getModel().getChicken());
            }
            if (action == LanternaGUI.ACTION.RIGHT) moveChickenRight();
            if (action == LanternaGUI.ACTION.DOWN) {
                moveChickenDown();
                getModel().setLastSafe(getModel().getChicken());
            }
            if (action == LanternaGUI.ACTION.LEFT) moveChickenLeft();
    }
}