package controller;

import model.TurboCar;

import javax.swing.*;
import java.util.Set;

public class TurboOffButton extends JButton {
    TurboOffButton(Set<TurboCar> cars) {
        super("Saab turbo off");

        addActionListener(e -> {
            for (TurboCar car : cars) {
                car.setTurboOff();
            }
        });
    }
}
