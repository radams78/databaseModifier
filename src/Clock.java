import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Clock {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    private Timer timer;
    private Set<Observer> observers;

    public Clock() {
        observers = new HashSet<>();
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Observer o : observers)
                    o.update();
            }
        });
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void start() {
        timer.start();
    }
}
