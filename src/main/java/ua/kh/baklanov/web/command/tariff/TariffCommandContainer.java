package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoAbstractCommand;

import java.util.Map;
import java.util.TreeMap;

public final class TariffCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("details", new TariffDetailsAbstractCommand());
        commands.put("edit", new TariffUpdateAbstractCommand());
        commands.put("delete", new TariffDeleteAbstractCommand());
        commands.put("create", new TariffCreateAbstractCommand());
        commands.put("download", new TariffDownloadAbstractCommand());
        commands.put("noCommand", new NoAbstractCommand());
    }

    private TariffCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
