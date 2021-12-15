package model;

import model.Car;

import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240(int x, int y){
        super(4, Color.black, 100, "model.Volvo240", x, y);
    }

    @Override
    protected double speedFactor(){
        return super.speedFactor() * trimFactor;
    }
}
