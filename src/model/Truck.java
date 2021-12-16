package model;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Truck extends Car {
    private final Platform platform;

    public Truck(int nrDoors, Color color, double enginePower, String modelName,
                 @NotNull Platform platform, int x, int y) {
        super(nrDoors, color, enginePower, modelName, x, y);
        this.platform = platform;
    }

    @Override
    public void startEngine() throws MovementException {
        platform.lock();
        super.startEngine();
    }

    @Override
    public void stopEngine(){
        super.stopEngine();
        platform.unlock();
    }

    @Override
    public void gas(double amount) throws MovementException {
        platform.lock();
        super.gas(amount);
    }

    @Override
    public void brake(double amount) {
        super.brake(amount);
        if (getCurrentSpeed() < 0.01)
            platform.unlock();
    }
}
