import java.io.IOException;

public class ArenaController extends GameController {
    private final ChickenController chickenController;
    private final CarRightController carRightController;
    private final CarLeftController carLeftController;

    public ArenaController(Arena arena) {
        super(arena);

        this.chickenController = new ChickenController(arena);
        this.carRightController = new CarRightController(arena);
        this.carLeftController = new CarLeftController(arena);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        if (action == LanternaGUI.ACTION.QUIT) {
            game.setState(new MenuState(new Menu()));
        }
        else {
            chickenController.step(game, action, time);
            carRightController.step(game, action, time);
        }
    }
}
