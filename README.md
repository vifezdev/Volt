# Volt Command API

A Bukkit command API made in minutes for quick and easy command creation and registration.

---

## Setup
- Step 1: Clone the repository
- Step 2: Run `mvn clean install`
- Step 3: Add the dependency to your plugin
- Step 4: Write your commands
- Step 5: Register them

Maven Dependency:
```xml
<dependency>
    <groupId>lol.vifez.volt</groupId>
    <artifactId>Volt</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Initialization
Initialize Volt in your plugin’s `onEnable()`:

```java
@Override
public void onEnable() {
    // Initialize Volt command manager
    commandManager = new CommandManager(this);
}

```
---
## Creating commands
Create commands by extending CommandBase and configuring aliases, description, default handler, and subcommands:
```java
public class TestCommand extends CommandBase {

    public TestCommand() {
        aliases("test", "t");
        description("A test command");

        // Default command behavior (/t)
        defaultHandler((player, args) -> player.sendMessage("Hello world"));

        // Subcommand example (/t sub)
        sub("sub", (player, args) -> player.sendMessage("subcommand fr"));
    }
}
```

---
## Registering commands
```java
commandManager.register(new TestCommand());
```

---
## Example
```java
public final class Plugin extends JavaPlugin {

    private CommandManager commandManager;

    @Override
    public void onEnable() {
        commandManager = new CommandManager(this);
        commandManager.register(new TestCommand());
    }
}
```