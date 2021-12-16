package controller;

import javax.swing.*;

class GasSpinner extends JSpinner {
    public GasSpinner() {
        super(new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1));//step
    }

    public double getGasValue() {
        return ((int) getValue()) / 100.0;
    }
}
