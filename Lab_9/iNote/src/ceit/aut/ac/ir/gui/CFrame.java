package ceit.aut.ac.ir.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI designer
 *
 * @author mohammadreza hassanzadeh
 * @version 1.0
 *
 */
public class CFrame extends JFrame implements ActionListener {
    //mainPanel
    private CMainPanel mainPanel;
    //Menu Item
    private JMenuItem newItem;
    //save Item
    private JMenuItem saveItem;
    //exit item
    private JMenuItem exitItem;

    /**
     * vreating a new CFrame
     *
     * @param title title of the cframe
     */
    public CFrame(String title) {
        super(title);

        initMenuBar(); //create menuBar

        initMainPanel(); //create main panel
    }

    /**
     * this method will set a menuBar
     */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("File");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        jmenu.add(newItem);
        jmenu.add(saveItem);
        jmenu.add(exitItem);

        menuBar.add(jmenu);
        setJMenuBar(menuBar);
    }

    /**
     * this method will make mainPanel
     */
    private void initMainPanel() {
        mainPanel = new CMainPanel();
        add(mainPanel);
    }

    /**
     * handling if any action performed
     *
     * @param e action that performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            mainPanel.addNewTab();
        } else if (e.getSource() == saveItem) {
            mainPanel.saveNote();
        } else if (e.getSource() == exitItem) {
            //TODO: Phase1: check all tabs saved ...
            mainPanel.saveNote();
            System.exit(0);
        } else {
            System.out.println("Nothing detected...");
        }
    }
}
