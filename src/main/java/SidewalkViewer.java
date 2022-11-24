public class SidewalkViewer implements LineViewer<Sidewalk>{
    @Override
    public void draw(Sidewalk sidewalk, LanternaGUI lanternaGUI) {
        lanternaGUI.drawSidewalk(sidewalk, sidewalk.getY());
    }
}
