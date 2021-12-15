package controller;

import model.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class BrakeButton extends JButton {
    public BrakeButton(Set<Car> cars, GasSpinner gasSpinner) {
        super("Brake");
        addActionListener(e -> {
            double amount = ((double) gasSpinner.getValue()) / 100;
            for (Car car : cars) {
                car.brake(amount);
            }
        });
    }
}
