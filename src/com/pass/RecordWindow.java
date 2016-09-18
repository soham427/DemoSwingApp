package com.pass;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class RecordWindow extends JFrame implements Observer {
    private final int COMP_GAP = 30;

    private RecordTable recordTable;
    private JLabel lblSelectedCell;
    private Observable parentWindow;


    public RecordWindow(int pos_x, int pos_y, int width, int height, String title, Observable parentWindow) {
        setTitle(title);
        setBounds(pos_x, pos_y, width, height);
        setMinimumSize(new Dimension(width, height));

        this.parentWindow = parentWindow;
        this.parentWindow.notifyAllObservers(); // Notify everyone

        addComponents();
        addListeners();
        loadRecordData();
        setVisible(true);
    }

    // Add JComponents to the window
    private void addComponents() {
        recordTable = new RecordTable();
        lblSelectedCell = new JLabel("Selected Text: ");

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)); // JFrame's layout
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(new JScrollPane(recordTable));
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
        add(new JScrollPane(lblSelectedCell));
        add(Box.createRigidArea(new Dimension(new Dimension(COMP_GAP, COMP_GAP)))); // Gap
    }

    private void addListeners() {
        // I won't spoil the challenge task, so here it only implements the SelectionListener
        recordTable.getSelectionModel().addListSelectionListener(e -> {
            lblSelectedCell.setText("Selected Text: "
                    + recordTable.getModel().getValueAt(recordTable.getSelectedRow(), recordTable.getSelectedColumn()));
        });
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

    @Override
    public void update() {
        // Basically reload the data and update rows
        recordTable.resetRowCounter();
        loadRecordData();
        addListeners();
    }
}
