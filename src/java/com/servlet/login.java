package com.servlet;

import com.db.connection.*;
import static java.rmi.server.LogStream.log;

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
            log(ex.getMessage());
        }
        return Islogin;
    }
}
