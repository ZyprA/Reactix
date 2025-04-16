package net.zypr.reactix.core;

import java.util.function.Consumer;

public interface Streamable<T> {
    Subscription subscribe(Consumer<T> handler);
}
