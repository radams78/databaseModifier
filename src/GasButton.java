import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class GasButton extends JButton {
    private Set<Car> cars;
    private GasSpinner gasSpinner;

    public GasButton(Set<Car> cars, GasSpinner gasSpinner) {
        super("Gas");
        this.cars = new HashSet<>(cars);
        this.gasSpinner = gasSpinner;

        addActionListener(e -> gas((int) gasSpinner.getValue()));
    }

    // Calls the gas method for each car once
    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }


}
