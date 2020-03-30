package ua.kh.baklanov.web.controller;

public final class TextFields {

    private static final String CONTRACT_CONCLUSION_DATE ="Contract conclusion date: ";
    private static final String INTERNET_SPEED ="Internet speed: ";
    private static final String INTERNET_TECHNOLOGY ="Internet technology: ";
    private static final String MINUTES_INSIDE_COUNTRY ="Minutes inside country: ";
    private static final String MINUTES_OUTSIDE_COUNTRY ="Minutes outside country: ";
    private static final String MOBILE_NUMBER_OF_SMS ="SMS: ";
    private static final String MOBILE_NUMBER_OF_MBTS ="Internet(mbts): ";
    private static final String PC_CONNECTED_PC ="Available number of connected PC: ";
    private static final String TARIFF_NAME ="Tariff: ";
    private static final String TARIFF_PRICE ="Price: ";
    private static final String TARIFF_DURATION_IN_DAYS ="Duration(days): ";
    private static final String TV_TYPE ="Type: ";
    private static final String TV_NUMBER_OF_CHANNELS ="Channels: ";
    private static final String USER_LOGIN ="Your login: ";
    private static final String USER_EMAIL ="Your email: ";
    private static final String USER_BILL ="Bill: ";
    private static final String USER_ROLE ="Role: ";
    private static final String USER_STATUS ="Status: ";

    public static String getUserRole() {
        return USER_ROLE;
    }

    public static String getUserStatus() {
        return USER_STATUS;
    }

    public String getContractConclusionDate() {
        return CONTRACT_CONCLUSION_DATE;
    }

    public String getInternetSpeed() {
        return INTERNET_SPEED;
    }

    public String getInternetTechnology() {
        return INTERNET_TECHNOLOGY;
    }

    public String getMobileMinutesInside() {
        return MINUTES_INSIDE_COUNTRY;
    }

    public String getMobileMinutesOutside() {
        return MINUTES_OUTSIDE_COUNTRY;
    }

    public String getMobileNumberOfSMS() {
        return MOBILE_NUMBER_OF_SMS;
    }

    public String getMobileNumberOfMbts() {
        return MOBILE_NUMBER_OF_MBTS;
    }

    public String getPcConnectedPC() {
        return PC_CONNECTED_PC;
    }

    public String getTariffName() {
        return TARIFF_NAME;
    }

    public String getTariffPrice() {
        return TARIFF_PRICE;
    }

    public String getTariffDurationInDays() {
        return TARIFF_DURATION_IN_DAYS;
    }

    public String getTvType() {
        return TV_TYPE;
    }

    public String getTvNumberOfChannels() {
        return TV_NUMBER_OF_CHANNELS;
    }

    public String getUserLogin() {
        return USER_LOGIN;
    }

    public String getUserEmail() {
        return USER_EMAIL;
    }

    public String getUserBill() {
        return USER_BILL;
    }
}
