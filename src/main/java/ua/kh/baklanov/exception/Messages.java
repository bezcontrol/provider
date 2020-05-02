package ua.kh.baklanov.exception;

/**
 * Messages is a class that contains info and error strings for logger and exceptions
 *
 * @author Aleksei Baklanov
 */
public final class Messages {

    public static final String ERROR_OBTAIN_CONNECTION="Can't obtain connection";
    public static final String ERROR_CONTEXT_CREATING_FACTORY ="Can't create data source in factory";
    public static final String ERROR_INSERT="Can't insert in database entity: ";
    public static final String ERROR_UPDATE = "Can't update in database entity: ";
    public static final String ERROR_DELETE = "Can't delete in database entity: ";
    public static final String ERROR_EXTRACTING = "Can't extract entity ";
    public static final String ERROR_GET_USER_BY_LOGIN = "Can't get user by login";
    public static final String ERROR_GET_USER_BEAN_BY_LOGIN ="Can't get user bean by login" ;
    public static final String ERROR_GET_USER_BY_EMAIL = "Can't get user by email";
    public static final String ERROR_GET_USER_BEAN_BY_EMAIL = "Can't get user bean by email";
    public static final String ERROR_GET_SERVICE_BY_TARIFF_ID = "Can't get service by tariff id";
    public static final String ERROR_GET_ALL_RECORDS = "Can't get all records from db with instance ";
    public static final String ERROR_GET_PART_OF_RECORDS = "Can't get part of records from db with instance ";
    public static final String ERROR_FIND_USER_WITH_THIS_CREDENTIALS ="Cannot find user with such login/password";
    public static final String ERROR_FORWARD = "Can't forward to page in controller ";
    public static final String ERROR_REDIRECT = "Can't redirect to page in controller ";
    public static final String ERROR_EXECUTING_COMMAND = "Error when executing this command";
    public static final String ERROR_ACCESS_WAITING = "Wait for adding to system by our administrator";
    public static final String ERROR_USER_DAO = "Error when using user dao in command: ";
    public static final String ERROR_TV_DAO = "Error when using tv dao in command: ";
    public static final String ERROR_FIELDS_NULL = "Fields are null in command: ";
    public static final String ERROR_ANY_TARIFF_DAO = "Error when using any tariff dao in command: ";
    public static final String ERROR_ROLLBACK_TRANSACTION = "Error when trying to rollback transaction";
    public static final String ERROR_COMMIT_TRANSACTION = "Error when trying to commit transaction";
    public static final String ERROR_CLASS_LOADER = "Error loading classes in class loader";
    public static final String INFO_CLASS_LOADER_START = "Class loader start working...";
    public static final String INFO_CLASS_LOADER_SUCCESS = "Class loader successfully load all classes";
    public static final String INFO_FACTORY_INIT = "Factory doesn't exist. Initializing database factory.";
    public static final String INFO_GET_FACTORY = "Trying to get database factory";
    public static final String INFO_EXECUTING_COMMAND = "Executing command: ";
    public static final String INFO_SUCCESSFULLY_INSERTED="Successfully inserted entity: ";
    public static final String INFO_SUCCESSFULLY_UPDATED ="Successfully updated entity: ";
    public static final String INFO_SUCCESSFULLY_DELETED ="Successfully deleted entity: ";
    public static final String INFO_CONTEXT_INITIALIZED = "Context had been successfully initialized";
    public static final String INFO_DATASOURCE_INITIALIZED = "Data source had been successfully initialized";
    public static final String INFO_CONNECTION_OBTAINED = "Connection had been successfully obtained";
    public static final String INFO_GET_ANY_TARIFF_ALL = "Trying to get all AnyTariffs of class ";
    public static final String INFO_GET_ANY_TARIFF_TV_WITH_TYPE =
            "Trying to get AnyTariff with service type TV with tv type ";
    public static final String INFO_GET_ALL_ANY_TARIFF = "Trying to get all AnyTariff";
    public static final String INFO_GET_BY_ID = "Trying to get by id entity of class ";
    public static final String ERROR_GET_BY_ID = "Can't getting by id entity of class ";
    public static final String ERROR_BEAN_EXTRACTOR_UTIL = "Error when using bean extractor in command: ";
    public static final String INFO_GET_ALL_RECORDS = "Trying to get all instances of class: ";
    public static final String INFO_GET_INTERNET_TYPED_RECORDS = "Get internet records of type: ";
    public static final String ERROR_TARIFF_DAO = "Error when using tariff dao in command:";
    public static final String INFO_GET_BY_NAME = "Getting by name entity: ";
    public static final String ERROR_GET_BY_NAME = "Error getting by name entity: ";
    public static final String ERROR_ROLE_DAO = "Error when using role dao in command: ";
    public static final String ERROR_STATUS_DAO = "Error when using status dao in command: ";
    public static final String ERROR_USER_IS_BLOCKED = "This account has been blocked";
    public static final String ERROR_SUPPORTING_USER_IN_ACTUAL_STATE = "Error when supported user by " +
            "updating him in session";
    public static final String ERROR_CASE_FORMATTER_TAG = "Error when changing case in appropriate custom tag";

    private Messages(){}

}
