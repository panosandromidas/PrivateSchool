/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author panos
 */
public class Course {
    //-----fields---------
    private String title;
    
    private String type;
    private String start_date;
    private String end_date;
//    private ArrayList<Student> allStu=new ArrayList<>();
//    private ArrayList<Trainer> allTra=new ArrayList<>();
//    private ArrayList<Assignment> allAss=new ArrayList<>();
    
    //---setters and getters---------------

    
    
    
    
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Course(String title, String type, String start_date, String end_date) {
        this.title = title;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    

    

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", type=" + type + ", start_date=" + start_date + ", end_date=" +  '}';
    }
    
}
