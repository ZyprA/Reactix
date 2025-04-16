package net.zypr.reactix.core;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class EventStream<T extends Event> extends AbstractStream<T>{
    private final Class<T> eventClass;
    private final Plugin plugin;
    private Predicate<T> filter = e -> true;

    public EventStream(Class<T> eventClass, Plugin plugin) {
        this.eventClass = eventClass;
        this.plugin = plugin;
    }

    public Subscription subscribe(Consumer<T> handler) {
        Listener listener = new Listener() {
        };

        Bukkit.getPluginManager().registerEvent(
                eventClass,
                listener,
                EventPriority.NORMAL,
                (l, event) -> {
                    if (eventClass.isInstance(event)) {
                        T typed = eventClass.cast(event);
                        if (filter.test(typed)) {
                            handler.accept(typed);
                        }
                    }
                },
                plugin

        );

        return new Subscription(() -> HandlerList.unregisterAll(listener));
    }
}
