package ua.kh.baklanov.web.command.adminPanel;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

public final class AdminCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("home", new AdminHomeCommand());
        commands.put("noCommand", new NoCommand());
    }

    private AdminCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
