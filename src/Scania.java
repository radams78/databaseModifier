import java.awt.*;

public class Scania extends Truck {
    private ScaniaPlatform platform;

    private Scania(ScaniaPlatform platform) {
        super(2, Color.RED, 100, "Scania", platform);
        this.platform = platform;
    }

    public Scania() {
        this(new ScaniaPlatform());
    }

    public void raisePlatform(int angle) throws PlatformWhileMovingException, PlatformAngleException {
        platform.raise(angle);
    }

    public void lowerPlatform(int angle) throws PlatformWhileMovingException, PlatformAngleException {
        platform.lower(angle);
    }
}

class PlatformWhileMovingException extends IllegalStateException {
    PlatformWhileMovingException(String message) {
        super(message);
    }
}

class PlatformAngleException extends IllegalArgumentException {
    PlatformAngleException(String message) {
        super(message);
    }
}