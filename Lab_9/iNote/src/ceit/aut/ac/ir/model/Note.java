package ceit.aut.ac.ir.model;
// TODO: Phase2: uncomment this code

import java.io.Serializable;

/**
 * this class created for Notes
 *
 * it implements serializable
 */
public class Note implements Serializable {
    //title of the note
    private String title;
    //written to the note
    private String content;
    //date of the note
    private String date;

    /**
     * constructor for cresting tis object
     *
     * @param title title of the note
     * @param content content of the note
     * @param date date that modified
     */
    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     * get String for the Note
     * @return String of the Note
     */
    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}

