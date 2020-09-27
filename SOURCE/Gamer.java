import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.*;

class Gamer extends JFrame implements ActionListener
{
JLabel welcome;
JTable table;
JButton delete,add,pers,refresh,New;
JButton info1,info2,list,rlist,reap;
	public static void main(String args[])
	{
		new Gamer();
	}

	public Gamer()
	{
		setLayout(new BorderLayout());
		Westdata();
		JPanel north = new JPanel( new FlowLayout());
		welcome = new JLabel("Welcome Administrator..... ");
		welcome.setFont(new Font("Segoe Print",Font.BOLD,25));
		north.add(welcome);
		add(north,BorderLayout.NORTH);
		welcome.setForeground(new Color(255,255,255));
		setSize(1200,700);
		setTitle("ADMINISTRATOR PAGE ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

delete = new JButton("DELETE USER");
add = new JButton("ADD BATCHES");
pers = new JButton("CHANGER PERMISSIONS");
refresh = new JButton("REFRESH");
New = new JButton("NEW USER");		

refresh.setFont(new Font("Segoe Print",Font.BOLD,17));

JPanel p = new JPanel(new GridLayout(8,1,10,10));
	p.add(refresh);
	p.add(delete);	p.add(add);	p.add(pers);
	p.add(New);

add(p,BorderLayout.EAST);
		north.setBackground(new Color(10,30,40));

JPanel south = new JPanel(new FlowLayout());
info1 = new  JButton("New Record");
info2 = new JButton("Update Record");
list = new JButton("Student List");
rlist = new JButton("Reappear Student List");
reap = new JButton("Manage Reappear");

	south.add(info1);	south.add(new JLabel("     "));	south.add(info2);	south.add(new JLabel("     "));
	south.add(reap);	south.add(new JLabel("     "));
	south.add(list);	south.add(new JLabel("     "));	south.add(rlist);
Font f1 = new Font("Segoe Print",Font.BOLD,20);
	info1.setFont(f1);	info2.setFont(f1);
	reap.setFont(f1);	list.setFont(f1);	rlist.setFont(f1);

add(south,BorderLayout.SOUTH);

// LISTENER
	delete.addActionListener(this);
	add.addActionListener(this);
	pers.addActionListener(this);
	refresh.addActionListener(this);
	New.addActionListener(this);
	info1.addActionListener(this);
	info2.addActionListener(this);
	list.addActionListener(this);
	rlist.addActionListener(this);
	reap.addActionListener(this);

		setVisible(true);
		
	}
PreparedStatement pst2,pst_add;
ResultSet rst2;
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == delete)
		{
			JOptionPane jop = new JOptionPane();
			String suser = jop.showInputDialog(this,"ENTER USERNAME ");
			try
			{
			if(suser != null)
			{
				pst2 = con.prepareStatement("delete from LOGIN where username =?");
				pst2.setString(1,suser);
				int val = 1,val2 = 2;
				val = jop.showConfirmDialog(this,"ARE U SURE U WANT TO DELETE USER ?");
				if(val == JOptionPane.YES_OPTION)
				{
					rst2 = pst2.executeQuery();		
				}
					if(rst2.next())
					{
						new JOptionPane().showMessageDialog(this,"USER DELETED!");
						new Gamer();
						dispose();
					}
			} // end if cond
			}
			catch(Exception ex)
			{
					new JOptionPane().showMessageDialog(this,"INVALID USER");
			}

		}

		if(ae.getSource() == add)
		{
			try
			{
				JOptionPane op = new JOptionPane();
				String b = op.showInputDialog(this,"ENTER THE BATCH ");
			if(b != null)
			{
				pst_add = con.prepareStatement("insert into BATCHES values(?)");
				pst_add.setString(1,b);
				int a; 
				a = pst_add.executeUpdate();
				if(a>0)
				{
					new JOptionPane().showMessageDialog(this,"Batch Added");
				}
				else
				{
					new JOptionPane().showMessageDialog(this,"FAILED");
				}
			}	//end b	
			}
			catch(Exception ex)
			{
				new JOptionPane().showMessageDialog(null,ex.getMessage());
			}
		}

		if(ae.getSource() == pers)
		{
			new Permissions();
		}
		
		if(ae.getSource() == refresh)
		{
			new Gamer();
			dispose();
		}

		if(ae.getSource() == New)
		{
			new SignupPage();
		}

			if(ae.getSource() == info1)
			{
				new Info();	
			}
			if(ae.getSource() == info2)
			{
				new Selector();
			}
			if(ae.getSource() == list)
			{
				new Selector_List();
			}
			if(ae.getSource() == rlist)
			{
				new Selector_List();
			}
			if(ae.getSource() == reap)
			{
				JOptionPane jp = new JOptionPane();
				String pass = jp.showInputDialog(null,"ENTER ROLL NO");
				Long lg = Long.parseLong(pass);
				new Reappear2(new Long(lg));
			}

	}



Connection con;
PreparedStatement pst;
ResultSet rst;
DefaultTableModel dtm;
public void Westdata()
{
	table = new JTable();
	try
	{
	 	Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");

		pst = con.prepareStatement("select * from LOGIN");
		
		rst = pst.executeQuery();

		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		ResultSetMetaData rstm = rst.getMetaData();
		int column = rstm.getColumnCount();
		dtm = new DefaultTableModel();
		
		Vector col = new Vector();
		Vector data = new Vector();		

		col.addElement("NAME");
		col.addElement("USERNAME");
		col.addElement("PASSWORD");
		col.addElement("PERMISSIONS");


	dtm.setColumnIdentifiers(col);
		dtm.addRow(col);

		while(rst.next())
		{
			data = new Vector();
			data.addElement(rst.getString(1));
			data.addElement(rst.getString(2));
			data.addElement(rst.getString(3));
			data.addElement(rst.getString(4));
			
			dtm.addRow(data);
		}
table.setModel(dtm);
table.setRowHeight(30);
TableColumnModel columnModel = table.getColumnModel();
columnModel.getColumn(0).setPreferredWidth(200);
columnModel.getColumn(1).setPreferredWidth(200);
columnModel.getColumn(2).setPreferredWidth(200);
columnModel.getColumn(3).setPreferredWidth(100);


		
JScrollPane sp = new JScrollPane(table);
sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
JPanel center = new JPanel(new FlowLayout());

center.add(table);
center.add(sp);
add(center,BorderLayout.CENTER);
	}
	catch(Exception ex)
	{
		new JOptionPane().showMessageDialog(this,ex.getMessage());
	}
}
} 