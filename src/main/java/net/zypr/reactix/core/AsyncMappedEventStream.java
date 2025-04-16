package net.zypr.reactix.core;

import org.bukkit.event.Event;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class AsyncMappedEventStream<T, R> extends AbstractStream<R>{
    private final Streamable<T> source;
    private final Function<T, CompletableFuture<R>> asyncMapper;

    public AsyncMappedEventStream(Streamable<T> source, Function<T, CompletableFuture<R>> asyncMapper) {
        this.source = source;
        this.asyncMapper = asyncMapper;
    }

    public Subscription subscribe(Consumer<R> handler) {
        return source.subscribe(e -> {
            asyncMapper.apply(e).thenAccept(handler);
        });
    }
}
