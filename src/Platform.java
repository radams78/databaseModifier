interface Platform {
    // Called when we attempt to move the truck
    void lock() throws PlatformWhileMovingException;

    // Called when speed reaches 0
    void unlock();
}
