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
    void allArenasAreClosed(@ForAll List<LanternaGUI.@From("moveActions") ACTION> actions) throws IOException {
        Arena arena = new Arena(10, 10);
        arena.setChicken(new Chicken(5,5));
        ChickenController controller = new ChickenController(arena);

        for (LanternaGUI.ACTION action : actions) {
            controller.step(null, action, 100);
            assert (controller.getModel().getChicken().getPosition().getX() >= 0);
            assert (controller.getModel().getChicken().getPosition().getY() >= 0);
            assert (controller.getModel().getChicken().getPosition().getX() <= 9);
            assert (controller.getModel().getChicken().getPosition().getY() <= 9);
        }
    }

    @Provide
    Arbitrary<LanternaGUI.ACTION> moveActions() {
        return Arbitraries.of(LanternaGUI.ACTION.UP, LanternaGUI.ACTION.RIGHT, LanternaGUI.ACTION.DOWN, LanternaGUI.ACTION.LEFT);
    }
}
