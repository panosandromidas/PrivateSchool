/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Assignment;
import Models.Course;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author panos
 */
public class AssignmentDAO {
    public static  void insertAssignment(Assignment assignment) throws SQLException{
        String sql="insert into assignments values(null,'"+assignment.getTitle()+"','"+assignment.getDescription()+"','"+assignment.getSubDateTime()+"',null,null);";
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        statement.executeUpdate(sql);
        con1.close();
    }
    
    public static  void  getAllAssignments() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ASSIGNMENTS");
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
