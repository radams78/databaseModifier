import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JPanel implements Observer {
    private static final int X = 800;

    // member fields:

    // A list of cars, modify if needed
    private final ArrayList<Car> cars = new ArrayList<>();
    private final GasSpinner gasSpinner = new GasSpinner();


    //methods:

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    public void update() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public CarController() {
        GasPanel gasPanel = new GasPanel(gasSpinner);
        add(gasPanel);
        ControlPanel controlPanel = new ControlPanel();

        controlPanel.setLayout(new GridLayout(2,4));

        JButton gasButton = new JButton("Gas");
        controlPanel.add(gasButton, 0);
        JButton turboOnButton = new JButton("Saab Turbo on");
        controlPanel.add(turboOnButton, 1);
        JButton liftBedButton = new JButton("Scania Lift Bed");
        controlPanel.add(liftBedButton, 2);
        JButton brakeButton = new JButton("Brake");
        controlPanel.add(brakeButton, 3);
        JButton turboOffButton = new JButton("Saab Turbo off");
        controlPanel.add(turboOffButton, 4);
        JButton lowerBedButton = new JButton("Lower Lift Bed");
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        JButton startButton = new JButton("Start all cars");
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        add(startButton);


        JButton stopButton = new JButton("Stop all cars");
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(e -> gas((int) gasSpinner.getValue()));
    }
}
