package ua.kh.baklanov.web;

public final class Route {
    public static final String ERROR_PAGE = "jsp/error_page.jsp";
    public static final String HOME = "jsp/services.jsp";
    public static final String REGISTRATION = "registration.jsp";
    public static final String LOGIN = "index.jsp";
    public static final String TV_SERVICE = "jsp/tv.jsp";
    public static final String TARIFFS = "jsp/tariffs.jsp";
    public static final String SINGLE_TARIFF = "jsp/single.jsp";
    public static final String ALL_TARIFFS_COM = "/service?command=allTariffs";
    public static final String ADMIN_HOME = "jsp/adminHome.jsp";
    public static final String MY_CART = "jsp/cart.jsp";
    public static final String MY_CONTRACTS_COM = "/tariff?command=allContracts";
    public static final String ADMIN_ORDERS = "jsp/adminOrders.jsp";
    public static final String ADMIN_USERS = "jsp/adminUsers.jsp";
    public static final String ADMIN_USERS_COM="/admin?command=users";
    public static final String ADMIN_ORDERS_COM="/admin?command=orders";
    public static final String MY_CABINET = "jsp/cabinet.jsp";

    private Route(){}
}
