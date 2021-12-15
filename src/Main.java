public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240();

        CarController cc = new CarController();
        cc.addCar(volvo);
        Clock clock = new Clock();
        clock.addObserver(volvo);

        CarSimFrame frame = new CarSimFrame("CarSim 1.0", cc, volvo);
        clock.addObserver(frame.drawPanel);

        // Start the timer
        clock.start();
    }
}
