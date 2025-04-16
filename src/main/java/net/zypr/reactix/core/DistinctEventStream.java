
package net.zypr.reactix.core;

import java.util.function.Consumer;

public class DistinctEventStream<T> extends AbstractStream<T> {
    private final Streamable<T> source;
    private T lastValue = null;

    public DistinctEventStream(Streamable<T> source) {
        this.source = source;
    }

    @Override
    public Subscription subscribe(Consumer<T> handler) {
        return source.subscribe(e -> {
            if (lastValue == null || !lastValue.equals(e)) {
                lastValue = e;
                handler.accept(e);
            }
        });
    }

    public Subscription distinctWithHandler(Consumer<T> onNew, Consumer<T> onRepeat) {
        return source.subscribe(e -> {
            if (lastValue == null || !lastValue.equals(e)) {
                lastValue = e;
                onNew.accept(e);
            } else {
                onRepeat.accept(e);
            }
        });
    }
}
