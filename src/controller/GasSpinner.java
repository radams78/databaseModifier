package controller;

import javax.swing.*;

public class GasSpinner extends JSpinner {
    public GasSpinner() {
        super(new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1));//step
    }
}
