package view;

import model.Car;
import model.Scania;

public class PaintableCarFactory {
    public static PaintableCar makeCarVolvoImage(Car car) {
        return new PaintableCar("pics/Volvo240.jpg", car);
    }

    public static PaintableCar makeCarSaabImage(Car car) {
        return new PaintableCar("pics/Saab95.jpg", car);
    }

    public static PaintableCar makeCarScaniaImage(Scania scania) {
        return new PaintableCar("pics/Scania.jpg", scania);
    }
}
