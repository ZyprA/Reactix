package net.zypr.reactix.core;

public class Subscription {

    private final Runnable unsubscribe;

    public Subscription(Runnable unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    public void cancel() {
        unsubscribe.run();
    }
}
