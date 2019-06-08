import java.sql.*;

public class Database {
    public static void main(String[] args) throws Exception{
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/test?user=test&password=test");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery("select CF, Reddito from Cliente");

        while (r.next()) {
            System.out.print(r.getString("CF") + " " + r.getString("Reddito"));
        }
    }
}