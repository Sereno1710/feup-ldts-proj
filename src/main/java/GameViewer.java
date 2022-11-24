import java.util.List;

public class GameViewer extends Viewer<Arena>{
    public GameViewer(Arena arena){
        super(arena);
    }
    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        drawElement(lanternaGUI, getModel().getChicken(), new ChickenViewer());
        drawLines(lanternaGUI, getModel().getLines());
    }

    private void drawLines(LanternaGUI lanternaGUI, List<Line> lines) {
        SidewalkViewer sidewalkViewer = new SidewalkViewer();
        RoadViewer roadViewer = new RoadViewer();
        for (Line line : lines) {
            if (line.getCode() == 'R') {
                roadViewer.draw((Road) line, lanternaGUI);
            }
            else {
                sidewalkViewer.draw((Sidewalk) line, lanternaGUI);
            }
        }
    }

    private <T extends Element> void drawElement(LanternaGUI lanternaGUI, T element, ElementViewer<T> viewer) {
        viewer.draw(element, lanternaGUI);
    }
}
