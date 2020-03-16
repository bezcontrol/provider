package ua.kh.baklanov.web.command.service;

import ua.kh.baklanov.web.command.Command;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

public class ServiceCommandContainer {
    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("tvTypes", new TypesTVCommand());
        commands.put("tvTariffs", new TVTariffsCommand());
        commands.put("pcTariffs", new PCTariffsCommand());
        commands.put("mobileTariffs", new MobileTariffsCommand());
        commands.put("allTariffs", new AllTariffsCommand());
        commands.put("noCommand", new NoCommand());
    }

    private ServiceCommandContainer(){}

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
