import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * sample of a voting System for US election
 */
public class Main {

    public static void main(String[] args) {
        VotingSystem newVote = new VotingSystem();
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Yes");
        choices.add("No");

        newVote.creatVoting("will biden win the election of US ?",0,choices);
        ArrayList<String> votes = new ArrayList<>();
        votes.add("Yes");

        Person p1 = new Person("Ali", "Razeghi");
        Person p2 = new Person("Mohammad", "Honarjoo");
        Person p3 = new Person("Gholi", "Rezayi");
        Person p4 = new Person("Hamed", "Ahmadi");
        Person p5 = new Person("Reza", "Ahmadi");
        Person p6 = new Person("Mahdi", "Mohammadi");
        Person p7 = new Person("Reza", "Rezayi" );


        newVote.randomVoting(0,p5);
        newVote.randomVoting(0,p6);
        newVote.randomVoting(0,p7);


        ArrayList<String> vote1 = new ArrayList<>();
        ArrayList<String> vote2 = new ArrayList<>();
        ArrayList<String> vote3 = new ArrayList<>();
        ArrayList<String> vote4 = new ArrayList<>();
        vote1.add("No");
        vote2.add("No");
        vote3.add("Yes");
        vote4.add("Yes");


        newVote.vote(0,new Person("kamyar","hassanzadeh"),votes);
        newVote.vote(0, p1,vote1);
        newVote.vote(0, p2,vote2);
        newVote.vote(0, p3,vote3);
        newVote.vote(0, p4,vote4);
        newVote.printResults(0);

    }
}
