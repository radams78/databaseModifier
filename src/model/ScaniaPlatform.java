package model;

// Invariant: if locked then angle == 0
public class ScaniaPlatform implements Platform {
    private boolean locked;
    private int angle;

    public void raise(int angle) throws PlatformWhileMovingException, PlatformAngleException {
        if (locked)
            throw new PlatformWhileMovingException(
                    "Attempted to raise Scania platform by " + angle + " while moving"
            );
        int newAngle = this.angle + angle;
        if (newAngle > 70)
            throw new PlatformAngleException(
                    "Attempted to raise Scania platform from " + this.angle + " degrees to " + newAngle + " degrees"
            );
        this.angle = newAngle;
    }

    public void lower(int angle) throws PlatformWhileMovingException, PlatformAngleException {
        if (locked)
            throw new PlatformWhileMovingException(
                    "Attempted to lower model.Scania platform by " + angle + " while moving"
            );
        int newAngle = this.angle - angle;
        if (newAngle < 0)
            throw new PlatformAngleException(
                    "Attempted to lower model.Scania platform from " + this.angle + " degrees to " + newAngle + " degrees"
            );
        this.angle = newAngle;
    }

    @Override
    public void lock() throws PlatformWhileMovingException {
        if (angle != 0)
            throw new PlatformWhileMovingException(
                    "Attempted to move model.Scania while platform was at angle " + angle
            );
        locked = true;
    }

    @Override
    public void unlock() {
        locked = false;
    }
}
