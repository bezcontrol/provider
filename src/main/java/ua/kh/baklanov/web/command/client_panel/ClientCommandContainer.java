package ua.kh.baklanov.web.command.client_panel;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class that contains commands for client panel
 * @author Aleksei Baklanov
 */
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
