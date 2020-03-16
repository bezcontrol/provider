package ua.kh.baklanov.exception;

public class Messages {

    public static final String ERROR_OBTAIN_CONNECTION="Can't obtain connection";
    public static final String ERROR_CONTEXT_CREATING_DB="Can't create data source in factory";
    public static final String INFO_SUCCESSFULLY_INSERTED=" had been successfully inserted";
    public static final String INFO_SUCCESSFULLY_UPDATED =" had been successfully inserted" ;
    public static final String ERROR_INSERT="Can't insert in database entity: ";
    public static final String ERROR_UPDATE = "Can't update in database entity: ";
    public static final String ERROR_DELETE = "Can't delete in database entity: ";
    public static final String ERROR_EXTRACTING = "Can't extract entity ";
    public static final String ERROR_GET_USER_BY_LOGIN = "Can't get user by login";
    public static final String ERROR_GET_USER_BY_EMAIL = "Can't get user by email";
    public static final String ERROR_GET_USER_BY_ID = "Can't get user by id";
    public static final String ERROR_GET_RECORDS = "Can't get all records from db with";
    public static final String ERROR_CREATING_FACTORY = "Can't create these factory: ";
    public static final String ERROR_CREATING_DAO = "Can't create dao: ";
    public static final String ERROR_AUTHENTICATION_FORM = "Login/password cannot be empty";
    public static final String ERROR_FIND_USER_WITH_THIS_CREDENTIALS ="Cannot find user with such login/password";
    public static final String ERROR_FORWARD = "Can't forward to page in controller ";
    public static final String ERROR_REDIRECT = "Can't redirect to page in controller ";
    public static final String ERROR_EXECUTING_COMMAND = "Error when executing this command";
    public static final String ERROR_ACCESS_WAITING = "Wait for adding to system by our administrator";
    public static final String ERROR_USER_DAO = "Error when using user dao in command: ";
    public static final String ERROR_TV_DAO = "Error when using tv dao in command: ";
    public static final String FIELDS_NULL = "Fields are null in command: ";
    public static final String ERROR_TARIFF_DAO = "Error when using tariff dao in command: ";

    private Messages(){}

}
