package ua.kh.baklanov.exception;

public class Messages {
    private Messages(){}

    public static final String ERROR_OBTAIN_CONNECTION="Can't obtain connection";
    public static final String ERROR_CONTEXT_CREATING_DB="Can't create data source in factory";
    public static final String INFO_SUCCESSFULLY_INSERTED=" had been successfully inserted";
    public static final String INFO_SUCCESSFULLY_UPDATED =" had been successfully inserted" ;
    public static final String ERROR_INSERT="Can't insert in database entity: ";
    public static final String ERROR_UPDATE = "Can't update in database entity: ";
    public static final String ERROR_DELETE = "Can't delete in database entity: ";
    public static final String ERROR_EXTRACTING = "Can't extract entity ";
    public static final String ERROR_GET_USER_BY_LOGIN = "Can't get user by login";
    public static final String ERROR_GET_USER_BY_ID = "Can't get user by id";
    public static final String ERROR_GET_ALL_RECORDS = "Can't get all records from db with";
    public static final String ERROR_CREATING_FACTORY = "Can't create these factory: ";
}
