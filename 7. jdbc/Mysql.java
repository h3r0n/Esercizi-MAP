import java.sql.*;


public class Mysql {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery("SELECT FIRST, LAST, EMAIL " +
                                        "FROM people.csv people " +
                                        "WHERE " +
                                        "(LAST='" + args[0] + "') " +
                                        " AND (EMAIL Is Not Null) " +
                                        "ORDER BY FIRST"
                                        );
        
        while (r.next()) {
            for (int i=1; i<=3; i++) {
                System.out.print( r.getString(i) + " " );
            }
            System.out.println();
        }

        s.close();
    }
}