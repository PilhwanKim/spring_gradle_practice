import java.sql.*;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class Main {

    public static void main(String[] args) throws SQLException{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

        Statement st = null;
        ResultSet rs = null;

        st = con.createStatement();
        rs = st.executeQuery("show databases");

        rs = st.getResultSet();

        while(rs.next()) {
            String str = rs.getString(1);
            System.out.println(str);
        }
    }
}
