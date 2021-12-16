package view;

import model.Car;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class PaintableCar extends JComponent {
    private final Image image;
    private final Car car;

    public PaintableCar(Image image, Car car) {
        this.image = image;
        this.car = car;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (int) Math.round(car.getPosition().getX());
        int y = (int) Math.round(car.getPosition().getY());
        g.drawImage(image, x, y, null); // see javadoc for more info on the parameters
    }
}
