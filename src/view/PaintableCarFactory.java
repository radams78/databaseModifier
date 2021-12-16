package view;

import model.Car;
import model.Scania;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class PaintableCarFactory {
    public static PaintableCar makeCarVolvoImage(Car car) {
        return makePaintableCar("../pics/Volvo240.jpg", car);
    }

    public static PaintableCar makeCarSaabImage(Car car) {
        return makePaintableCar("../pics/Saab95.jpg", car);
    }

    public static PaintableCar makeCarScaniaImage(Scania scania) {
        return makePaintableCar("../pics/Scania.jpg", scania);
    }

    private static PaintableCar makePaintableCar(String filename, Car car) {
        try {

            Image image = ImageIO.read(
                    Objects.requireNonNull(
                            DrawPanel.class.getResourceAsStream(
                                    filename
                            )
                    )
            );
            return new PaintableCar(image, car);

        } catch (IOException e) {
            System.out.println("Could not find file " + filename);
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return null;
    }
}
