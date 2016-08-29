package com.pass;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RecordWindow extends JFrame {
    private JLabel lblUser, lblAdmin, lblSu, lblGod;
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
        lblUser = new JLabel("User: ");
        lblAdmin = new JLabel("Admin: ");
        lblSu = new JLabel("Super User: ");
        lblGod = new JLabel("God: ");

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)); // JFrame's layout
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(lblUser);
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(lblAdmin);
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(lblSu);
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(lblGod);
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


        // Update labels
        lblUser.setText(lblUser.getText() + userRecord.userCount);
        lblAdmin.setText(lblAdmin.getText() + userRecord.adminCount);
        lblSu.setText(lblSu.getText() + userRecord.superUserCount);
        lblGod.setText(lblGod.getText() + userRecord.godCount);
    }
}
