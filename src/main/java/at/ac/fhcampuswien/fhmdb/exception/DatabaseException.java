package at.ac.fhcampuswien.fhmdb.exception;

import java.sql.SQLException;


// is used to throw exception when database is f.e not online or no entry found
public class DatabaseException extends SQLException {
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}