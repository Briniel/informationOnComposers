package MIvanov;

import java.sql.*;

/**
 * Created by IvaMA on 01.03.2019
 */


public class DBConnect {

    private int ID = 5;

    private static Connection connectDatabase() {
        Connection c;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-- All Operations done successfully");
        return null;
    }

    private static void closeConnect() throws SQLException {
        connectDatabase().close();
    }

    public void SELECT(String nameArtist) throws SQLException {
        Connection selectC = connectDatabase();
        Statement stmt;

        stmt = selectC.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name_artist FROM table_name where name_artist ='" + nameArtist + "';");
        while (rs.next()) {
            String name = rs.getString("name_artist");
            System.out.println(String.format(name));
        }
        rs.close();
        stmt.close();
        selectC.commit();
        System.out.println("-- Operation SELECT done successfully");
        closeConnect();
    }

    public void INSERT(String nameArtist, String nameAlbum) throws SQLException {
        Connection selectC = connectDatabase();
        Statement stmt;
        String sql;

        stmt = selectC.createStatement();
        sql = "INSERT INTO table_name (ID,name_artist,album) VALUES (" + ID + ",'" + nameArtist + "','" + nameAlbum + "');";
        stmt.executeUpdate(sql);
        System.out.println("-- Records created successfully");
//        closeConnect();
        ID++;
    }



}
