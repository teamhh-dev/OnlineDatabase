/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinedatabase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hamza
 */
public class SCUBEdatabase
{

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public SCUBEdatabase()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12390392", "sql12390392", "liruK2TmAH");
            st = con.createStatement();

        } catch (Exception ex)
        {
            System.out.println("Error is found :" + ex);
        }
    }

    public void getData()
    {
        try
        {
            String sql = "select * from test";
            rs = st.executeQuery(sql);
            System.out.println("Data from online Database :");
            while (rs.next())
            {
                String name = rs.getString("name");

                System.out.println("Name:" + name);
            }

        } catch (Exception ex)
        {
            System.out.println("Error is found :" + ex);
        }
    }

    public void insertData()
    {
        String sql = "insert into test(name) values('ahmad')";
        try
        {
            st.executeUpdate(sql);
        } catch (SQLException ex)
        {
            Logger.getLogger(SCUBEdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
