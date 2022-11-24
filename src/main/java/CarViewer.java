public class CarViewer implements ElementViewer<Car>{
    @Override
    public void draw(Car car, LanternaGUI lanternaGUI) {
        lanternaGUI.drawCar(car.getPosition());
    }
}
