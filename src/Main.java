import controller.CarController;
import controller.Clock;
import model.*;
import view.DrawPanel;
import view.PaintableCar;
import view.PaintableCarFactory;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240(0, 0);
        TurboCar saab = new Saab95(0, 100);
        Scania scania = new Scania(0, 200);

        Set<Car> cars = new HashSet<>();
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);

        Set<TurboCar> turboCars = new HashSet<>();
        turboCars.add(saab);

        Set<Scania> scanias = new HashSet<>();
        scanias.add(scania);

        CarController cc = new CarController(cars, turboCars, scanias);

        Clock clock = new Clock();
        for (Car car : cars) {
            clock.addObserver(car);
        }

        Set<PaintableCar> paintableCars = new HashSet<>();
        paintableCars.add(PaintableCarFactory.makeCarVolvoImage(volvo));
        paintableCars.add(PaintableCarFactory.makeCarSaabImage(saab));
        paintableCars.add(PaintableCarFactory.makeCarScaniaImage(scania));

        DrawPanel view = new DrawPanel(paintableCars);
        clock.addObserver(view);

        new CarSimFrame("CarSim 1.0", cc, view);

        // Start the timer
        clock.start();
    }
}
