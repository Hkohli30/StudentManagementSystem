import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.event.*;

// FOR  PRINTING
import java.awt.print.PageFormat;

import java.awt.print.PrinterJob;

// Main Class

class List extends JFrame implements ActionListener
{
	public static void main(String args[])
	{
		String ppp = "2012-2016";
		new List(ppp);
	}	
PreparedStatement pst,pst2;
ResultSet rst,rst2;
Connection con;
JButton refresh,print;
String passer;
	public List(String pss)
	{
		passer =pss;	
	
		setLayout(new BorderLayout());
		
jt = new JTable();

		datagetter();
Font f = new Font("Segoe Print",Font.BOLD,14);
		jt.setFont(f);
		
		jt.setForeground(new Color(220,20,60));
		jt.setBackground(new Color(245,222,179));
		setSize(1200,700);
setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setTitle("ALL STUDENTS RECORD");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


refresh = new JButton("Refresh");
print = new JButton("PRINT");
print.setFont(new Font("Segoe Print",Font.BOLD,20));
refresh.setFont(new Font("Segoe Print",Font.BOLD,20));

JPanel south = new JPanel(new FlowLayout());
		south.add(refresh);
		south.add(print);
		add(south,BorderLayout.SOUTH);

refresh.addActionListener(this);
print.addActionListener(this);

	}
JTable jt;
public void datagetter() 
{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");	

		pst = con.prepareStatement("select * from Info ORDER BY roll_no_id");
		pst2 = con.prepareStatement("select * from Records ORDER BY roll_no");
		

		rst = pst.executeQuery();
		rst2 = pst2.executeQuery();

jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
ResultSetMetaData rstm = rst.getMetaData();
ResultSetMetaData rstm2 =rst2.getMetaData();
int column = rstm.getColumnCount() + (rstm2.getColumnCount() - 1);
DefaultTableModel dtm = new DefaultTableModel();
Vector col = new Vector();
Vector data = new Vector();

	
	col.addElement("Roll No.");
	col.addElement("NAME");
	col.addElement("Father Name");
	col.addElement("E-Mail");
	col.addElement("Skills");
	col.addElement("Batch");
	col.addElement("Address");
	col.addElement("Number");
	col.addElement("SEM 1"); 	col.addElement("SEM 2"); 	col.addElement("SEM 3"); 
	col.addElement("SEM 4"); 	col.addElement("SEM 5"); 	col.addElement("SEM 6"); 
	col.addElement("SEM 7"); 	col.addElement("SEM 8"); 	
	
	dtm.setColumnIdentifiers(col);

		while(rst.next() && rst2.next())
		{
	if(rst.getString(1).equals(rst2.getString(1)) && rst.getString(6).equals(passer))
{
			data = new Vector();
		data.addElement(rst.getLong(1));
		data.addElement(rst.getString(2));
		data.addElement(rst.getString(3));
		data.addElement(rst.getString(4));
		data.addElement(rst.getString(5));
		data.addElement(rst.getString(6));
		data.addElement(rst.getString(7));
		data.addElement(rst.getLong(8));
		data.addElement(rst2.getInt(2));
		data.addElement(rst2.getInt(3));
		data.addElement(rst2.getInt(4));
		data.addElement(rst2.getInt(5));
		data.addElement(rst2.getInt(6));
		data.addElement(rst2.getInt(7));
		data.addElement(rst2.getInt(8));
		data.addElement(rst2.getInt(9));
		
			dtm.addRow(data);	
}
		}
		jt.setModel(dtm);
		jt.setRowHeight(30);
TableColumnModel columnModel = jt.getColumnModel();
columnModel.getColumn(0).setPreferredWidth(100);
columnModel.getColumn(1).setPreferredWidth(150);
columnModel.getColumn(2).setPreferredWidth(200);
columnModel.getColumn(3).setPreferredWidth(200);
columnModel.getColumn(4).setPreferredWidth(200);
columnModel.getColumn(5).setPreferredWidth(150);
columnModel.getColumn(6).setPreferredWidth(400);
columnModel.getColumn(7).setPreferredWidth(150);


		add(jt,BorderLayout.CENTER);
JScrollPane sp = new JScrollPane(jt);
sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
			
add(sp);
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(this,ex.getMessage());
		}
}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == refresh)
		{
			new List(passer);
			dispose();
		}
		
		if(ae.getSource() == print) 
		{
			 PrinterJob pjob = PrinterJob.getPrinterJob();
PageFormat preformat = pjob.defaultPage();
preformat.setOrientation(PageFormat.LANDSCAPE);
PageFormat postformat = pjob.pageDialog(preformat);
//If user does not hit cancel then print.
if (preformat != postformat) {
    //Set print component
    pjob.setPrintable(new Printer(jt), postformat);
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

