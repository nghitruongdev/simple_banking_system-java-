package banking;

import java.sql.*;

class SQL {
    final static String DROP_TABLE = "DROP TABLE IF EXISTS card";
    final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS card(\n" +
            "\tid INTEGER,\n" +
            "\tnumber TEXT,\n" +
            "\tpin TEXT,\n" +
            "\tbalance INTEGER DEFAULT 0\n" +
            ");";
    final static String INSERT_TABLE = "INSERT INTO card (number, pin, balance) values (?, ?, ?)";
}

public class MyDB {

    private static String dbName;

    public static void setDbName(String dbName) {
        MyDB.dbName = dbName;
    }

    private static Connection connectDB() throws SQLException {
        String url = "jdbc:sqlite:" + dbName;
        return DriverManager.getConnection(url);
    }

    public static void createTable() {
        try (Connection con = connectDB()){
            try (Statement stm = con.createStatement()) {
                stm.execute(SQL.DROP_TABLE);
                stm.execute(SQL.CREATE_TABLE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertCard(Card card) {
        try  (Connection con = connectDB()){
            try (PreparedStatement stm = con.prepareStatement(SQL.INSERT_TABLE)) {
                stm.setObject(1, card.getCardNumber());
                stm.setObject(2, card.getCardPin());
                stm.setObject(3, card.getBalance());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
