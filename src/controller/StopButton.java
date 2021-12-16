package controller;

import model.Car;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

class StopButton extends JButton {
    private static final int X = 800;

    public StopButton(Set<Car> cars) {
        super("Stop all cars");

        setBackground(Color.red);
        setForeground(Color.black);
        setPreferredSize(new Dimension(X/5-15,200));

        addActionListener(e -> {
            for (Car car : cars) {
                car.stopEngine();
            }
        });
    }
}
