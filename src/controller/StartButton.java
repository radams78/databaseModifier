package controller;

import model.Car;
import model.MovementException;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class StartButton extends JButton {
    private static final int X = 800;

    public StartButton(Set<Car> cars) {
        super("Start all cars");

        setBackground(Color.blue);
        setForeground(Color.green);
        setPreferredSize(new Dimension(X/5-15,200));

        addActionListener(e -> {
            for (Car car : cars) {
                try {
                    car.startEngine();
                } catch (MovementException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
