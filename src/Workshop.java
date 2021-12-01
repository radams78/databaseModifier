public class Workshop<T extends Car> {
    private Contents<T> loader;

    // TODO Constructor

    public void load(T car) throws LoadException {
        loader.load(car);
    }

    public T unload() throws LoadException {
        return loader.unload();
    }

}
