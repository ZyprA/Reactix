
  <img src="[https://your-image-host.com/reactix-logo.png](https://github.com/ZyprA/Reactix/blob/main/logo.png?raw=true)" width="200" alt="Reactix Logo" />

# Reactix

Reactix is a lightweight reactive event API for Spigot and Paper plugins.  
It allows you to handle Bukkit events in a functional, chainable style.

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

## 📦 Installation

- Reactix is **not a plugin**. Do **not** place it in the `plugins/` folder.
- Use [JitPack]([https://jitpack.io/](https://jitpack.io/#ZyprA/Reactix/)) to add it as a dependency via Gradle or Maven.
- You must **include it in your plugin's Fat Jar** using [Shadow](https://github.com/johnrengelman/shadow) or similar.

### Example for Gradle:

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
       implementation 'com.github.ZyprA:Reactix:-SNAPSHOT'
}

tasks {
    shadowJar {
        archiveClassifier.set("")
    }
    build {
        dependsOn(shadowJar)
    }
}
```

---

## 📝 License

MIT
