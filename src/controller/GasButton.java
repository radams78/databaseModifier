package controller;

import controller.GasSpinner;
import model.Car;

import javax.swing.*;
import java.util.Set;

public class GasButton extends JButton {
    public GasButton(Set<Car> cars, GasSpinner gasSpinner) {
        super("Gas");
        addActionListener(e -> {
            double amount = ((int) gasSpinner.getValue()) / 100.0;
            for (Car car : cars) {
                car.gas(amount);
            }
        });
    }
}
