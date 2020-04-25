package ua.kh.baklanov.web.command.client_panel;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;
import ua.kh.baklanov.web.command.admin_panel.OrdersCommand;
import ua.kh.baklanov.web.command.admin_panel.UpdateOrderCommand;
import ua.kh.baklanov.web.command.admin_panel.UpdateUserCommand;
import ua.kh.baklanov.web.command.admin_panel.UsersCommand;

import java.util.Map;
import java.util.TreeMap;

public final class ClientCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("rechargeBalance", new RechargeBalanceCommand());
        commands.put("noCommand", new NoCommand());
    }

    private ClientCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
