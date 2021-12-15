public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240();

        CarController cc = new CarController();
        cc.addCar(volvo);
        Clock clock = new Clock();
        clock.addObserver(volvo);

        DrawPanel view = new DrawPanel(800, 800-240, volvo);
        clock.addObserver(view);

        new CarSimFrame("CarSim 1.0", cc, view);

        // Start the timer
        clock.start();
    }
}
