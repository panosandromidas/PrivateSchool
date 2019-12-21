/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject2;

import DAO.AssignmentDAO;
import DAO.CourseDAO;
import DAO.Relationship;
import DAO.StudentDAO;
import DAO.TrainerDAO;
import Models.Assignment;
import Models.Course;
import Models.Student;
import Models.Trainer;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author panos
 */
public class Initialization {

    public Initialization() throws SQLException {
        int a1=0;
        int a2=0;
        int a3=0;
        int a4=0;

        Scanner input = new Scanner(System.in);

        //------------------------------------------------------------------------------------------------
        int exit4 = 1;

        while (exit4 != 0) {

            //=============ftiaxnw to course==========================
            System.out.println("dwse 0 an 8eleis na proxwrhsei alliws 1 gia na baleis course ");
            a1 = input.nextInt();
            if (a1 == 0) {
                break;
            }

            System.out.println("Dwse osous ma8htes esy 8es..");

            System.out.println("Dwse to titlo tou course ;");
            String title = input.next();
            System.out.println("Dwse to typo tou course:");
            String type = input.next();
            System.out.println("Dwse thn hmeromhnia pou 3ekinaei :");
            String age1 = input.next();
            System.out.println("Dwse thn hmeromhnia pou teleiwnei :");
            String age2 = input.next();

            Course cs = new Course(title, type, age1, age2);
            CourseDAO.insertCourse(cs);
            //allStudents.add(st3);

            System.out.println("dwse 0 an 8eleis na proxwrhsei alliws 1 gia na baleis ma8hth ");
            exit4 = input.nextInt();
        }

        System.out.println(
                "o pinakas courses  einai : ");
        CourseDAO.getAllCourses();

        //--------------------------------------------------------------------------------------------------------------     
        int exit1 = 1;
        //Student s = null;
        while (exit1
                != 0) {
            //=============ftiaxnw to ma8hth==========================
            System.out.println("dwse 0 an 8eleis na proxwrhsei alliws 1 gia na baleis ma8hth ");
            a2 = input.nextInt();
            if (a2 == 0) {
                break;
            }
            System.out.println("Dwse osous ma8htes esy 8es..");
            //exit1=input.nextInt();
            System.out.println("Dwse onoma ma8hth ;");
            String name = input.next();
            System.out.println("Dwse to epi8eto tou:");
            String surname = input.next();
            System.out.println("Dwse thn hlikia toy:");
            String age = input.next();

            Student st3 = new Student(name, surname, age);
            StudentDAO.insertStudent(st3);
            //allStudents.add(st3);

            System.out.println("dwse 0 an 8eleis na proxwrhsei alliws 1 gia na baleis ma8hth ");
            exit1 = input.nextInt();
        }

        System.out.println("o pinakas students einai : ");
                
        StudentDAO.getAllStudents();
        if((a1 !=0) && (a2!=0)){ // ----gia na parei sysxethsh otan exei balei ma8hth kai ma8hma alliws na mh balei
            
            Relationship.CreateStudentPerCourse();}

        // ---------------------------------------------------------------------------------------------------------
        int exit2 = 1;
        while (exit2
                != 0) {
            System.out.println("dwse 0 an 8eleis na proxwrhsei h 1 gia na baleis trainer");
             a3 = input.nextInt();
            if (a3 == 0) {
                break;
            }
            //=============edw ftiaxnw tous trainers===================================
            System.out.println("======edw ftiaxnoumai tous trainers..");
            //exit2=input.nextInt();
            System.out.println("Dwse to onoma tou trainer: ");
            String nameTrainer = input.next();
            System.out.println("Dwse to epi8eto tou :");
            String surnTrainer = input.next();
            System.out.println("Dwse to ma8hma toy :");
            String couTrainer = input.next();

            Trainer tr = new Trainer(nameTrainer, surnTrainer, couTrainer);
            TrainerDAO.insertTrainer(tr);
            //allTrainers.add(tr);
            System.out.println("dwse 0 an 8eleis na proxwrhsei h 1 gia na baleis trainer");
            exit2 = input.nextInt();
        }

        System.out.println(
                "o pinakas twn trainers einai : ");
        TrainerDAO.getAllTrainers();
        if((a1!=0)&&(a3!=0)){
            Relationship.CreateTrainerPerCourse();}
        

        // --------------------------------------------------------------------------------------------
        int exit3 = 1;
        while (exit3
                != 0) {
            System.out.println("dwse 0 gia na proxwrhseis h pata to 1 gia na dwseis assignment ");
             a4 = input.nextInt();
            if (a4 == 0) {
                break;
            }
            //============ftiaxnw ta assignments====================================
            System.out.println("dwse ta assignments ");
            //exit3=input.nextInt();
            System.out.println("dwse to titlo tou assignment :");
            String titleAss = input.next();
            System.out.println("Dwse th perigrafh ");
            String perigrafh = input.next();
            System.out.println("Dwse thn hmera paradoshs ");
            String dateass = input.next();

            Assignment ass = new Assignment(titleAss, perigrafh, dateass);
            AssignmentDAO.insertAssignment(ass);
            //allAss.add(ass);
            System.out.println("dwse 0 gia na proxwrhseis h pata to 1 gia na dwseis assignment ");
            exit3 = input.nextInt();
        }

        System.out.println(
                "o pinakas twn assignment einai : ");
        AssignmentDAO.getAllAssignments();
        if((a1 !=0) && (a4 !=0)){Relationship.CreateAssignmentPerCourse();}
        
        //----------------------------------------------------------------------------------------------------------- 
        //------------ edw emfanizontai ta assignments gia ka8e ma8hth
        System.out.println("ta assignments gia ka8e ma8hth einai :");
            Relationship.getAllAssignmentsPerStudent();
        System.out.println("oi ma8htes poy anhkoun panw apo se ena ma8hma einai :"); 
            Relationship.getAstudentBelongsMoreCourses();
    }
}
