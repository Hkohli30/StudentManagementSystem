import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class SignupPage extends JFrame implements ActionListener
{
	public static void main(String args[]) 
	{
		new SignupPage();
	}

Connection con;
PreparedStatement pst;

JTextField tname,tusername;
JLabel lname,lusername,lpass,lconfirm_pass,northtext;
JPasswordField tpass,tconfirm_pass;
JButton makeac;
JPanel panel,northpanel,southpanel;
Font font1,font2;
JRadioButton bread,ball;


	public SignupPage()
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


// Provided memory on heap
		tname = new JTextField();
		tusername = new JTextField();
		tpass = new JPasswordField();
		tconfirm_pass  = new JPasswordField();
		
		
		lname = new JLabel("NAME");
		lusername = new JLabel("USERNAME");
		lpass = new JLabel("PASSWORD");
		lconfirm_pass  = new JLabel("CONFIRM PASSWORD");
		northtext = new JLabel("NEW USER");	
		JLabel per = new JLabel("PERMISSIONS : ");	

		bread = new JRadioButton("READ ONLY");
		ball = new JRadioButton("READ AND WRITE");
		ButtonGroup gp = new ButtonGroup();
		gp.add(bread);
		gp.add(ball);

		makeac = new JButton("CREATE ACCOUNT");

		panel = new JPanel(new GridLayout(4,1,0,10));
		northpanel = new JPanel(new FlowLayout());
		southpanel = new JPanel(new FlowLayout());


// SeT FONTS
		font1 = new Font("Forte",Font.BOLD,35);
		font2 = new Font("Harlow Solid",Font.BOLD,20);
		
		lname.setFont(font2);
		lusername.setFont(font2);
		lpass.setFont(font2);
		lconfirm_pass.setFont(font2);

		tname.setFont(font2);
		tusername.setFont(font2);
		tpass.setFont(font2);
		tconfirm_pass.setFont(font2);

// north panel
		northtext.setFont(font1);
		northpanel.add(northtext);
	
// southpanel
		makeac.setFont(font1);
		southpanel.add(per).setFont(font2);
		southpanel.add(bread).setFont(font2);
		southpanel.add(ball).setFont(font2);
		southpanel.add(new JLabel("  			                                 "));
		southpanel.add(makeac);		

// panel

		panel.add(lname);
		panel.add(tname);
		panel.add(lusername);
		panel.add(tusername);
		panel.add(lpass);
		panel.add(tpass);
		panel.add(lconfirm_pass);
		panel.add(tconfirm_pass);

// add on Frame
		add(panel,BorderLayout.CENTER);
		add(northpanel,BorderLayout.NORTH);
		add(southpanel,BorderLayout.SOUTH);
// SETTING COLOURS
		northpanel.setBackground(new Color(0,0,0));
		panel.setBackground(new Color(0,0,0));
		southpanel.setBackground(new Color(0,0,0));
		
		northtext.setForeground(new Color(0,255,0));
		lname.setForeground(new Color(0,255,0));
		lusername.setForeground(new Color(0,255,0));
		lpass.setForeground(new Color(0,255,0));
		lconfirm_pass.setForeground(new Color(0,255,0));

		tname.setBackground(new Color(0,0,0));
		tusername.setBackground(new Color(0,0,0));
		tpass.setBackground(new Color(0,0,0));
		tconfirm_pass.setBackground(new Color(0,0,0));

		tname.setForeground(new Color(0,255,0));
		tusername.setForeground(new Color(0,255,0));
		tpass.setForeground(new Color(0,255,0));
		tconfirm_pass.setForeground(new Color(0,255,0));
		
		makeac.setBackground(new Color(0,255,0));
		makeac.setForeground(new Color(0,0,0));

		per.setForeground(new Color(0,255,0));
		bread.setForeground(new Color(0,255,0));
		ball.setForeground(new Color(0,255,0));
		
		bread.setBackground(new Color(0,0,0));
		ball.setBackground(new Color(0,0,0));
//	Listener
		makeac.addActionListener(this);
		bread.addActionListener(this);
		ball.addActionListener(this);
// PASSCODE
final String passcode = "cse";
String code;
		JOptionPane ps = new JOptionPane();
		code = ps.showInputDialog(this,"PLEASE ENTER ADMINISTRATOR PASSCODE");
Boolean bb = false;
		while(!passcode.equals(code))
		{
			if(code == null)
			{
				new JOptionPane().showMessageDialog(null,"CANCEL");
				bb = true;	break;
			}
			new JOptionPane().showMessageDialog(this,"WRONG PASSCODE");
			code = ps.showInputDialog(this,"PLEASE ENTER ADMINISTRATOR PASSCODE");
			dispose();
		}
		
// EXTRAS
		if(bb == true)
		{
			dispose();
		}
		else
		{
		setTitle("SIGNUP PAGE");
		setSize(1200,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
	}
private String pms;

	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource() == makeac)
	{
if(pms != null)
{
	
		try
		{

			pst = con.prepareStatement("insert into login values(?,?,?,?)");

			
			if(tpass.getText().equals(tconfirm_pass.getText()))
			{
				pst.setString(1,tname.getText());
				pst.setString(2,tusername.getText());
				pst.setString(3,tpass.getText());
				pst.setString(4,pms);
				
				int a = pst.executeUpdate();
				
				if(a>0)
				{
					new JOptionPane().showMessageDialog(this,"USER ADDED TO SYSTEM");
					dispose();
				}
			}	
			else
			{
				new JOptionPane().showMessageDialog(this,"PASSWORDS DO NOT MATCH");
			}
		}
		catch(Exception ex)
		{
			new  JOptionPane().showMessageDialog(null,ex.getMessage());
		}
}
else
{
	new JOptionPane().showMessageDialog(null,"PLEASE SELECT PERMISSIONS ");
}
	}
		
		if(ae.getSource() == bread)
		{
			pms ="READ";
		}
	
		if(ae.getSource() == ball)
		{
			pms = "ALL";
		}
	}
}