import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    protected State(T model) {
        this.model = model;
        this.controller = getController();
        this.viewer = getViewer();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public T getModel() {
        return model;
    }
    public void step(Game game, LanternaGUI gui, long time) throws IOException {
        LanternaGUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
