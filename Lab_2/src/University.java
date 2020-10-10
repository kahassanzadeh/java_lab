/**
 * this class created for the university
 * we can add departments in it
 *
 * @author MOhammadreza Hassanzadeh
 * @version 0.0
 * @since 2020-08-10
 */



public class University {

    // departments of the university
    private Department[] departments;

    // name of the university
    private String name;

    // array of the committee members
    private String[] committee;

    /**
     * constructor for this class adding just the name of the university
     * @param name university name
     */
    public University(String name) {
        this.name = name;
    }

    /**
     * getting the name of the university
     * @return name of the university
     */
    public String getName() {
        return name;
    }

    /**
     * getting the array of the departments of the university
     * @return university departments
     */
    public Department[] getDepartments() {
        return departments;
    }

    /**
     * getting the committee members of the university
     * @return array of committee members
     */
    public String[] getCommittee() {
        return committee;
    }

    /**
     * setting the array of the committee members
     * @param committee array of committee members
     */
    public void setCommittee(String[] committee) {
        this.committee = committee;
    }

    /**
     * setting an array of departments of the university
     * @param departments array of the university
     */
    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    /**
     * setting the name of the university
     * @param name name of the university
     */
    public void setName(String name) {
        this.name = name;
    }
}
