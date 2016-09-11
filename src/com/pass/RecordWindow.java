package com.pass;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class RecordWindow extends JFrame {
    private RecordTable recordTable;
    private final int COMP_GAP = 30;

    public RecordWindow(int pos_x, int pos_y, int width, int height, String title) {
        setTitle(title);
        setBounds(pos_x, pos_y, width, height);
        setMinimumSize(new Dimension(width, height));

        addComponents();
        loadRecordData();
        setVisible(true);
    }

    // Add JComponents to the window
    private void addComponents() {
        recordTable = new RecordTable();

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)); // JFrame's layout
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(new JScrollPane(recordTable));
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
    }

    // Load user-record from the disk
    private void loadRecordData() {
        // TODO global var should be replaced by a design pattern

        // Load record data from disk
        UserRecord userRecord = null;
        try {
            userRecord = (UserRecord) PersistenceManager.loadObject(LoginWindow.FILE_STORAGE_PATH);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return; // exit to avoid further nullpointers
        }

        // Update table
        recordTable.addRow(new Object[] {"User", userRecord.userCount});
        recordTable.addRow(new Object[] {"Admin", userRecord.adminCount});
        recordTable.addRow(new Object[] {"Super User", userRecord.superUserCount});
        recordTable.addRow(new Object[] {"God", userRecord.godCount});

    }
}
