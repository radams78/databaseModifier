import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JPanel {
    private static final int X = 800;

    // member fields:


    //methods:

    public CarController(Set<Car> cars, Set<TurboCar> turboCars, Set<Truck> trucks) {
        GasSpinner gasSpinner = new GasSpinner();

        GasPanel gasPanel = new GasPanel(gasSpinner);
        add(gasPanel);

        ControlPanel controlPanel = new ControlPanel();

        controlPanel.add(new GasButton(cars, gasSpinner), 0);
        controlPanel.add(new TurboOnButton(turboCars), 1);
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

    }
}
