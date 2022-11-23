import java.io.IOException;

public abstract class Viewer<T> {
    private final T type;
    public Viewer(T type){
        this.type=type;
    }

    public T getType() {
        return type;
    }
    public void draw(GUI gui)throws IOException{
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }
    protected abstract void drawElements(GUI gui);
}
