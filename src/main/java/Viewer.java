import java.io.IOException;

public abstract class Viewer<T> {
    private final T type;
    public Viewer(T type){
        this.type=type;
    }

    public T getType() {
        return type;
    }
    public void draw(LanternaGUI lanternaGui)throws IOException{
        lanternaGui.clear();
        drawElements(lanternaGui);
        lanternaGui.refresh();
    }
    protected abstract void drawElements(LanternaGUI lanternaGui);
}
