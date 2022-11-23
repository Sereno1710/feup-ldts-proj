public class CarViewer implements ElementViewer<Car>{
    @Override
    public void draw(Car car, GUI gui) {
        gui.drawCar(car.getPosition());
    }
}
