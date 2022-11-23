public class ChickenViewer implements ElementViewer<Chicken>{
    @Override
    public void draw(Chicken chicken, LanternaGUI lanternaGui) {
        lanternaGui.drawChicken(chicken.getPosition());
    }
}
