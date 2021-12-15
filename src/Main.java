import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240();
        TurboCar saab = new Saab95();
        Truck scania = new Scania();

        Set<Car> cars = new HashSet<>();
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);

        Set<TurboCar> turboCars = new HashSet<>();
        turboCars.add(saab);

        Set<Truck> trucks = new HashSet<>();
        trucks.add(scania);

        CarController cc = new CarController(cars, turboCars, trucks);

        Clock clock = new Clock();
        for (Car car : cars) {
            clock.addObserver(car);
        }

        Set<PaintableCar> paintableCars = new HashSet<>();
        paintableCars.add(PaintableCarFactory.makeCarVolvoImage(volvo));
        paintableCars.add(PaintableCarFactory.makeCarSaabImage(saab));

        DrawPanel view = new DrawPanel(paintableCars);
        clock.addObserver(view);

        new CarSimFrame("CarSim 1.0", cc, view);

        // Start the timer
        clock.start();
    }
}
