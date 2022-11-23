public class ChickenViewer implements ElementViewer<Chicken>{
    @Override
    public void draw(Chicken chicken, GUI gui) {
        gui.drawChicken(chicken.getPosition());
    }
}
