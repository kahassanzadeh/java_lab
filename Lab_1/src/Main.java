import javax.swing.*;


public class Main {

    public static void main(String[] args) {
	    String str = JOptionPane.showInputDialog("please a the first number");
	    int firstNumber = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("please a the second number");
        int secondNumber = Integer.parseInt(str);
        int gcd = 1;
        if(secondNumber > firstNumber){
            int tmp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = tmp;
        }
        for(int foo = 1 ; foo <= secondNumber ; foo++){
            if((firstNumber % foo == 0) && (secondNumber % foo == 0)){
                gcd = foo;
            }
        }
        if(gcd == 1){
            System.out.print("they are comprime integers");
        }
        else{
            System.out.print("they aren't comprime integers");
        }
    }
}
