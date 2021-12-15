package controller;

import model.Scania;

import javax.swing.*;
import java.util.Set;

public class LiftBedButton extends JButton {
    private static final int RAISE_ANGLE = 10;

    public LiftBedButton(Set<Scania> scanias) {
        super("model.Scania Lift Bed");
        addActionListener(e -> {
            for (Scania scania : scanias) {
                scania.raisePlatform(RAISE_ANGLE);
            }
        });
    }
}
