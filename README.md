# Reactix - Reactive event registration API for minecraft.

Reactix is a SUPER lightweight reactive event API for Spigot and Paper plugins.  
It allows you to handle Bukkit events in a functional, chainable style.

Happy: You do not have to register event listener on your project.

---

## 🧪 Basic Usage

```java
Reactix.on(AsyncPlayerChatEvent.class, plugin)
       .filter(e -> !e.getMessage().startsWith("/"))
       .map(e -> e.getMessage())
       .distinct()
       .subscribe(message -> {
           System.out.println("Chat: " + message);
       });
```

You can use operators like `map`, `filter`, `flatMap`, `distinct`, `buffer`, and `subscribe`.

---

MIT Licensed
