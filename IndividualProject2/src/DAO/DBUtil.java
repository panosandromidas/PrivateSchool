/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author panos
 */
public class DBUtil {
    private static final String USERNAME = "root";
    private static final String PASS = "PANOS1991";
    private static final String MYSQLURL = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    
    public static Connection getconnection(){
        Connection con = null;
        
        try{
            con = DriverManager.getConnection(MYSQLURL,USERNAME,PASS);
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        };
        return con;
    }
    
    public static void  display(String s) throws SQLException{
        Connection con1 = DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery(s);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
            con1.close();
    }
    
}
