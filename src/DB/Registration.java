/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author welcome
 */
public class Registration 
{
    public boolean doRegistration(String name,String email,String mobile,String username,String password )
    {
        boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/datasteganography","root","1234");
            Statement st=conn.createStatement();
            
            String query="insert into registration_info values ('"+name+"','"+email+"','"+mobile+"','"+username+"','"+password+"')";
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
        }
        catch(Exception ex)
        {
            System.out.println("Exception is: "+ex);
        }
        return flag;
    }
}
