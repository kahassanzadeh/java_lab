/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 *
 * @author MOhammadreza Hassanzadeh
 * @version 0.0
 * @since 2020-08-10
 */
public class Student {
    //The student's first name
    private String firstName;

    //The student's last name
    private String lastName;

    // The student's Id
    private String id;

    // the grade
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lName last name of student
     * @param sID student ID
     */
    public Student(String fName,String lName,String sID){
        firstName = fName;
        lastName = lName;
        id = sID;
        grade = 0;
    }

    /**
     * get the first name of student
     * @return firstName field
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * get the last name of student
     * @return lastname field
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * get the ID of student
     * @return ID field
     */
    public String getId(){
        return id;
    }
    /**
     * get the grade's of student
     * @return grade field
     */
    public int getGrade(){
        return grade;
    }


    /**
     * @param fName set first name of a student
     */
    public void setFirstName(String fName){
        firstName = fName;
    }
    /**
     * @param  lName last name of a student
     */
    public void setLastName(String lName){
        lastName = lName;
    }
    /**
     * @param  Id id of a student
     */
    public void setId(String Id){
        id = Id;
    }
    /**
     * @param  grade grade of a student
     */
    public void setGrade(int grade){
        this.grade = grade;
    }


    /**
     * Print the student’s last name and ID number to the output terminal.
     */
    public void print(){
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }

}
