/**
 * this class has the department's information in it
 * all the classe and the labs and the courses can be add to this class
 *
 * @author MOhammadreza Hassanzadeh
 * @version 0.0
 * @since 2020-08-10
 */
public class Department {

    //name of the department
    private String name;

    //all the labs
    private Lab[] labs;

    //capacity of the department
    private int capacity;

    //number of the students in this department
    private int numberOfStudents;

    //list of courses
    private String[] courses;

    //name of faculty members
    private String[] nameFacultyMembers;

    //sum of the size of all classes that exists in this department
    private int classSize;

    //list of all students
    private Student[] students;

    //head faculty of the department
    private String headFaculty;


    /**
     * constructor of this class
     * @param name name of the department
     * @param capacity capacity of the department
     * @param nameFacultyMembers array of faculty members
     * @param classSize size of the classes
     */
    public Department(String name,int capacity,String[] nameFacultyMembers,int classSize){
        this.name = name;
        this.capacity = capacity;
        this.nameFacultyMembers = nameFacultyMembers;
        this.classSize = classSize;
    }

    /**
     * getting the name of the department
     * @return name of department
     */
    public String getName(){
        return name;
    }

    /**
     * getting the labs of the department
     * @return labs of the department
     */
    public Lab[] getLabs(){
        return labs;
    }

    /**
     * getting the capacity of the department
     * @return capacity of the department
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * getting the number of the students
     * @return number of all students
     */
    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    /**
     * getting the course list of the students
     * @return courses array
     */
    public String[] getCourses(){
        return courses;
    }
    /**
     * getting the list of faculty members of the department
     * @return array of faculty members
     */
    public String[] getNameFacultyMembers(){
        return nameFacultyMembers;
    }

    /**
     * getting the class size of the department
     * @return class size
     */
    public int getClassSize(){
        return classSize;
    }

    /**
     * getting the array of all students of the department
     * @return aray of the students
     */
    public Student[] getStudents(){
        return students;
    }

    /**
     * getting the head faculty of the department
     * @return head faculty
     */
    public String getHeadFaculty(){
        return headFaculty;
    }

    /**
     * setting the name of the department
     * @param name name of the department
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * setting labs array of the department
     * @param labs labs of the department
     */
    public void setLabs(Lab[] labs){
        this.labs = labs;
    }

    /**
     * setting the capacity of the department
     * @param capacity capacity of the department
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    /**
     * setting the number of students of the department
     * @param numberOfStudents number of students of the department
     */
    public void setNumberOfStudents(int numberOfStudents){
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * setting course list of the department
     * @param courses array of the courses
     */
    public void setCourses(String[] courses){
        this.courses = courses;
    }

    /**
     * setting the list of the faculty members
     * @param nameFacultyMembers faculty  members of the department
     */
    public void setNameFacultyMembers(String[] nameFacultyMembers){
        this.nameFacultyMembers = nameFacultyMembers;
    }

    /**
     * setting the class size of the department
     * @param classSize class size of the department
     */
    public void setClassSize(int classSize){
        this.classSize = classSize;
    }

    /**
     * setting the array of the students of the department
     * @param students array of the department
     */
    public void setStudents(Student[] students){
        this.students = students;
    }

    /**
     * setting the head faculty of the department
     * @param headFaculty the head master of the department
     */
    public void setHeadFaculty(String headFaculty) {
        this.headFaculty = headFaculty;
    }
}
