package com.pass;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RecordTable extends JTable {
    private static final String[] COLUMN_NAMES = new String[]{"User Type", "No. of Attempts"};
    private int lastAddedRow;

    public RecordTable() {
        this.setModel(new DefaultTableModel(COLUMN_NAMES, 4));
    }

    public void addRow(Object[] rowData) {
        for(int i = 0; i < rowData.length; i++) {
            this.dataModel.setValueAt(rowData[i], lastAddedRow, i); // add and increment counter
        }
        lastAddedRow++;
    }
}
