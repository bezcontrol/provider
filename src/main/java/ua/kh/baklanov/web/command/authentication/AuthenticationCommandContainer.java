package ua.kh.baklanov.web.command.authentication;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoAbstractCommand;

import java.util.Map;
import java.util.TreeMap;

public final class AuthenticationCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("login", new LoginAbstractCommand());
        commands.put("logout", new LogoutAbstractCommand());
        commands.put("registration", new RegistrationAbstractCommand());
        commands.put("noCommand", new NoAbstractCommand());
    }

    private AuthenticationCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
