import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getType().previousOption();
                break;
            case DOWN:
                getType().nextOption();
                break;
            case SELECT:
                if(getType().isSelectedExit()) game.setState(null);
                if(getType().isSelectedStart()) game.setState(new GameState(new Arena(100,40)));
        }
    }
}