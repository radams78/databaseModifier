import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PaintableCar extends JComponent {
    private BufferedImage image;
    private final Car car;

    public PaintableCar(String filename, Car car) {
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            image = ImageIO.read(
                    Objects.requireNonNull(
                            DrawPanel.class.getResourceAsStream(
                                    filename
                            )
                    )
            );
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
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
