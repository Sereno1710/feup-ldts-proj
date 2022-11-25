import java.util.List;

public class GameViewer extends Viewer<Arena>{
    public GameViewer(Arena arena){
        super(arena);
    }
    @Override
    public void drawElements(LanternaGUI lanternaGUI) {
        drawElement(lanternaGUI, getModel().getChicken(), new ChickenViewer());

    }
    public void drawLines(LanternaGUI lanternaGUI){
        SidewalkViewer sidewalkViewer = new SidewalkViewer();
        RoadViewer roadViewer = new RoadViewer();
        for (Line line : getModel().getLines()) {
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
