


/**
 * this class created for a new lab
 * adding students to this lab and creating a capacity for this lab and managing the grades
 *
 *
 * @author Mohammadreza Hassanzadeh
 * @version 0.0
 * @since 2020-08-10
 */

public class Lab {
    //students of Lab
    private Student[] students ;

    //average grade of the lab
    private int avg;

    //day of th lab
    private String day;

    //capacity of the lab
    private int capacity;

    //current number of students that enrolled this lab
    private int currentSize;

    /**
     * constructor of the lab setting capacity and day
     * @param cap capacity of the lab
     * @param d day of the lab
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
    }

    /**
     * enrolling students in the lab
     * @param std student
     */
    //call-by-reference
    public void enrollStudent(Student std) {
        if (currentSize < capacity){
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * printing the students of the lab
     */
    public void print() {
        /*
        the problem of that code in the Lab pdf, is that arrays don't have size method but we can use .length instead.
        the size of the array is constant. for that reason we should iterate just the currentSize of the class. maybe the capacity is
        higher than that and if we iterate more than currentSize we will get Errors and problems during printing.
        and i think it's better to use "for each" instead of normal "for" and
         */
        for (int i = 0;i < currentSize;i++) {
            System.out.println("First Name : " + students[i].getFirstName());
            System.out.println("Last Name : " + students[i].getLastName());
            System.out.println("Id : " + students[i].getId());
        }
        System.out.println("Avg : " + avg);
    }

    /**
     * getting the students array
     * @return the students array
     */
    public Student[] getStudents() {
        return  students;
    }

    /**
     * setting a new students array
     * @param students students array
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * getting the average of the class
     * @return average of the class
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculating the average of the class
     */
    public void calculateAvg() {
        int sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        avg = sum / currentSize;
    }

    /**
     * getting the day of the class
     * @return day of the class
     */
    public String getDay() {
        return day;
    }

    /**
     * setting a new day
     * @param day a new day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * getting the capacity of the lab
     * @return capacity of the lab
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * setting a new capacity for the lab
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * setting current sie of the class
     * @param currentSize current size of the class
     */
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

}
