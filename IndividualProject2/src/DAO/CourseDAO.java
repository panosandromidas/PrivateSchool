/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class CourseDAO {
    
    public static void insertCourse(Course course) throws SQLException{
        String sql="insert into courses values(null,'"+course.getTitle()+"','"+course.getType()+"','"+course.getStart_date()+"','"+course.getEnd_date()+"');";
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        statement.executeUpdate(sql);
        con1.close();
    }
    
        
        public static  void  getAllCourses() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM COURSES");
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

