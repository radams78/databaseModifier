public class PaintableCarFactory {
    public static PaintableCar makeCarVolvoImage(Car car) {
        return new PaintableCar("pics/Volvo240.jpg", car);
    }

    public static PaintableCar makeCarSaabImage(Car car) {
        return new PaintableCar("pics/Saab95.jpg", car);
    }
}
