/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author panos
 */
public class Relationship {
    
    public static  void  getAllStudentsPerCourse() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT S.FIRST_NAME,S.LAST_NAME FROM STUDENT S WHERE S.STUDENT_ID=(SELECT CS.STUDENT_ID FROM COURSE_STUDENT CS WHERE CS.COURSE_ID=(SELECT C.COURSE_ID FROM COURSES C WHERE C.TITLE='JAVA' AND C.TYPE='FULL TIME'));");
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
    
    public static  void  getAllTrainersPerCourse() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT CT.TRAINER_ID,TR.FIRST_NAME,TR.LAST_NAME FROM COURSE_TRAINER CT,TRAINERS TR WHERE (CT.COURSE_ID=(SELECT C.COURSE_ID FROM COURSES C WHERE C.TITLE='JAVA' AND C.TYPE='FULL TIME')) AND (CT.TRAINER_ID=TR.TRAINER_ID)");
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
    
    
    public static  void  getAllAssignmentsPerCourse() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("select  ca.assignment_id, ass.title, ass.description from  course_assignment ca, assignments ass where (ca.course_id=(select c.course_id from courses c where c.title='csharp' and c.type='full time')) and (ca.assignment_id=ass.assignment_id );");
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
    
    public static void CreateStudentPerCourse() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        statement.executeUpdate("insert into course_student values((select max(course_id) from courses),(select max(student_id) from students));");
        
    con1.close();
    }
    
    public static void CreateTrainerPerCourse() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        statement.executeUpdate("insert into course_trainer values((select max(course_id) from courses),(select max(trainer_id) from trainers));");
        
    con1.close();
    }
    
    
    public static void CreateAssignmentPerCourse() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        statement.executeUpdate("insert into course_assignment values((select max(course_id) from courses),(select max(assignment_id) from assignments));");
        
    con1.close();
    }
    
    // ------------------------------------- assignment per course per student
    public static  void  getAllAssignmentsPerStudent() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("select a.title, s.first_name, s.last_name from course_assignment ca, course_student cs, assignments a, students s where  ca.course_id =  cs.course_id group by title;");
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
    // ---------- get a list of students that belong to more than one courses
    public static  void  getAstudentBelongsMoreCourses() throws SQLException{
        Connection con1 = Utils.DBUtil.getconnection();
        Statement statement = con1.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students where student_id=(select cs.student_id  from course_student cs group by cs.student_id having count(cs.student_id)>=2);");
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
