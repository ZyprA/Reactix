package net.zypr.reactix.core;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteredEventStream<T> extends AbstractStream<T> {
    private final Streamable<T> source;
    private final Predicate<T> predicate;

    public FilteredEventStream(Streamable<T> source, Predicate<T> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override
    public Subscription subscribe(Consumer<T> handler) {
        return source.subscribe(e -> {
            if (predicate.test(e)) {
                handler.accept(e);
            }
        });
    }
}
