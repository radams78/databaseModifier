package view;

import model.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer {

    // Just a single image, TODO: Generalize
    private final Set<PaintableCar> cars;

    // Initializes the panel and reads the images
    public DrawPanel(Set<PaintableCar> cars) {
        this.cars = new HashSet<>(cars);

        setDoubleBuffered(true);
        setPreferredSize(new Dimension(800, 800-240));
        setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PaintableCar car : cars) {
            car.paintComponent(g);
        }
    }

    @Override
    public void update() {
        // repaint() calls the paintComponent method of the panel
        repaint();
    }
}
