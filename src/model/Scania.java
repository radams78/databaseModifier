package model;

import java.awt.*;

public class Scania extends Truck {
    private final ScaniaPlatform platform;

    private Scania(ScaniaPlatform platform, int x, int y) {
        super(2, Color.RED, 100, "model.Scania", platform, x, y);
        this.platform = platform;
    }

    public Scania(int x, int y) {
        this(new ScaniaPlatform(), x, y);
    }

    public void raisePlatform(int angle) throws PlatformWhileMovingException, PlatformAngleException {
        platform.raise(angle);
    }

    public void lowerPlatform(int angle) throws PlatformWhileMovingException, PlatformAngleException {
        platform.lower(angle);
    }
}

class PlatformAngleException extends IllegalArgumentException {
    PlatformAngleException(String message) {
        super(message);
    }
}