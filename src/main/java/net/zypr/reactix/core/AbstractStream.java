
package net.zypr.reactix.core;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractStream<T> implements Streamable<T> {
    @Override
    public abstract Subscription subscribe(Consumer<T> handler);

    public DistinctEventStream<T> distinct() {
        return new DistinctEventStream<>(this);
    }

    public Subscription distinctWithHandler(Consumer<T> onNew, Consumer<T> onRepeat) {
        return new DistinctEventStream<>(this).distinctWithHandler(onNew, onRepeat);
    }

    public <R> MappedEventStream<T, R> map(Function<T, R> mapper) {
        return new MappedEventStream<>(this, mapper);
    }

    public <R> FlatMappedEventStream<T, R> flatMap(Function<T, List<R>> mapper) {
        return new FlatMappedEventStream<>(this, mapper);
    }

    public <R> AsyncMappedEventStream<T, R> mapAsync(Function<T, CompletableFuture<R>> mapper) {
        return new AsyncMappedEventStream<>(this, mapper);
    }

    public FilteredEventStream<T> filter(Predicate<T> predicate) {
        return new FilteredEventStream<>(this, predicate);
    }

    public BufferedEventStream<T> buffer(int count) {
        return new BufferedEventStream<>(this, count);
    }
}
