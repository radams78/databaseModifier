package controller;

import model.Car;
import model.MovementException;

import javax.swing.*;
import java.util.Set;

class GasButton extends JButton {
    public GasButton(Set<Car> cars, GasSpinner gasSpinner) {
        super("Gas");
        addActionListener(e -> {
            for (Car car : cars) {
                try {
                    car.gas(gasSpinner.getGasValue());
                } catch (MovementException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
