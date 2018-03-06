
package com.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Account {
    
    //declare var
    String user="root";
    String pass="";
    String url="jdbc:mysql://localhost:3306/hospital";
    String driver="com.mysql.jdbc.Driver";
     Connection con;
       PreparedStatement pstmt;
    //load the driver
    void dbConnect() throws ClassNotFoundException, SQLException{
        Class.forName(driver);//load driver
        con=(Connection) DriverManager.getConnection(url, user, pass);//create connection
        
    }
    void dbClose() throws SQLException{
        con.close();
    }
    
    public void insertPatientInfo(String name,String contact,String age,String doctor_name,String date,String time) throws ClassNotFoundException, SQLException{
        dbConnect();
        String sql="insert into patient(name,contact,age,dname,date,time) values(?,?,?,?,?,?)";
         pstmt=(PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, contact);
        pstmt.setString(3, age);
        pstmt.setString(4, doctor_name);
        pstmt.setString(5, date);
        pstmt.setString(6, time);
        pstmt.executeUpdate();
        
        dbClose();
    }
    
    public ResultSet  fetchPatient() throws ClassNotFoundException, SQLException{
        dbConnect();
        String sql="select * from patient where date=?";
         pstmt=(PreparedStatement) con.prepareStatement(sql);
         DateFormat df=DateFormat.getDateInstance();
         String d=df.format(new Date());
         pstmt.setString(1, d);
        ResultSet rst=pstmt.executeQuery();
        
         return rst;
       
     }
    
    public ResultSet  fetchPatientTomorrow() throws ClassNotFoundException, SQLException{
        dbConnect();
        String sql="select * from patient where date=?";
          DateFormat df= DateFormat.getDateInstance();
        Calendar c=Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        Date d1=c.getTime();//tomorrows date
        String d2=df.format(d1);
         pstmt=(PreparedStatement) con.prepareStatement(sql);
         pstmt.setString(1, d2);
        ResultSet rst=pstmt.executeQuery();
        
         return rst;
       
       
    }
    public boolean deletePatientAppointment(String name,String dname,String date,String time) throws ClassNotFoundException, SQLException{
      boolean status=false;
        dbConnect();
        String sql ="delete  from patient where name=? and dname=? and date=? and time=? ";
          pstmt= (PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, dname);
        pstmt.setString(3, date);
        pstmt.setString(4, time);
        
        pstmt.executeUpdate();
        status=true;
        dbClose();
        
    return status;
    }
    
}
