public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240();
        TurboCar saab = new Saab95();

        CarController cc = new CarController();
        cc.addCar(volvo);
        cc.addTurboCar(saab);

        Clock clock = new Clock();
        clock.addObserver(volvo);

        DrawPanel view = DrawPanelFactory.makeDrawPanel(volvo);
        clock.addObserver(view);

        new CarSimFrame("CarSim 1.0", cc, view);

        // Start the timer
        clock.start();
    }
}
