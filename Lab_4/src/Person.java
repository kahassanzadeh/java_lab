/**
 * this class is for saving a person Info
 *
 * @author Mohammadreza Hassanzadeh
 * @since Oct 24,2020
 * @version 1.0
 */

public class Person {

    //stores the first name
    private String firstName;
    //stores the last name
    private String lastName;

    /**
     * constructor for Person
     * @param firstName first name of the person
     * @param lastName last name of the person
     */
    public Person(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * getting the last name of the person
     * @return String o the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getting the first name of the person
     * @return String of the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Overriding the toString method
     * @return String of the first name and the last name
     */
    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' ;
    }
}
