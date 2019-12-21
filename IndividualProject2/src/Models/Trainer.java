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
public class Trainer {
     //----fields-----------
    private String FirstName;
    private String LastName;
    private String course;
    
    //-------setters and getters-----------

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    //--------------------------------------------------------
    //-----------constructor

    public Trainer(String FirstName, String LastName, String course) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Trainer{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", course=" + course + '}';
    }
    
    
    
    
}
