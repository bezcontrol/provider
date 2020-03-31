package ua.kh.baklanov.web.command.tariff;

import ua.kh.baklanov.web.command.AbstractCommand;
import ua.kh.baklanov.web.command.NoCommand;

import java.util.Map;
import java.util.TreeMap;

public final class TariffCommandContainer {
    private static Map<String, AbstractCommand> commands = new TreeMap<>();

    static {
        commands.put("Details", new TariffDetailsCommand());
        commands.put("Update", new TariffUpdateCommand());
        commands.put("Delete", new TariffDeleteCommand());
        commands.put("Create", new TariffCreateCommand());
        commands.put("AddToCart", new AddToCartCommand());
        commands.put("downloadPDF", new TariffDownloadPDFCommand());
        commands.put("downloadTXT", new TariffDownloadTXTCommand());
        commands.put("getSingleTariff", new GetSingleTariffCommand());
        commands.put("deleteFromCart", new DeleteFromCartCommand());
        commands.put("contractRequest", new ContractRequestCommand());
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
