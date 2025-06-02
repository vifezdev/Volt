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

import lol.vifez.volt.api.CommandBase;
import org.bukkit.command.CommandSender;

public class TestCommand extends CommandBase {

    private final TestPlugin plugin;

    public TestCommand(TestPlugin plugin) {
        this.plugin = plugin;

        aliases("test", "test1");
        description("Test command for vifez");
        permission("vifez.admin");

        defaultHandler(this::handleDefault);
    }

    private void handleDefault(CommandSender sender, String[] args) {

        sender.sendMessage("example");
    }
}
```

# Registering sub commands
You can add subcommands easily using the `sub` method inside your command class. This allows you to handle different subcommands with separate handlers.

Example:

```java
import lol.vifez.volt.api.CommandBase;
import org.bukkit.command.CommandSender;

public class TestCommand extends CommandBase {

    private final TestPlugin plugin;

    public TestCommand(TestPlugin plugin) {
        this.plugin = plugin;

        aliases("test", "test1");
        description("Test command for vifez");
        permission("vifez.admin");

        defaultHandler(this::handleDefault);

        // Register subcommand "hello"
        sub("hello", this::handleHello);
    }

    private void handleDefault(CommandSender sender, String[] args) {
        sender.sendMessage("This is the default command response.");
    }

    private void handleHello(CommandSender sender, String[] args) {
        sender.sendMessage("Hello world");
    }
}
```
---
# Registering commands

You can register commands inside a dedicated method (e.g., `registerCommands()`) in your plugins main class

Example:
```java
import lol.vifez.volt.internal.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExamplePlugin extends JavaPlugin {

    private CommandManager commandManager;

    @Override
    public void onEnable() {
        registerCommands();
    }

    public void registerCommands() {
        this.commandManager = new CommandManager(this);
        this.commandManager.register(new ExampleCommand(this));
    }
}

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
