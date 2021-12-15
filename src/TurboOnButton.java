import javax.swing.*;
import java.util.Set;

public class TurboOnButton extends JButton {
    private Set<TurboCar> cars;

    TurboOnButton() {
        super("Saab turbo on");
        addActionListener(e -> turbo());
    }

    private void turbo() {
        for (TurboCar car : cars) {
            car.setTurboOn();
        }
    }
}
