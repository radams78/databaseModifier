import javax.swing.*;
import java.util.Set;

public class TurboOnButton extends JButton {
    TurboOnButton(Set<TurboCar> cars) {
        super("Saab turbo on");

        addActionListener(e -> {
            for (TurboCar car : cars) {
                car.setTurboOn();
            }
        });
    }
}
