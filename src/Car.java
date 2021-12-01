import javax.naming.directory.InvalidAttributeIdentifierException;
import java.awt.*;

public class Car implements Movable {
    private Color color;
    private double currentSpeed; // The current speed of the car
    private double enginePower;
    private int nrDoors;
    private String modelName; // The car model name
    // TODO Use Point here instead
    private int x;
    private int y;
    private int direction; // 0 = north, 1 = east, 2 = south, 3 = west
    // Best practice here is to use an enum

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        stopEngine();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void setPosition(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public int getDirection() {
        return direction;
    }

    public Point getPosition() { return new Point(x, y);}

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public Color getColor(){
        return color;
    }

    public double getEnginePower(){
        return enginePower;
    }

    protected double speedFactor() { return getEnginePower() * 0.01; }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Call to gas with amount " + amount);
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Call to gas with amount " + amount);
        }
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        if (direction == 0) {
            y += getCurrentSpeed();
        } else if (direction == 1) {
            x += getCurrentSpeed();
        } else if (direction == 2) {
            y -= getCurrentSpeed();
        } else if (direction == 3) {
            x -= getCurrentSpeed();
        }
    }

    @Override
    // Best practice here is to use a switch, or delegate to Direction enum
    public void turnLeft() {
        if (direction == 0) {
            direction = 3;
        } else if (direction == 1) {
            direction = 0;
        } else if (direction == 2) {
            direction = 1;
        } else if (direction == 3) {
            direction = 2;
        }
    }

    @Override
    // Best practice here is to use a switch, or delegate to Direction enum
    public void turnRight() {
        if (direction == 0) {
            direction = 1;
        } else if (direction == 1) {
            direction = 2;
        } else if (direction == 2) {
            direction = 3;
        } else if (direction == 3) {
            direction = 0;
        }
    }
}
