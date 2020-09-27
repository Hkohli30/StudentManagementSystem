import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Permissions extends JFrame implements ActionListener
{
	public static void main(String args[])
	{
		new Permissions();
	}	
Connection con;
PreparedStatement pst_get;
ResultSet rst;
JComboBox jcomb;
JRadioButton read,write;
JButton update;
	public Permissions()
	{
		setLayout(new GridLayout(4,1));

		update = new JButton("** UPDATE **");
		
		jcomb = new JComboBox();
		read = new JRadioButton("READ ONLY");
		write = new JRadioButton("READ & WRITE");		

		ButtonGroup gp = new ButtonGroup();
		gp.add(read);
		gp.add(write);	

		jcomb.addItem("");
		get();

JPanel north = new JPanel(new FlowLayout());
JPanel p1 = new JPanel(new GridLayout(1,2));
JPanel p2 = new JPanel(new FlowLayout());
JPanel p3 = new JPanel(new FlowLayout());

JLabel northtext = new JLabel("Change Permissions ");
JLabel user = new JLabel("Select User : ");
JLabel per = new JLabel("SELECT PERMISSIONS :");

	
	north.add(northtext);	

	p1.add(user);
	p1.add(jcomb);

	p2.add(per);
	p2.add(read);
	p2.add(write);
		
	p3.add(update);

add(north);
add(p1);
add(p2);
add(p3);

Font f = new Font("Segoe Print",Font.BOLD,20);
northtext.setFont(new Font("Segoe Print",Font.BOLD,26));
per.setFont(f);
user.setFont(f);
read.setFont(f);
write.setFont(f);
update.setFont(f);
jcomb.setFont(f);

	jcomb.addActionListener(this);
	update.addActionListener(this);
	read.addActionListener(this);
	write.addActionListener(this);

	setTitle("Change Permissions");
	setVisible(true);	
	setSize(920,270);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void get()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");

			pst_get = con.prepareStatement("select * from LOGIN");
			rst = pst_get.executeQuery();
			
			
			while(rst.next())
			{
				jcomb.addItem(rst.getString(2));
			}			
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(this,ex.getMessage());
		}
	}
private String pms="";
String suser="";
public void actionPerformed(ActionEvent ae)
{
		if(ae.getSource() == read)
		{
			pms ="READ";
		}
	
		if(ae.getSource() == write)
		{
			pms = "ALL";
		}
		
		if(ae.getSource() == update)
		{
			if(suser.equals(""))
			{
				new JOptionPane().showMessageDialog(this,"Select USER");
			}
			else if(pms.equals(""))
			{
				new JOptionPane().showMessageDialog(this,"Select Permissions");
			}
			else
			{
				upy();
			}
			
		}
		
		if(ae.getSource() == jcomb)
		{
			suser = (String)jcomb.getSelectedItem();
			if(suser.equals(""))
			{
				new JOptionPane().showMessageDialog(this,"Select Valid User");
			}
		}
}
PreparedStatement pst_upy;
	public void upy()
	{
		try
		{
			pst_upy = con.prepareStatement("update LOGIN set permissions = ? where username = ?");
			pst_upy.setString(1,pms);
			pst_upy.setString(2,suser);
			
			int a = pst_upy.executeUpdate();
			
			if(a>0)
			{
				new JOptionPane().showMessageDialog(this,"Successful Update");
				dispose();
			}	
			else
			{
				new JOptionPane().showMessageDialog(this,"FAILED");
			}
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(this,ex.getMessage());
		}
	}
	
}