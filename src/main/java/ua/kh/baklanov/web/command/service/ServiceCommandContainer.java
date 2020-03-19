package ua.kh.baklanov.web.command.service;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoAbstractCommand;

import java.util.Map;
import java.util.TreeMap;

public final class ServiceCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("tvTypes", new TypesTVAbstractCommand());
        commands.put("tvTariffs", new TVTariffsAbstractCommand());
        commands.put("pcTariffs", new PCTariffsAbstractCommand());
        commands.put("mobileTariffs", new MobileTariffsAbstractCommand());
        commands.put("allTariffs", new AllTariffsAbstractCommand());
        commands.put("noCommand", new NoAbstractCommand());
    }

    private ServiceCommandContainer(){}

    public static AbstractCommand get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
