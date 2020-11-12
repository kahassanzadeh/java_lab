import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * class for just designing the view of out calculator
 *
 * @author Mohammadreza Hassanzadeh
 * @version 1.0
 * @since Nov 13 2020
 */
public class CalculatorGUI {

    //frame of our GUI
    JFrame jframe = new JFrame();
    //Simple Calculator Tab
    JPanel simpleCalc;
    //Scientific Calculator Tab
    JPanel scientificCalc;

    /**
     * constructor for this class
     * making a new Calculator GUI
     */
    public CalculatorGUI(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        jframe = new JFrame();
        jframe.setTitle("AUT LAB_7 GUI for Calculator");
        jframe.setSize(300,500);
        jframe.setLocation(810,310);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeSimplePanel();
        makingScientificCalc();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Simple Calc",simpleCalc);
        tabs.addTab("Scientific Calc",scientificCalc);
        jframe.add(tabs);
        jframe.setVisible(true);

    }

    /**
     * making the simple calculator tab
     */
    private void makeSimplePanel() {
        simpleCalc = new JPanel();
        simpleCalc.setLayout(new BorderLayout());

        JTextArea text = new JTextArea(2,10);
        text.setEditable(true);
        text.setFont(new Font("Times New Roman",Font.BOLD,25));
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        text.setBorder(border);


        JPanel keyBoardPanel = new JPanel();
        keyBoardPanel.setLayout(new GridLayout(5,4));
        keyBoardPanel.setBorder(border);


        JButton[] numbers = new JButton[10];
        for(int i = 0;i < 10; i++){
            numbers[i] = new JButton();
            numbers[i].setText("" + i);
        }
        JButton[] operator = new JButton[10];
        for(int i = 0;i < 10;i++){
            operator[i] = new JButton();
        }
        operator[0].setText("C/CE");
        operator[1].setText("mod");
        operator[2].setText("+");
        operator[3].setText("-");
        operator[4].setText("/");
        operator[5].setText("*");
        operator[6].setText("=");
        operator[7].setText("%");
        operator[8].setText(".");
        operator[9].setText("+/-");
        keyBoardPanel.add(operator[0]);
        keyBoardPanel.add(operator[7]);
        keyBoardPanel.add(operator[9]);
        keyBoardPanel.add(operator[1]);
        keyBoardPanel.add(numbers[9]);
        keyBoardPanel.add(numbers[8]);
        keyBoardPanel.add(numbers[7]);
        keyBoardPanel.add(operator[2]);
        keyBoardPanel.add(numbers[6]);
        keyBoardPanel.add(numbers[5]);
        keyBoardPanel.add(numbers[4]);
        keyBoardPanel.add(operator[3]);
        keyBoardPanel.add(numbers[3]);
        keyBoardPanel.add(numbers[2]);
        keyBoardPanel.add(numbers[1]);
        keyBoardPanel.add(operator[4]);
        keyBoardPanel.add(operator[6]);
        keyBoardPanel.add(numbers[0]);
        keyBoardPanel.add(operator[8]);
        keyBoardPanel.add(operator[5]);

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setPreferredSize(new Dimension(50, 100));

        simpleCalc.add(scrollPane,BorderLayout.NORTH);
        simpleCalc.add(keyBoardPanel,BorderLayout.CENTER);
    }

    /**
     * making the scientific calculator tab
     */
    private void makingScientificCalc() {
        scientificCalc = new JPanel();
        scientificCalc.setLayout(new BorderLayout());

        JTextArea text = new JTextArea(2,10);
        text.setEditable(true);
        text.setFont(new Font("Times New Roman",Font.BOLD,25));
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        text.setBorder(border);


        JPanel keyBoardPanel = new JPanel();
        keyBoardPanel.setLayout(new GridLayout(5,5));
        keyBoardPanel.setBorder(border);


        JButton[] numbers = new JButton[12];
        for(int i = 0;i < 10; i++){
            numbers[i] = new JButton();
            numbers[i].setText("" + i);
        }
        numbers[10] = new JButton();
        numbers[11] = new JButton();
        numbers[10].setText("e");
        numbers[11].setText("Pi");

        JButton[] operator = new JButton[16];
        for(int i = 0;i < 16;i++){
            operator[i] = new JButton();
        }
        operator[0].setText("Shift");
        operator[1].setText("C/CE");
        operator[2].setText("+");
        operator[3].setText("-");
        operator[4].setText("/");
        operator[5].setText("*");
        operator[6].setText("=");
        operator[7].setText("%");
        operator[8].setText("sin");
        operator[9].setText("tan");
        operator[10].setText("cos");
        operator[11].setText("cot");
        operator[12].setText("log");
        operator[13].setText("exp");
        operator[14].setText("ln");
        operator[15].setText(".");
        keyBoardPanel.add(numbers[11]);
        keyBoardPanel.add(numbers[10]);
        keyBoardPanel.add(operator[7]);
        keyBoardPanel.add(operator[12]);
        keyBoardPanel.add(operator[14]);
        keyBoardPanel.add(numbers[9]);
        keyBoardPanel.add(numbers[8]);
        keyBoardPanel.add(numbers[7]);
        keyBoardPanel.add(operator[2]);
        keyBoardPanel.add(operator[8]);
        keyBoardPanel.add(numbers[6]);
        keyBoardPanel.add(numbers[5]);
        keyBoardPanel.add(numbers[4]);
        keyBoardPanel.add(operator[3]);
        keyBoardPanel.add(operator[9]);
        keyBoardPanel.add(numbers[3]);
        keyBoardPanel.add(numbers[2]);
        keyBoardPanel.add(numbers[1]);
        keyBoardPanel.add(operator[4]);
        keyBoardPanel.add(operator[13]);
        keyBoardPanel.add(operator[6]);
        keyBoardPanel.add(numbers[0]);
        keyBoardPanel.add(operator[15]);
        keyBoardPanel.add(operator[5]);
        keyBoardPanel.add(operator[0]);

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setPreferredSize(new Dimension(50, 100));

        scientificCalc.add(scrollPane,BorderLayout.NORTH);
        scientificCalc.add(keyBoardPanel,BorderLayout.CENTER);
    }





}
