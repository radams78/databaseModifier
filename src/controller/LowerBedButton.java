package controller;

import model.Scania;

import javax.swing.*;
import java.util.Set;

public class LowerBedButton extends JButton {
    private static final int RAISE_ANGLE = 10;

    public LowerBedButton(Set<Scania> scanias) {
        super("Lower Lift Bed");
        addActionListener(e -> {
            for (Scania scania : scanias) {
                scania.lowerPlatform(RAISE_ANGLE);
            }
        });
    }
}
