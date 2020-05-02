package ua.kh.baklanov.web.command.service;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class that contains commands for pages with services
 * @author Aleksei Baklanov
 */
public final class ServiceCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("tvTypes", new TypesTVCommand());
        commands.put("tvTariffs", new TVTariffsCommand());
        commands.put("pcTariffs", new PCTariffsCommand());
        commands.put("mobileTariffs", new MobileTariffsCommand());
        commands.put("allTariffs", new AllTariffsCommand());
        commands.put("noCommand", new NoCommand());
    }

    private ServiceCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
