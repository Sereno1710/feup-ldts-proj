public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }
    @Override
    protected Controller<Arena> getController(){
        return new ArenaController(getModel());
    }
}