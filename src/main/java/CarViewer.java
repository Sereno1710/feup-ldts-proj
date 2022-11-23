public class CarViewer implements ElementViewer<Car>{
    @Override
    public void draw(Car car, LanternaGUI lanternaGui) {
        lanternaGui.drawCar(car.getPosition());
    }
}
