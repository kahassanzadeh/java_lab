package ceit.aut.ac.ir.gui;

import ceit.aut.ac.ir.utils.FileUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * this class created for managing Panels
 *
 * @author mohammadreza hassanzadeh
 * @since Dec 17 2020
 * @version 1.0
 */
public class CMainPanel extends JPanel {
    //tabbed panel
    private JTabbedPane tabbedPane;
    //directory list of files
    private JList<File> directoryList;

    /**
     * constructor for CMainPanel
     */
    public CMainPanel() {

        setLayout(new BorderLayout());

        initDirectoryList(); // add JList to main Panel

        initTabbedPane(); // add TabbedPane to main panel

        addNewTab(); // open new empty tab when user open the application
    }

    /**
     * this method will make a new TabbedPane for the CMainPanel
     *
     */
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * this method will make the directory list
     */
    private void initDirectoryList() {
        File[] files = FileUtils.getFilesInDirectory();
        directoryList = new JList<>(files);

        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(130);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());

        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }

    /**
     * this method will make a new Tab and JTextArea
     */
    public void addNewTab() {
        JTextArea textPanel = createTextPanel();
        textPanel.setText("Write Something here...");
        tabbedPane.addTab("Tab " + (tabbedPane.getTabCount() + 1), textPanel);
    }

    /**
     * this method will opens a new note and load the textArea
     *
     * @param content the String
     */
    public void openExistingNote(String content) {
        JTextArea existPanel = createTextPanel();
        existPanel.setText(content);

        int tabIndex = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab("Tab " + tabIndex, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }

    /**
     * this method will save Notes
     */
    public void saveNote() {
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String note = textPanel.getText();
        if (!note.isEmpty()) {
            FileUtils.fileWriter(note);
        }
        updateListGUI();
    }

    /**
     * this method will save all the notes that have been written
     *
     */
    public void saveAllTheNotes(){
        for(int foo = 0; foo < tabbedPane.getComponentCount(); foo++){
            tabbedPane.setSelectedIndex(foo);
            saveNote();
        }
    }

    /**
     * this method will save the current date in note
     */
    public void saveDateOfNote(){
        JTextArea temp = (JTextArea) tabbedPane.getSelectedComponent();
        String notes = temp.getText();
        if(!notes.isEmpty()){
            FileUtils.writeObject(notes);
        }
        updateListGUI();
    }

    /**
     * this method will create the Text Panel
     *
     * @return text panel that created
     */
    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    /**
     * this method will update the GUI List in the mainFrame
     *
     */
    private void updateListGUI() {
        File[] newFiles = FileUtils.getFilesInDirectory();
        directoryList.setListData(newFiles);
    }

    /**
     * inner Class for handling if mouse clicked
     */
    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                //TODO: Phase1: Click on file is handled... Just load content into JTextArea
                File[] curr = FileUtils.getFilesInDirectory();
                File readingFile = curr[index];
                String content;
                if(readingFile.getName().substring(readingFile.getName().length()-4).equals(".txt")){
                    content = FileUtils.fileReader(readingFile);
                }
                else{
                    content = FileUtils.readObject(readingFile);
                }
                openExistingNote(content);
            }
        }
    }


    private class MyCellRenderer extends DefaultListCellRenderer {
        /**
         * this method override to handel the ListCellRenderer
         *
         * @param list list of notes
         * @param object object
         * @param index index of the note
         * @param isSelected if the condition is selected
         * @param cellHasFocus if the condition has focused
         * @return the component
         */
        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof File) {
                File file = (File) object;
                setText(file.getName());
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }
}
