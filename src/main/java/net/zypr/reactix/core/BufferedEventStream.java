package net.zypr.reactix.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BufferedEventStream<T> extends AbstractStream<List<T>> {
    private final Streamable<T> source;
    private final int bufferSize;
    private final List<T> buffer = new ArrayList<>();

    public BufferedEventStream(Streamable<T> source, int bufferSize) {
        this.source = source;
        this.bufferSize = bufferSize;
    }

    @Override
    public Subscription subscribe(Consumer<List<T>> handler) {
        return source.subscribe(e -> {
            buffer.add(e);
            if (buffer.size() >= bufferSize) {
                List<T> emit = new ArrayList<>(buffer);
                buffer.clear();
                handler.accept(emit);
            }
        });
    }
}
