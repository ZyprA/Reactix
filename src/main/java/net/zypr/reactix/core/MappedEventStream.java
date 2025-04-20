package net.zypr.reactix.core;

import java.util.function.Consumer;
import java.util.function.Function;

public class MappedEventStream<T, R> extends AbstractStream<R>{
    private final Streamable<T> source;
    private final Function<T, R> mapper;

    public MappedEventStream(Streamable<T> source, Function<T, R> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    public Subscription subscribe(Consumer<R> handler) {
        return source.subscribe(e -> handler.accept(mapper.apply(e)));
    }
}
