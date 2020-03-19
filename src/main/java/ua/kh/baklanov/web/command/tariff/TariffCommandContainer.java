package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

public final class TariffCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("details", new TariffDetailsCommand());
        commands.put("edit", new TariffUpdateCommand());
        commands.put("delete", new TariffDeleteCommand());
        commands.put("create", new TariffCreateCommand());
        commands.put("downloadPDF", new TariffDownloadPDFCommand());
        commands.put("downloadTXT", new TariffDownloadTXTCommand());
        commands.put("noCommand", new NoCommand());
    }

    private TariffCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
