package net.zypr.reactix;

import net.zypr.reactix.core.EventStream;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

public class Reactix {
    public static<T extends Event> EventStream<T> on (Class<T> eventType, Plugin plugin) {
        return new EventStream<>(eventType, plugin);
    }
}
