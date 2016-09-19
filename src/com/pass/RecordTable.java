package com.pass;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class RecordTable extends JTable implements ListSelectionListener {
    private static final String[] COLUMN_NAMES = new String[]{"User Type", "No. of Attempts"};
    private int lastAddedRow;
	private RecordWindow rw;
    public RecordTable(RecordWindow rw) {
		this.rw=rw;
        this.setModel(new DefaultTableModel(COLUMN_NAMES, 4));
		this.getSelectionModel().addListSelectionListener(this);
    }

    public void addRow(Object[] rowData) {
        for(int i = 0; i < rowData.length; i++) {
            this.dataModel.setValueAt(rowData[i], lastAddedRow, i); // add and increment counter
        }
        lastAddedRow++;
    }
	
	public void resetRowCounter(){
		lastAddedRow =0;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		File f = new File(LoginWindow.FILE_STORAGE_PATH);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		rw.lblOutput.setText("<html>"+this.getValueAt(this.getSelectedRow(),0).toString()+" has logged in "+this.getValueAt(this.getSelectedRow(),1).toString()+" time(s).<br>Last Modified: "+sdf.format(f.lastModified())+"</html>");
	}
}
