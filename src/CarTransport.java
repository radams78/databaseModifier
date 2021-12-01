import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck {
    private TransportRamp ramp;
    private Loader<Car> contents;

    private CarTransport(TransportRamp ramp) {
        super(2, Color.BLACK, 250, "Montway", ramp);
        this.ramp = ramp;
        this.contents = new Loader<>();
    }

    public void raiseRamp() {
        ramp.raise();
    }

    public void lowerRamp() throws PlatformWhileMovingException {
        ramp.lower();
    }

    public void load(Car car) throws LoadException {
        if (ramp.isUp())
            throw new LoadException("Attempted to load car while ramp is up");
        if (car == this) {
            throw new LoadException("Attempted to load transport onto itself");
        }

        contents.load(car);
    }

    public Car unload() {
        if (ramp.isUp())
            throw new LoadException("Attempted to unload car while ramp is up");

        return contents.unload();
    }

    @Override
    public void move() {
        super.move();
        contents.setPosition(getPosition());
    }
}

class LoadException extends IllegalStateException {
    LoadException(String msg) {
        super(msg);
    }
}