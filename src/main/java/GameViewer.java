import java.util.List;

public class GameViewer extends Viewer<Arena>{
    public GameViewer(Arena arena){
        super(arena);
    }
    @Override
    public void drawElements(LanternaGUI lanternaGui) {
        drawElement(lanternaGui, getType().getChicken(), new ChickenViewer());
        //drawLines(gui,getType().getLines(),new LineViewer());
    }

    private void drawLines(LanternaGUI lanternaGui, List<Line> lines, LineViewer viewer) {
        for (Line l: lines)
            viewer.draw(l, lanternaGui);
    }

    private <T extends Element> void drawElement(LanternaGUI lanternaGui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, lanternaGui);
    }
}
