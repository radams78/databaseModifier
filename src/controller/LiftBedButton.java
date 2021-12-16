package controller;

import model.PlatformWhileMovingException;
import model.Scania;

import javax.swing.*;
import java.util.Set;

public class LiftBedButton extends JButton {
    private static final int RAISE_ANGLE = 10;

    public LiftBedButton(Set<Scania> scanias) {
        super("Scania Lift Bed");
        addActionListener(e -> {
            for (Scania scania : scanias) {
                try {
                    scania.raisePlatform(RAISE_ANGLE);
                } catch (PlatformWhileMovingException ex) {
                    System.out.println("Cannot raise bed while truck is moving");
                }
            }
        });
    }
}
