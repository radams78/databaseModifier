package model;

import java.awt.*;

public class CarTransport extends Truck {
    private TransportRamp ramp;
    private Contents<Car> contents;

    private CarTransport(TransportRamp ramp, int x, int y) {
        super(2, Color.BLACK, 250, "Montway", ramp, x, y);
        this.ramp = ramp;
        this.contents = new Contents<>();
    }

    public CarTransport(int x, int y) {
        this(new TransportRamp(), x, y);
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

    public Car unload() throws LoadException {
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