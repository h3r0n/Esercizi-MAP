import java.sql.*;

public class MySQL {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/test?user=user&password=password");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery("select CF, Reddito from Cliente");

        while (r.next()) {
            System.out.println(r.getString("CF"));
            System.out.println(r.getString("Reddito"));
        }

        c.close();
    }
}