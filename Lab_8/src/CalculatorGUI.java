import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.HashMap;

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

    private boolean validForDisplayOperators;
    private HashMap<String,JButton> buttonsKeyboard = new HashMap<>();
    //private HashMap<String,JButton> buttonsKeyboard2 = new HashMap<>();
    private KeyBoardHandler keyboardHandler = new KeyBoardHandler();
    private KeyBoardHandler2 keyboardHandler2 = new KeyBoardHandler2();
    private JMenuItem copyItem;
    private boolean shiftPressed = false;



    JTextArea text;
    JTextArea text2;



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
        jframe.setTitle("AUT LAB_8 GUI for Calculator");
        jframe.setSize(400,500);
        jframe.setLocation(810,310);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text = new JTextArea(2,10);
        text2 = new JTextArea(2,10);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setToolTipText("Menu Bar");
        JMenu menuFile = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        menuFile.add(exit);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
        menuFile.add(copyItem);
        JMenu menuHelp = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
        menuBar.add(menuFile);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jframe,"AUT calculator for AP LAB","About",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuHelp.add(about);
        menuBar.add(menuHelp);
        jframe.setJMenuBar(menuBar);
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


        text.setEditable(false);
        text.setFont(new Font("Times New Roman",Font.BOLD,25));
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        text.setBorder(border);

        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection selection = new StringSelection(text.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection,selection);
            }
        });

        validForDisplayOperators = false;
        text.addKeyListener(keyboardHandler);


        JPanel keyBoardPanel = new JPanel();
        keyBoardPanel.setLayout(new GridLayout(5,4));
        keyBoardPanel.setBorder(border);


        JButton[] numbers = new JButton[10];
        for(int i = 0;i < 10; i++){
            numbers[i] = new JButton();
            numbers[i].setToolTipText("Button for " + i);
            numbers[i].setText("" + i);
            numbers[i].addKeyListener(keyboardHandler);
            numbers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton temp = (JButton) e.getSource();
                    text.append(temp.getText());
                }
            });
        }
        JButton[] operator = new JButton[10];
        for(int i = 1;i < 10;i++){
            operator[i] = new JButton();
            operator[i].addKeyListener(keyboardHandler);
            operator[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton temp = (JButton) e.getSource();
                    if (temp.getText().equals("+")) {
                        text.append("+");
                    }
                    if (temp.getText().equals("*")) {
                        text.append("*");
                    }
                    if (temp.getText().equals("-")) {
                        text.append("-");
                    }
                    if (temp.getText().equals("/")) {
                        text.append("/");
                    }
                    if (temp.getText().equals("%")) {
                        text.append("%");
                    }
                    if(temp.getText().equals("=")){
                        try {
                            Double result = calculationWithString(text.getText());
                            text.setText(result.toString());
                        }
                        catch (Exception e1){text.setText("Wrong input");}
                    }
                    if(temp.getText().equals(".")) {
                        if(validForDisplayOperators ) {
                            try {
                                String lastFloat = text.getText().substring(text.getText().lastIndexOf(" "));
                                if (lastFloat.contains("."))
                                    return;
                                text.append(".");
                            }catch (StringIndexOutOfBoundsException exception){
                                if(text.getText().contains("."))
                                    return;
                                text.append(".");
                            }
                        }
                    }
                }
            });
        }
        operator[0] = new JButton();
        operator[0].setText("CE");
        operator[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });
        operator[1].setText("mod");
        operator[2].setText("+");
        operator[3].setText("-");
        operator[4].setText("/");
        operator[5].setText("*");
        operator[6].setText("=");
        operator[7].setText("%");
        operator[8].setText(".");
        operator[9].setText("+/-");
        /*buttonsKeyboard.put(operator[0].getText(),operator[0]);
        buttonsKeyboard.put(operator[1].getText(),operator[1]);
        buttonsKeyboard.put(operator[2].getText(),operator[2]);
        buttonsKeyboard.put(operator[3].getText(),operator[3]);
        buttonsKeyboard.put(operator[4].getText(),operator[4]);
        buttonsKeyboard.put(operator[5].getText(),operator[5]);
        buttonsKeyboard.put(operator[6].getText(),operator[6]);
        buttonsKeyboard.put(operator[7].getText(),operator[7]);
        buttonsKeyboard.put(operator[8].getText(),operator[8]);
        buttonsKeyboard.put(operator[9].getText(),operator[8]);*/
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

        text2.setEditable(true);
        text2.setFont(new Font("Times New Roman",Font.BOLD,25));
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        text2.setBorder(border);
        text2.addKeyListener(keyboardHandler2);

        scientificCalc = new JPanel();
        scientificCalc.setLayout(new BorderLayout());

        JPanel keyBoardPanel = new JPanel();
        keyBoardPanel.setLayout(new GridLayout(5,5));
        keyBoardPanel.setBorder(border);

        JButton[] numbers = new JButton[12];
        for(int i = 0;i < 10; i++){
            numbers[i] = new JButton();
            numbers[i].setText("" + i);
            numbers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton temp = (JButton) e.getSource();
                    text2.append(temp.getText());
                }
            });
        }
        numbers[10] = new JButton();
        numbers[11] = new JButton();
        numbers[10].setText("e");
        numbers[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.append("3.14159265359");
            }
        });
        numbers[11].setText("Pi");
        numbers[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text2.append("2.71828");
            }
        });

        JButton[] operator = new JButton[16];
        for(int i = 0;i < 16;i++){
            operator[i] = new JButton();
            operator[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton temp = (JButton) e.getSource();
                    if (temp.getText().equals("+")) {
                        text2.append("+");
                    }
                    if (temp.getText().equals("*")) {
                        text2.append("*");
                    }
                    if (temp.getText().equals("-")) {
                        text2.append("-");
                    }
                    if (temp.getText().equals("/")) {
                        text2.append("/");
                    }
                    if (temp.getText().equals("%")) {
                        text2.append("%");
                    }
                    if(temp.getText().equals("=")){
                        try {
                            Double result = calculationWithString(text2.getText());
                            text2.setText(result.toString());
                        }
                        catch (Exception e1){text2.setText("Wrong input");}
                    }
                    if(temp.getText().equals(".")) {
                        try {
                            String lastFloat = text2.getText().substring(text2.getText().lastIndexOf(" "));
                            if (lastFloat.contains("."))
                                return;
                            text2.append(".");
                        }catch (StringIndexOutOfBoundsException exception){
                            if(text2.getText().contains("."))
                                return;
                            text2.append(".");
                        }
                    }
                    if (temp.getText().equals("tan")) {
                        text2.append("tan(");
                    }
                    if (temp.getText().equals("sin")) {
                        text2.append("sin(");
                    }
                    if (temp.getText().equals("cot")) {
                        text2.append("cot(");
                    }
                    if (temp.getText().equals("cos")) {
                        text2.append("cos(");
                    }
                    if(temp.getText().equals("Shift")){
                        operator[8].setText("cos");
                        operator[9].setText("cot");
                    }
                    if(temp.getText().equals("C/CE")){
                        text2.setText("");
                    }
                }
            });
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
        keyBoardPanel.add(operator[1]);
        keyBoardPanel.add(operator[5]);
        keyBoardPanel.add(operator[0]);

        JScrollPane scrollPane = new JScrollPane(text2);
        scrollPane.setPreferredSize(new Dimension(50, 100));

        scientificCalc.add(scrollPane,BorderLayout.NORTH);
        scientificCalc.add(keyBoardPanel,BorderLayout.CENTER);
    }

    /**
     * this keyboardHandler is for simple calculator textField
     */
    private class KeyBoardHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
            if(buttonsKeyboard.containsKey("" + e.getKeyChar())){
                buttonsKeyboard.get("" + e.getKeyChar()).doClick();
            }
            if(buttonsKeyboard.containsKey("" + KeyEvent.getKeyText(e.getKeyCode()))){
                buttonsKeyboard.get( "" + KeyEvent.getKeyText(e.getKeyCode())).doClick();
            }*/
            char keyChar = e.getKeyChar();
            if(keyChar == '1'){
                text.append("1");
            }
            if(keyChar == '2'){
                text.append("2");
            }
            if(keyChar == '3'){
                text.append("3");
            }
            if(keyChar == '4'){
                text.append("4");
            }
            if(keyChar == '5'){
                text.append("5");
            }
            if(keyChar == '6'){
                text.append("6");
            }
            if(keyChar == '7'){
                text.append("7");
            }
            if(keyChar == '8'){
                text.append("8");
            }
            if(keyChar == '9'){
                text.append("9");
            }
            if(keyChar == '/'){
                text.append("/");
            }
            if(keyChar == '*'){
                text.append("*");
            }
            if(keyChar == '+'){
                text.append("+");
            }
            if(keyChar == '-'){
                text.append("-");
            }
            if(keyChar == '%'){
                text.append("%");
            }
            if(keyChar == '=' || keyChar == '\n'){
                buttonsKeyboard.get("=").doClick();
            }
        }
    }

    /**
     * this keyboardHandler is for scientific calculator textField
     */
    private class KeyBoardHandler2 extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
            if(buttonsKeyboard.containsKey("" + e.getKeyChar())){
                buttonsKeyboard.get("" + e.getKeyChar()).doClick();
            }
            if(buttonsKeyboard.containsKey("" + KeyEvent.getKeyText(e.getKeyCode()))){
                buttonsKeyboard.get( "" + KeyEvent.getKeyText(e.getKeyCode())).doClick();
            }*/
            char keyChar = e.getKeyChar();
            if(keyChar == '1'){
                text2.append("1");
            }
            if(keyChar == '2'){
                text2.append("2");
            }
            if(keyChar == '3'){
                text2.append("3");
            }
            if(keyChar == '4'){
                text2.append("4");
            }
            if(keyChar == '5'){
                text2.append("5");
            }
            if(keyChar == '6'){
                text2.append("6");
            }
            if(keyChar == '7'){
                text2.append("7");
            }
            if(keyChar == '8'){
                text2.append("8");
            }
            if(keyChar == '9'){
                text2.append("9");
            }
            if(keyChar == '/'){
                text2.append("/");
            }
            if(keyChar == '*'){
                text2.append("*");
            }
            if(keyChar == '+'){
                text2.append("+");
            }
            if(keyChar == '-'){
                text2.append("-");
            }
            if(keyChar == '%'){
                text2.append("%");
            }
            if(keyChar == '=' || keyChar == '\n'){
                buttonsKeyboard.get("=").doClick();
            }
        }
    }

    /**
     * this method will calculate the equation by the String that is existed in the textField
     * @param expression the equation
     * @return calculated number
     */
    private Double calculationWithString(String expression){
        String[] numbers = expression.split("[+-/*%]");
        String operator = expression.replaceAll("\\d","");
        switch (operator) {
            case "+":
                return Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
            case "-":
                return Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
            case "/":
                if (Double.parseDouble(numbers[1]) == 0) {
                    throw new ArithmeticException("Zero division Error");
                }
                return Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
            case "*":
                return Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
            case "%":
                return Double.parseDouble(numbers[0]) % Double.parseDouble(numbers[1]);
        }
        if(expression.contains("tan(")){
            return Math.tan(Double.parseDouble(expression.substring(4)));
        }
        if(expression.contains("cos(")){
            return Math.cos(Double.parseDouble(expression.substring(4)));
        }
        if(expression.contains("sin(")){
            return Math.sin(Double.parseDouble(expression.substring(4)));
        }
        if(expression.contains("cot(")){
            return 1/Math.tan(Double.parseDouble(expression.substring(4)));
        }
        return 0.0;
    }




}
