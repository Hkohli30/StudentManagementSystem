import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Action extends JFrame implements ActionListener
{
	public static void main(String args[])
	{
		JOptionPane h = new JOptionPane();
		String s ;
		s = h.showInputDialog(null,"ENTER USER");
		new Action(s);
	}
Boolean fread,fwrite,fupdate;
String pers,user;
JButton bview,bnew,bupdate,breap,blist,blist2;
PreparedStatement pst;
ResultSet rst;
Connection con;

	public Action(String s)
	{
	user =s;
		setLayout(new BorderLayout());
		JPanel north = new JPanel(new FlowLayout());
		JPanel center = new JPanel(new GridLayout(6,1,20,30));
		bview = new JButton("View A Record");
		bnew = new JButton("Enter A New Record");
		bupdate = new JButton("Update A Record");
		breap = new JButton("Enter A New Reappear");
		blist = new JButton("List Of Student Records");
		blist2 = new JButton("List Of Reappear Records");

		JLabel northtext = new JLabel("SELECT THE ACTION............");
		northtext.setFont(new Font("Seoge Print",Font.BOLD,20));

		format(bview);	format(bnew);
		format(bupdate);	format(breap);
		format(blist);	format(blist2);
		
		center.add(bview);	center.add(bnew);
		center.add(bupdate);	center.add(breap);
		center.add(blist);		center.add(blist2);

		center.setBackground(new Color(0,20,63));
		north.setBackground(new Color(254,155,28));
// NORTH
		north.add(northtext);
		add(center,BorderLayout.CENTER);
		add(north,BorderLayout.NORTH);

//CHECK
		check();


		setSize(600,500);
		setTitle("ACCESS PAGE");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}

	public void check()
	{
	
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");

			pst = con.prepareStatement("select * from LOGIN where username = ?");
			pst.setString(1,user);

			rst = pst.executeQuery();
			if(rst.next())
			{
				pers = rst.getString(4);
			}	

		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(null,ex.getMessage());
		}
		fwrite = false;	fread=false;	fupdate=false;
		if(pers.equals("ALL"))
		{
			fwrite=true;
			fupdate=true;
			fread = true;
		}
			
		else if(pers.equals("READ"))
		{
			fread =true;
		}

	}

	public void format(JButton b)
	{
		b.setBackground(new Color(0,0,0));
		b.setFont(new Font("Segoe Print",Font.BOLD,20));
		b.setForeground(new Color(0,255,0));
		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == bnew)
		{
			if(fwrite == true)
			{
				new Info();
			}
			else
			{
				non();
			}
		}
		
		if(ae.getSource() == bview)
		{
			if(fread == true)
			{
				new Selector_user();
			}
			else
			{	non(); }
		}
		
		if(ae.getSource() == bupdate)
		{
			if(fupdate == true)
			{
				new Selector();
			}
			else
			{	non();	}
		}

		if(ae.getSource() == breap)
		{
			if(fwrite == true)
			{
				JOptionPane jp = new JOptionPane();
				String pass = jp.showInputDialog(null,"ENTER ROLL NO");
				Long lg = Long.parseLong(pass);
				new Reappear2(lg);
			}
			else
			{	non();	}
		}

		if(ae.getSource() == blist)
		{
			new Selector_List();
		}

		if(ae.getSource() == blist2)
		{
			new Selector_Reap();
		}
	}

public void non()
{
	JOptionPane jop = new JOptionPane();
	jop.showMessageDialog(this,"You Don't have Permissions to access this Page \n PLEASE CONTACT ADMINISTRATOR");
}

}