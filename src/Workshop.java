import java.awt.*;
import java.util.Stack;

public class Workshop<T extends Car> {
    private int maxCapacity;
    private Point position;
    private Stack<T> contents;

    public void load(T car) {
        {
            double distance = position.distance(car.getPosition());
            if (distance < 0.5) {
                throw new LoadException(
                        String.format("Attempted to load car at distance of %.2f", distance)
                );
            }
        }
        if (contents.contains(car)) {
            throw new LoadException("Attempted to load car already on transport");
        }
        contents.add(car);
    }

    public T unload() {
        if (contents.isEmpty())
            throw new LoadException("Attempted to unload car transporter while empty");

        return contents.pop();
    }

}
