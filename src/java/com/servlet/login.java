package com.servlet;

import com.db.connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author om
 */
public class login {

    Connection con;
    dbConnection db;
    Statement stmt;

    public Boolean authorizeUser(String UserName, String Password) {
        boolean Islogin = false;
        try {
            db = new dbConnection();
            con = db.GetDbconnection();
            stmt = (Statement) con.createStatement();
            String sql = "select * from login where UserName='" + UserName + "' and Password=" + Password;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Islogin = true;
            }
            con.close();
        } catch (Exception ex) {

        }
        return Islogin;
    }

    public int RegisterUser(String firstName, String lastName, String emailId, String password, String DOB, String Gender, String Mobile) {
        int IsInserted = 0;
        String sql="";
        try {
            db = new dbConnection();
            con = db.GetDbconnection();
            stmt = (Statement) con.createStatement();
            sql = "insert into login(UserName,Password,FirstName,LastName,Mobile,Gender,DOB) values('"+emailId+"','"+password+"','"+firstName+"','"+lastName+"','"+Mobile+"','1','"+DOB+"')";
            IsInserted = stmt.executeUpdate(sql);
            con.close();
        } catch (Exception ex) {

        }
        return IsInserted;
    }
}
