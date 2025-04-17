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

## License

Reactix is licensed under the MIT License.  
Copyright (c) 2025 Zypr.

You are free to use, modify, and distribute this software as long as the original copyright and license
notice are retained. See the [LICENSE](./LICENSE) file for full details.

