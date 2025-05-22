package pl.umcs.oop;

import pl.umcs.oop.auth.AccountManager;
import pl.umcs.oop.database.DatabaseConnection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.connect("test.db");
        AccountManager am = new AccountManager(db);
//        am.register("user123", "password123");
        System.out.println(am.authenticate("user2", "password1234"));

        System.out.println(am.getAccount("1"));
//        am.register("user2", "password1234");
        System.out.println(am.getAccount("3"));
    }
}
