import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

// FOR  PRINTING
import java.awt.print.PageFormat;

import java.awt.print.PrinterJob;


class Reappear_List extends JFrame implements ActionListener
{
	public static void main(String args[])
	{
		String ppp = "2012-2016";
		new Reappear_List(ppp);
	}
Connection con;
PreparedStatement pst,pst2;
ResultSet rst,rst2;
JTable table;
JButton refresh,pnt;
String passer;
	public Reappear_List(String ps)
	{
		passer =ps;
		setLayout(new BorderLayout());
		
		Data();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("STUDENTS LIST WITH REAPPEAR RECORD");
getContentPane().setBackground(new Color(255,160,122));
setSize(1200,700);
setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);	

JPanel south = new JPanel(new FlowLayout());
refresh = new JButton("Refresh");
pnt = new JButton("PRINT");
JLabel jspace = new JLabel("             ");
Font ff = new Font("Segoe Print",Font.BOLD,20);
refresh.setFont(ff);		pnt.setFont(ff);	jspace.setFont(ff);
refresh.addActionListener(this);
pnt.addActionListener(this);
		south.add(refresh);		south.add(jspace);		south.add(pnt);
		add(south,BorderLayout.SOUTH);
	}

	public void Data()
	{
		try
		{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");

pst = con.prepareStatement("select * from REAPPEARS ORDER BY roll_no",ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
			pst2 = con.prepareStatement("select * from INFO where batch=? ORDER BY roll_no_id");
			
			pst2.setString(1,passer);
			rst = pst.executeQuery();
			rst2 =pst2.executeQuery();
			
table = new JTable();
table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
ResultSetMetaData rstm = rst.getMetaData();
int column = rstm.getColumnCount();
DefaultTableModel dtm = new DefaultTableModel();

Vector col = new Vector();
Vector data = new Vector();

	col.addElement("ROLL NO.");
	col.addElement("Batch");
	col.addElement("REAPPEARS");
		dtm.setColumnIdentifiers(col);


while(rst2.next())
{
		while(rst.next())
		{
			if(rst.getLong(1) == rst2.getLong(1))
			{
				data = new Vector();
				data.addElement(rst.getLong(1));
				//data.addElement(rst2.getString(2));
				data.addElement(rst.getString(2));
				dtm.addRow(data);
				
			}
			
		}
		rst.beforeFirst();
}

			table.setModel(dtm);
			table.setRowHeight(30);
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(175);
		//cm.getColumn(1).setPreferredWidth(150);
		cm.getColumn(1).setPreferredWidth(1500);


add(table,BorderLayout.CENTER);
table.setFont(new Font("Segoe Print",Font.BOLD,20));
table.setBackground(new Color(255,160,122));
table.setForeground(new Color(220,20,60));
JScrollPane sp = new JScrollPane(table);
sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
add(sp);

		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(null,ex.getMessage());
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == refresh)
		{
			new Reappear_List(passer);
			dispose();
		}
		if(ae.getSource() == pnt)
		{
 PrinterJob pjob = PrinterJob.getPrinterJob();
PageFormat preformat = pjob.defaultPage();
preformat.setOrientation(PageFormat.LANDSCAPE);
PageFormat postformat = pjob.pageDialog(preformat);
//If user does not hit cancel then print.
if (preformat != postformat) {
    //Set print component
    pjob.setPrintable(new Printer(table), postformat);
    if (pjob.printDialog()) {
        try {
            pjob.print();
        } catch (Exception ex) {
           
        }
    }
}
		}
	}

}