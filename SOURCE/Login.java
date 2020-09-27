import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
	{
	public static void main(String ar[]) throws ClassNotFoundException,SQLException
		{
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Login ob = new Login();
			ob.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");	
		}
Connection con;
PreparedStatement pst,pst2;
ResultSet rst,rst2;
JButton b1,b2,b3,b4;

	JTextField t1;
	JPasswordField t2;
	JMenu h,e;
	JMenuItem u,a,c;
	public Login()	
	{

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");
		}
		catch(Exception ex)
		{
				new JOptionPane().showMessageDialog(null,ex.toString());
		}
			Font f1=new Font("Comic Sans MS",Font.BOLD,25);				
			Font f2=new Font("Comic Sans MS",Font.BOLD,20);			

			u=new JMenuItem("How To use ?");
			a=new JMenuItem("About...");
			c=new JMenuItem("Exit");
			h=new JMenu("Help");
			e=new JMenu("File");
			b1 = new JButton("Login");
			b2=new JButton("New User");
			b3=new JButton("Admin Login");
			b4 = new JButton("Delete User");
			JLabel l1= new JLabel(" Username :");
			JLabel l2= new JLabel(" Password :");
			t1=new JTextField(15);
			t2=new JPasswordField(15);		
			
			h.add(u);
			h.add(a);			
			e.add(c);
			
			JMenuBar jmbar=new JMenuBar();
			jmbar.add(e);
			jmbar.add(h);
			setJMenuBar(jmbar);
		
			
			JPanel p1=new JPanel(new FlowLayout());
JLabel label = new JLabel("	   ");
			p1.add(l1);	p1.add(label);
			p1.add(t1);	p1.add(label);
			p1.add(l2);	p1.add(label);
			p1.add(t2);	p1.add(label);	p1.add(label);
			p1.add(b1);	
			
			JPanel p2=new JPanel(new FlowLayout());
			p2.add(b2);	
			p2.add(b3);	
			p2.add(b4);	
				
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			u.addActionListener(this);
			a.addActionListener(this);
			c.addActionListener(this);	
			add(p1, BorderLayout.NORTH);
			add(p2, BorderLayout.SOUTH);	
ImageIcon img1 = new ImageIcon("engineering college.JPG");
Image img = img1.getImage();
Image imgg = img.getScaledInstance(1350,1000,java.awt.Image.SCALE_SMOOTH);
ImageIcon ficon = new ImageIcon(imgg);
		
			JLabel l3 =new JLabel(ficon);
			add(l3);
			
// adding fonts 
Font ff = new Font("Comic Sans MS",Font.BOLD,35);
			l1.setFont(f1);
			l2.setFont(f1);
			b1.setFont(f2);
			b2.setFont(ff);
			b3.setFont(ff);
			t1.setFont(f2);
			t2.setFont(f2);
			b4.setFont(ff);
// adding colours
			p1.setBackground(new Color(106,90,205));
			p2.setBackground(new Color(106,90,205));
			getContentPane().setBackground(new Color(106,90,205));
			jmbar.setBackground(new Color(123,104,238));
			l1.setForeground(Color.WHITE);
			l2.setForeground(Color.WHITE);
			b1.setForeground(new Color(106,90,205));
			b2.setForeground(new Color(106,90,205));			
			b3.setForeground(new Color(106,90,205));
			b4.setForeground(new Color(106,90,205));			
			
// extras
			setSize(900,380);
			setVisible(true);
			setTitle("Login!");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);		

			}
	
JOptionPane jop = new JOptionPane();
JOptionPane jop2 = new JOptionPane();
JOptionPane jop3 = new JOptionPane();
JOptionPane jop4 = new JOptionPane();
String suser,spass;		
	public void actionPerformed(ActionEvent ae) 
		{
		if(ae.getSource() == b1)
			{
				try
				{
					suser = t1.getText();
					spass = t2.getText();
					pst = con.prepareStatement("select * from login where username =? and password=?");
					pst.setString(1,suser);
					pst.setString(2,spass);
					rst = pst.executeQuery();
		
						if(rst.next())
						{
						String namepass = rst.getString(2);
							jop.showMessageDialog(this,"Login Successful!");	
							new Action(namepass);
							t1.setText("");	t2.setText("");
							
						}
						else
						{
							jop2.showMessageDialog(this,"Username or password is invalid!");
						}
				}
				catch(Exception ex)
				{
				
					System.out.println(ex);
				}
			}
		if(ae.getSource() == b2)
			{
			new SignupPage();
			}
if(ae.getSource() == b3)	// ADMIN LOGIN
{
String passcode ="cse";
		String code;
		JOptionPane ps = new JOptionPane();
		code = ps.showInputDialog(this,"PLEASE ENTER ADMINISTRATOR PASSCODE");
Boolean ab = true;
		while(!passcode.equals(code))
		{
			if(code == null)
			{
				new JOptionPane().showMessageDialog(null,"CANCEL");
				ab=false;
				break;
			}
			new JOptionPane().showMessageDialog(this,"WRONG PASSCODE");
			code = ps.showInputDialog(this,"PLEASE ENTER ADMINISTRATOR PASSCODE");
			dispose();
		}
		if(ab == false)
		{
			//dispose();	
		}
		else
		{
			new Gamer();
		}

}
				if(ae.getSource() == b4)
				{
				try
				{
					suser = t1.getText();
					spass = t2.getText();
	if(suser.equals("") || spass.equals(""))
	{
		throw new SQLException();
	}
else
{
					pst2 = con.prepareStatement("delete from Login where username =? and password=?");
					pst2.setString(1,suser);
					pst2.setString(2,spass);
					int val = 1,val2 = 2;
					val = jop.showConfirmDialog(this,"ARE U SURE U WANT TO DELETE USER ?");
				if(val == JOptionPane.YES_OPTION)
				{
					rst2 = pst2.executeQuery();
					t1.setText("");
					t2.setText("");		
				}
				
						if(rst2.next())
						{
							jop.showMessageDialog(this,"USER DELETED!");	
						}
}		
				}
				catch(Exception ex)
				{
					jop4.showMessageDialog(this,"INVALID USER");
				}
				}
		if(ae.getSource()==u)
			{
			new ViewHelp();
			}	
		if(ae.getSource()==a)
			{
			new AboutDialog();
			}
		if(ae.getSource()==c)
			{
			System.exit(1);
			}		
		}

}