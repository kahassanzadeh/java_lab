import ir.huri.jcal.JalaliCalendar;

import java.util.Objects;

/**
 * this class is for saving the information of the vote
 *
 *
 * @author Mohammadreza Hassanzadeh
 * @since Oct 24,2020
 * @version 1.0
 */
public class Vote {
    //Person who votes
    private Person person;

    //the date that the person votes , it will initialize by the date of the system
    private JalaliCalendar date;

    /**
     * constructor for making the vote
     * @param person the person who votes
     * @param date the date of the vote
     */
    public Vote(Person person,JalaliCalendar date){
        this.date = date;
        this.person = person;
    }

    /**
     * getting the person info
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * getting the date of the vote
     * @return the date of the vote
     */
    public JalaliCalendar getDate() {
        return date;
    }

    /**
     * overriding the equals method
     * @return boolean just like equals method
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(person, vote.person);
    }

    /**
     * Overriding the hashCode method
     * but i didn't change it
     * @return hash of the Object
     */
    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }
}
