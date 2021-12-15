import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer {

    // Just a single image, TODO: Generalize
    private final Set<PaintableCar> cars;

    // Initializes the panel and reads the images
    public DrawPanel() {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800, 800-240));
        this.setBackground(Color.green);

        cars = new HashSet<>();
    }

    public void addCar(PaintableCar car) {
        cars.add(car);
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
