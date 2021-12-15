package controller;

import controller.BrakeButton;
import controller.GasSpinner;
import model.Car;
import model.Scania;
import model.TurboCar;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class ControlPanel extends JPanel {
    private static final int X = 800;

    public ControlPanel(
            Set<Car> cars,
            Set<TurboCar> turboCars,
            Set<Scania> scanias,
            GasSpinner gasSpinner
    ) {
        setLayout(new GridLayout(2,4));

        add(new GasButton(cars, gasSpinner), 0);
        add(new TurboOnButton(turboCars), 1);
        add(new LiftBedButton(scanias), 2);
        add(new BrakeButton(cars, gasSpinner), 3);
        add(new TurboOffButton(turboCars), 4);
        add(new LowerBedButton(scanias), 5);

        setPreferredSize(new Dimension((X/2)+4, 200));
        setBackground(Color.CYAN);
    }
}
