package com.aor.crossyroad.controller;

import com.aor.crossyroad.controller.game.ChickenController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.io.IOException;
import java.util.List;

public class ArenaTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 3, max = 50) int width, @ForAll @IntRange(min = 3, max = 50) int height, @ForAll List<LanternaGUI.@From("moveActions") ACTION> actions) throws IOException {

        Arena arena = new Arena(width, height);
        arena.setChicken(new Chicken(1,1));
        ChickenController controller = new ChickenController(arena);
        for (LanternaGUI.ACTION action : actions) {
            controller.step(null, action, 100);
            assert (controller.getModel().getChicken().getPosition().getX() > 0);
            assert (controller.getModel().getChicken().getPosition().getY() > 0);
            assert (controller.getModel().getChicken().getPosition().getX() < width-1);
            assert (controller.getModel().getChicken().getPosition().getY() < height-1);
        }
    }
    @Provide
    Arbitrary<LanternaGUI.ACTION> moveActions() {
        return Arbitraries.of(LanternaGUI.ACTION.UP, LanternaGUI.ACTION.RIGHT, LanternaGUI.ACTION.DOWN, LanternaGUI.ACTION.LEFT);
    }

}
