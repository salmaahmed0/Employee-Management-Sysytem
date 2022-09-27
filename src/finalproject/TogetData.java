
package finalproject;


import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TogetData {



    ArrayList<data> list = new ArrayList ();
    static Connection c;
    static Statement s;
    static String query;
    static ResultSet r;

     data getData(int ID) {

        connection c1 = new connection();
        try {

            c = c1.connect();
            s = c.createStatement();
            String f = Integer.toString(ID);
            query = "select * from employees where ID = " + f;
            r = s.executeQuery(query);
            while (r.next()) {
                data u1= new data (r.getString("Name"),r.getString("ID"),r.getString("Password"),r.getString("National_ID"),r.getString("Phone"),
                r.getNString("gender"),r.getString("Address"),r.getString("DateOfBirth"),r.getString("Position"),r.getString("Salary"),r.getString("Bonus"));
                return u1;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}


