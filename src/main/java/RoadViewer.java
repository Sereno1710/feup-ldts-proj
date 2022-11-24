public class RoadViewer implements LineViewer<Road>{
    @Override
    public void draw(Road road, LanternaGUI lanternaGUI) {
        lanternaGUI.drawRoad(road, road.getY());
    }
}
