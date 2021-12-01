// Invariant: (up || ! locked)
public class TransportRamp implements Platform {
    boolean locked = false;
    boolean up = true;

    public boolean isUp() {
        return up;
    }

    public void raise() {
        up = true;
    }

    public void lower() throws PlatformWhileMovingException {
        if (locked)
            throw new PlatformWhileMovingException(
                    "Attempted to lower car transport ramp while moving"
            );
        up = false;
    }

    @Override
    public void lock() throws PlatformWhileMovingException {
        if (! up)
            throw new PlatformWhileMovingException(
                    "Attempted to move car transport while ramp was down"
            );
        locked = true;
    }

    @Override
    public void unlock() {
        locked = false;
    }
}
