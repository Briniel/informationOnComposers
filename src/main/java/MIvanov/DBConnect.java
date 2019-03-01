package MIvanov;

import java.sql.*;

/**
 * Created by IvaMA on 01.03.2019
 */


public class DBConnect {

    private static int ID = 0;

    private int getID() {
        return ID;
    }

    private void setID(int ID) {
        this.ID = ID;
    }

    private static Connection connectDatabase() {
        Connection c;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
            c.setAutoCommit(false);

            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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
        closeConnect();
    }

    public void INSERT(String nameArtist, String nameAlbum) throws SQLException {
        Connection selectC = connectDatabase();
        Statement stmt;
        String sql;
        int id = getID();

        stmt = selectC.createStatement();
        sql = "INSERT INTO table_name (ID, name_artist, album) VALUES (" + id + ",'" + nameArtist.replaceAll("'", "") + "','" + nameAlbum.replaceAll("'", "") + "');";
        stmt.executeUpdate(sql);
        stmt.close();
        selectC.commit();
        selectC.close();
        setID(++id);
    }



}
