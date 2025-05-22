package pl.umcs.oop;

import pl.umcs.oop.auth.AccountManager;
import pl.umcs.oop.database.DatabaseConnection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.connect("test.db");
        AccountManager am = new AccountManager(db);
        am.register("user123", "password123");
    }
}
