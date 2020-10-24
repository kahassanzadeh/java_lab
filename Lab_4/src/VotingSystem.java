import java.util.ArrayList;

/**
 * this class is for creating a voting system and managing the question and vote
 *
 * @author Mohammadreza Hassanzadeh
 * @since Oct 24,2020
 * @version 1.0
 */
public class VotingSystem {
    //creating the voting array
    private ArrayList<Voting> votingList;

    /**
     * constructor for voting system
     */
    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    /**
     * with this method we can creat a new vote by giving the question and its type and its choices
     * @param question question of the vote
     * @param type type of the vote : 1 -> a person can vote more than 1 time , 0 -> a person can vote only 1 time
     * @param choices choices of the question
     */
    public void creatVoting(String question,int type,ArrayList<String> choices){
        Voting voting = new Voting(type,question);
        for(String ch : choices){
            voting.createPollChoices(ch);
        }
        votingList.add(voting);
        System.out.println("This voting has been successfully created");
    }

    /**
     * getter for getting the voting list
     * @return voting list
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    /**
     * this method is for printing all the question that have been added to this voting system.
     */
    public void printListOfVoting(){
        int counter = 1;
        for(Voting vt : votingList){
            System.out.println(counter + "." + vt.getQuestion());
        }
    }

    /**
     * this method will print the question and its choices giving the index of the question
     * @param index index of the question
     */
    public void printVoting(int index){
        int counter = 1;
        if(index < votingList.size() && index >= 0){
            System.out.println("Question : " + votingList.get(index).getQuestion());
            ArrayList<String> choices = new ArrayList<>(votingList.get(index).getPolls().keySet());
            for(String ch  :choices){
                System.out.println(counter + "." + ch);
                counter++;
            }
        }
    }

    /**
     * this method will store the vote that a person voted
     * @param index index of the question
     * @param person the person who has vote
     * @param votes array list of the votes if the type was 1 the person can choose more than 1 choices
     */
    public void vote(int index , Person person,ArrayList<String> votes){
        if(index < votingList.size() && index >= 0){
            votingList.get(index).vote(person,votes);
        }
    }

    /**
     * by giving the index this method would print the result of the voting
     * @param index index of the question
     */
    public void printResults(int index){
        System.out.println("The title of the question : " + votingList.get(index).getQuestion());
        System.out.println("Voters : ");
        votingList.get(index).printVoters();
        System.out.println("Result : ");
        votingList.get(index).printVotes();
    }

    /**
     * this method will generate random vote a person
     * @param index index of the question
     * @param person the person who wants to random voting
     */
    public void randomVoting(int index,Person person){
        if(index < votingList.size() && index >= 0){
            votingList.get(index).usingRandomChoice(person);
        }
    }
}
