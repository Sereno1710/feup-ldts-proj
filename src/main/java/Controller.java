import java.io.IOException;

public abstract class Controller<T> {
    private final T type;

    public Controller(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public abstract void step(Game game, LanternaGUI.ACTION action, long time) throws IOException;
}
