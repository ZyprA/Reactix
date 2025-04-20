package net.zypr.reactix;

import net.zypr.reactix.core.EventStream;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Reactix extends JavaPlugin {

    private static Reactix instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Reactix getInstance() {
        return instance;
    }

    public static<T extends Event> EventStream<T> on (Class<T> eventType, Plugin plugin) {
        return new EventStream<>(eventType, plugin);
    }
}
