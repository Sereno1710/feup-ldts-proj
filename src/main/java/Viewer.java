import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;
    public Viewer(T type){
        this.model = type;
    }

    public T getModel() {
        return model;
    }
    public void draw(LanternaGUI lanternaGUI) throws IOException{
        lanternaGUI.clear();
        drawElements(lanternaGUI);
        drawLines(lanternaGUI);
        lanternaGUI.refresh();
    }
    protected abstract void drawElements(LanternaGUI lanternaGUI);
    protected abstract void drawLines(LanternaGUI lanternaGUI);
}
