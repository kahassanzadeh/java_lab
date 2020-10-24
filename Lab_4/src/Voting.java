import ir.huri.jcal.JalaliCalendar;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * this class is for storing,running and executing the voting process
 *
 *
 * @author Mohammadreza Hassanzadeh
 * @since Oct 24,2020
 * @version 1.0
 */
public class Voting {
    //storing the type of the vote
    private int type;
    //storing the people that have voted
    private ArrayList<Person> voters;
    //storing the question of the voting
    private String question;
    //this variable is used for storing a choice and its voters
    private HashMap<String, HashSet<Vote>> polls;

    /**
     * constrictor for the voting
     * @param type type of the voting
     * @param question question of the voting
     */
    public Voting(int type,String question){
        this.question = question;
        this.type = type;
        voters = new ArrayList<>();
        polls = new HashMap<>();
    }

    /**
     * getter for the question
     * @return the question of the voting
     */
    public String getQuestion() {
        return question;
    }

    /**
     * this method will make a new choice and initiate the HashSet
     * @param choice the choice that we want to add
     */
    public void createPollChoices(String choice){
        polls.put(choice,new HashSet<>());
    }

    /**
     * this method will add the vote by getting the person and the choices that we want to vote
     * @param person the voter
     * @param choices choice or a choice that we want to vote
     */
    public void vote(Person person,ArrayList<String> choices){
        LocalDate localDateObj = LocalDate.now();
        GregorianCalendar gc = GregorianCalendar.from(localDateObj.atStartOfDay(ZoneId.systemDefault()));
        JalaliCalendar date = new JalaliCalendar(gc);
        Vote temp = new Vote(person,date);
        if(!voters.contains(person)){
            if(type == 0){
                voters.add(person);
                polls.get(choices.get(0)).add(temp);
                System.out.printf("vote submitted in %s Thank you for voting \n",temp.getDate());
            }
            else if(type == 1){
                voters.add(person);
                for(String ch : choices){
                    if(polls.containsKey(ch)){
                        polls.get(ch).add(temp);
                    }
                    System.out.printf("All the votes submitted in %s Thank you for voting",temp.getDate());
                }
            }
        }
        else{
            System.out.println("This person had been voted");
        }
    }

    /**
     * this method will print the voters name and their info
     */
    public void printVoters() {
        int counter = 1;
        for(Person pr : voters){
            System.out.println(counter + "." + pr.toString());
            counter++;
        }
    }

    /**
     * this method will return the choices and its voters
     * @return HashMap list of the Choices and the voters
     */
    public HashMap<String, HashSet<Vote>> getPolls() {
        return polls;
    }

    /**
     * printing the votes of a specific choice
     */
    public void printVotes(){
        int counter = 1;
        for(String qs : polls.keySet()){
            System.out.println(counter + "." + qs  +
                    " has " + polls.get(qs).size() + " votes");
            counter++;
        }
    }

    /**
     * getting the type of the voting
     * @return integer of the voting
     */
    public int getType() {
        return type;
    }

    /**
     * this method will generate a random vote for a person
     * @param person voter info
     */
    public void usingRandomChoice(Person person){
        Random random = new Random();
        ArrayList<String> choices = new ArrayList<>(polls.keySet());
        String choice = choices.get(random.nextInt(choices.size()));
        ArrayList<String> tempChoicesForThisPerson = new ArrayList<String>();
        tempChoicesForThisPerson.add(choice);
        vote(person,tempChoicesForThisPerson);
    }

}
