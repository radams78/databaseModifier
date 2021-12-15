package controller;

import controller.GasSpinner;

import javax.swing.*;
import java.awt.*;

public class GasPanel extends JPanel {
    private static final JLabel gasLabel = new JLabel("Amount of gas");

    public GasPanel(GasSpinner gasSpinner) {
        setLayout(new BorderLayout());
        add(gasLabel, BorderLayout.PAGE_START);
        add(gasSpinner, BorderLayout.PAGE_END);
    }
}
