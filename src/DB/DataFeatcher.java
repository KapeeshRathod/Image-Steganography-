/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class DataFeatcher
{
      public ArrayList getData(String username)
    {
        ArrayList a=new ArrayList();
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/datasteganography","root","1234");
            Statement st=conn.createStatement();
            
            String query="select * from registration_info where user_name='"+username+"' ";
            
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                a.add(rs.getString(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
            }
                
            System.out.println("a is:"+a);
            conn.close();
            st.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        return a;
    }
}
