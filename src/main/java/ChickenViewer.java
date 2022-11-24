public class ChickenViewer implements ElementViewer<Chicken>{
    @Override
    public void draw(Chicken chicken, LanternaGUI lanternaGUI) {
        lanternaGUI.drawChicken(chicken.getPosition());
    }
}
