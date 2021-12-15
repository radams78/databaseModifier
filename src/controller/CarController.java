package controller;

import controller.GasSpinner;
import model.Car;
import model.Scania;
import model.TurboCar;

import javax.swing.*;
import java.util.Set;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JPanel {
    public CarController(Set<Car> cars, Set<TurboCar> turboCars, Set<Scania> scanias) {
        GasSpinner gasSpinner = new GasSpinner();

        add(new GasPanel(gasSpinner));
        add(new ControlPanel(cars, turboCars, scanias, gasSpinner));
        add(new StartButton(cars));
        add(new StopButton(cars));
    }
}
