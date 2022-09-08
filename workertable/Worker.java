package org.workertable;

import java.sql.*;

public class Worker {
    public Statement getStatement(){
        Connection con=null;
        Statement st=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/workertable","root","password");
            st= con.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return st;

    }
    public void getUpperCase(){
        String sql=null;
        String st=null;
        try{
            sql="select upper(concat(First_name,' ',Last_Name)) AS Fullname from workertable";
            ResultSet rs=getStatement().executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    public void getDepartment(){
        String sql=null;
        String st=null;
        try{
            sql="select distinct Department from workertable";
            ResultSet rs=getStatement().executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
    public void getPosition(){
        String sql=null;
        String st=null;
        try{
            sql="Select INSTR(BINARY First_name,'a') from workertable where First_name = 'Amitabh'";
            ResultSet rs=getStatement().executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {

       Worker ob=new Worker();
        System.out.println("SQL query to fetch “FIRST_NAME, LAST_NAME” from the Worker table using the alias name as “FULL_NAME” results in ``UPPER CASE.");
       ob.getUpperCase();
        System.out.println("SQL query to fetch unique values of DEPARTMENT from Worker");
        ob.getDepartment();
        System.out.println("SQL query to find the position of the alphabet (‘a’) in the first name column ‘Amitabh’ from the Worker-Table.");
        ob.getPosition();





    }



}
