package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.command.Command;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

public class TariffCommandContainer {
    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("details", new TariffDetailsCommand());
        commands.put("edit", new TariffUpdateCommand());
        commands.put("delete", new TariffDeleteCommand());
        commands.put("create", new TariffCreateCommand());
        commands.put("download", new TariffDownloadCommand());
        commands.put("noCommand", new NoCommand());
    }

    private TariffCommandContainer(){}

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
