package pl.umcs.oop;

import pl.umcs.oop.database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.connect("test.db");
        try(Statement stmt = db.getConnection().createStatement()) {

            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS test(
                    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    value TEXT NOT NULL)
                    """);
            stmt.executeUpdate("""
                    INSERT INTO test(value) VALUES ("val1"), ("val2");
                    """);

            ResultSet rs = stmt.executeQuery("""
                    SELECT * FROM test;
                    """);

            while(rs.next()) {
                System.out.println(rs.getInt(1) + ": " + rs.getString("value"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
