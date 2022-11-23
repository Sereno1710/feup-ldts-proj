import java.io.IOException;

public class ChickenController extends GameController {
    public ChickenController(Arena arena) {
        super(arena);
    }

    private void moveChicken(Position position) {
        if (getType().isEmpty(position)) {
            getType().getChicken().setPosition(position);
        }
    }

    public void moveChickenLeft() {
        moveChicken(getType().getChicken().getPosition().getLeft());
    }

    public void moveChickenUp() {
        moveChicken(getType().getChicken().getPosition().getUp());
    }

    public void moveChickenRight() {
        moveChicken(getType().getChicken().getPosition().getRight());
    }

    public void moveChickenDown() {
        moveChicken(getType().getChicken().getPosition().getDown());
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        if (action == LanternaGUI.ACTION.UP) moveChickenUp();
        if (action == LanternaGUI.ACTION.RIGHT) moveChickenRight();
        if (action == LanternaGUI.ACTION.DOWN) moveChickenDown();
        if (action == LanternaGUI.ACTION.LEFT) moveChickenLeft();
    }
}
