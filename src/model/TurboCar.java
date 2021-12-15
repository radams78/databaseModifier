package model;

import model.Car;

import java.awt.*;

public class TurboCar extends Car {
    public TurboCar(int nrDoors, Color color, double enginePower, String modelName, int x, int y) {
        super(nrDoors, color, enginePower, modelName, x, y);
        this.turboOn = false;
    }

    private boolean turboOn;

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return super.speedFactor() * turbo;
    }
}
