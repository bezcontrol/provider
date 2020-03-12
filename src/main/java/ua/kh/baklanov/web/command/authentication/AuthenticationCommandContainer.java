package ua.kh.baklanov.web.command.authentication;

import ua.kh.baklanov.web.command.Command;

import java.util.Map;
import java.util.TreeMap;

public class AuthenticationCommandContainer {
    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("login", new LoginCommand());
    }

    private AuthenticationCommandContainer(){}

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
