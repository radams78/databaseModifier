public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240();
        CarController cc = new CarController();
        cc.addCar(volvo);
        Clock clock = new Clock();
        clock.addObserver(cc);
        CarView view = new CarView("CarSim 1.0", cc, volvo);

        clock.addObserver(view.drawPanel);

        // Start the timer
        clock.start();
    }
}
