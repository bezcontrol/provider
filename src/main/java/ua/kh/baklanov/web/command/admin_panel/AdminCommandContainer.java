package ua.kh.baklanov.web.command.admin_panel;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

public final class AdminCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("users", new UsersCommand());
        commands.put("orders", new OrdersCommand());
        commands.put("UpdateUser", new UpdateUserCommand());
        commands.put("UpdateOrder", new UpdateOrderCommand());
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
