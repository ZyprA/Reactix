package net.zypr.reactix.core;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FlatMappedEventStream<T, R> extends AbstractStream<R> {
    private final Streamable<T> source;
    private final Function<T, List<R>> flatMapper;

    public FlatMappedEventStream(Streamable<T> source, Function<T, List<R>> flatMapper) {
        this.source = source;
        this.flatMapper = flatMapper;
    }

    public Subscription subscribe(Consumer<R> handler) {
        return source.subscribe(e -> {
            List<R> results = flatMapper.apply(e);
            if (results != null) {
                results.forEach(handler);
            }
        });
    }
}
