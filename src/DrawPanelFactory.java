public class DrawPanelFactory {
    public static DrawPanel makeDrawPanel(Car car) {
        DrawPanel panel = new DrawPanel();
        panel.addCar(PaintableCarFactory.makeCarVolvoImage(car));
        return panel;
    }
}
