import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Reappear extends JFrame implements ActionListener
{
	public static void main(String args[])
	{
		JOptionPane jp = new JOptionPane();
		String pass = jp.showInputDialog(null,"ENTER ROLL NO");
		Long lg = Long.parseLong(pass);
		new Reappear(new Long(lg));
	}

Connection con;
PreparedStatement pst;
String a;
Long rl;

JComboBox cb12,cb22,cb32,cb42,cb52,cb62,cb72;
JComboBox cb82;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;
JPanel north,center,south;
JLabel data;
JButton bmake,bsubmit;

String codesem[] ={"","BTPH-101 (PHYSICS)","BTAM-102(M2)","BTHU-101(COMM. ENGLISH)","BTEE-101(BEEE)","HVPE-101(HUMAN VALUES)","BTPH-102(PHYSICS LAB)","BTHU-102 (COMMUNICATION SKILLS LAB)","BTEE-102 (BEEE LAB)","BTMP-101 (MANUFACTURING PRACTICE)1",
"BTCH-101 (CHEMISTRY)","BTAM-101 (M1)","BTME-101 (EME)","BTCS-101 (FCPIT)","EVSC-101 (EVS)","BTCH-102 (CHEMISTRY LAB)","BTME-102 (ED)","BTCS-102 (FCPIT LAB)","BTME-103 (ED / CG LAB)",
"BTCS-301(CA)","BTCS-302(M3)","BTCS-303(DCLD)","BTCS-304(DATA STRUCTURE)","BTCS-305(OOP)","BTCS-306(DS LAB)","BTCS-307(INSTITUTIONAL TRANING)","BTCS-308(DCLD LAB)","BTCS-309(OOP LAB)",
"BTCS-401(OS)","BTCS-402(DISCRETE STRUCTURE)","BTCS-403(CN-1)","BTCS-404(MALP)","BTCS-405(SP)","BTCS-406(OS LAB)","BTCS-407(CN-1 LAB)","BTCS-408(MALP LAB)","BTCS-409(SP LAB)","GENERAL FITNESS (4TH SEM)",
"BTCS-501(CN-2)","BTCS-502(RDBMS-1)","BTCS-503(DAA)","BTCS-504(CG)","BTCS-505(CPI)","BTCS-506(RDBMS LAB)","BTCS-507(CN-2 LAB)","BTCS-508(DAA LAB)","BTCS-509(CG LAB)","BTCS-510(INDUSTRIAL TRANING{4TH SEM)",
"BS-601(SM)","BTCS-602(RDBMS-2)","BTCS-603(SE)","BTCS-604(RDBMS-LAB)","BTCS-605(Elective Lab(Open source s/w))","BTCS-606(SE LAB)","BTCS-607(SM LAB)","BTCS-901 (WT)","BTCS-902 (MOBILE APP DEVELOPMENT)","BTCS-903 (ETHICAL HACKING)","BTCS-904 (INFORMATION SECURITY)","BT***(HRM)",
"BTCS-701(AI)","BTCS-702(TOC)","BTCS-703(PROJECT)","BTCS-704(AI LAB)","BTCS 905 (Software Testing and Quality Assurance)","BTCS-906 (Object Oriented Analysis and Design)","BTCS-907 (Software Project Management)","BTCS-908(Business Intelligence)","BTCS-909 (Agile Software Development)","BTCS 910 Multimedia and Application","BTCS-911 (Soft Computing)","BTCS-912 (Cloud Computing)","BTCS-913 (Compiler Design)","BTCS-914 (Big Data)","BTCS-915 (Digital Image Processing)","BTCS-916 (Enterprise Resource Planning)","General Fitness",
"BTCS-801(SOFTWARE TESTING)","BTCS-802(PROJECT TRANING)"}; 


	public Reappear(Long x)
	{
		setLayout(new BorderLayout());
rl=x;
		
		north = new JPanel(new FlowLayout());
		center = new JPanel(new GridLayout(9,2,20,10));
		south = new JPanel(new FlowLayout());
		//String sems[] = {"sem1","sem2","sem3","sem4","sem5","sem6","sem7","sem8"};


JLabel l = new JLabel("PLEASE FILL THE DATA FOR REAPPEARS AND DETAINED STUDENTS");
Font f = new Font("Segoe Print",Font.BOLD,20);
l.setFont(f);


		cb12= new JComboBox(codesem);
		cb22 = new JComboBox(codesem);

		cb32 = new JComboBox(codesem);

		cb42 = new JComboBox(codesem);

		cb52 = new JComboBox(codesem);

		cb62 = new JComboBox(codesem);

		cb72 = new JComboBox(codesem);

		cb82 = new JComboBox(codesem);

bmake = new JButton(" GET REAPPEARS ");
bsubmit = new JButton(" SUBMIT ");

bmake.setFont(f);
bsubmit.setFont(f);

t1 = new JTextField(50);
t2 = new JTextField(50);
t3 = new JTextField(50);
t4 = new JTextField(50);
t5 = new JTextField(50);
t6 = new JTextField(50);
t7 = new JTextField(50);
t8 = new JTextField(50);
		
		center.add(cb12);	center.add(t1);
		center.add(cb22);	center.add(t2);
		center.add(cb32);	center.add(t3);
		center.add(cb42);	center.add(t4);
		center.add(cb52);	center.add(t5);
		center.add(cb62);	center.add(t6);
		center.add(cb72);	center.add(t7);
		center.add(cb82);	center.add(t8);
		center.add(bmake);	center.add(bsubmit);
// ADD ITEM LISTENERS
		
		cb12.addActionListener(this);
		cb22.addActionListener(this);

		cb32.addActionListener(this);

		cb42.addActionListener(this);

		cb52.addActionListener(this);

		cb62.addActionListener(this);

		cb72.addActionListener(this);

		cb82.addActionListener(this);

		bmake.addActionListener(this);
		bsubmit.addActionListener(this);

	data = new JLabel(Long.toString(rl));
	data.setFont(f);
		north.add(l);
		south.add(data);
		add(north,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);
		
		setTitle("REAPPEARS AND DETAINED RECORD");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
{

	if(ae.getSource() == cb12)
	{
		t1.setText((String)cb12.getSelectedItem());
		
	}
	
	if(ae.getSource() == cb22)
	{
		t2.setText((String)cb22.getSelectedItem());
	}
	
	if(ae.getSource() == cb32)
	{
		t3.setText((String)cb32.getSelectedItem());
	}
	
	if(ae.getSource() == cb42)
	{
		t4.setText((String)cb42.getSelectedItem());
	}
	
	if(ae.getSource() == cb52)
	{
		t5.setText((String)cb52.getSelectedItem());
	}
	
	if(ae.getSource() == cb62)
	{
		t6.setText((String)cb62.getSelectedItem());
	}
	
	if(ae.getSource() == cb72)
	{
		t7.setText((String)cb72.getSelectedItem());
	}
	
	if(ae.getSource() == cb82)
	{
		t8.setText((String)cb82.getSelectedItem());
	}	

if(ae.getSource() == bmake)
{
	a ="";
	if(!t1.getText().equals(""))
	{
		a = a+t1.getText()+" ";
	}
	if(!t2.getText().equals(""))
	{
		a = a+t2.getText()+" ";
	}
	if(!t3.getText().equals(""))
	{
		a = a+t3.getText()+" ";
	}
	if(!t4.getText().equals(""))
	{
		a = a+t4.getText()+" ";
	}
	if(!t5.getText().equals(""))
	{
		a = a+ t5.getText()+" ";
	}
	if(!t6.getText().equals(""))
	{
		a =a+ t6.getText()+" ";
	}
	if(!t7.getText().equals(""))
	{
		a =a+ t7.getText()+" ";
	}
	if(!t8.getText().equals(""))
	{
		a = a+t8.getText()+" ";
	}
	new JOptionPane().showMessageDialog(this,a);
}	

	if(ae.getSource() == bsubmit)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");

			pst = con.prepareStatement("insert into REAPPEARS values(?,?)");
					
			pst.setLong(1,rl);
			pst.setString(2,a);
			
			int x = pst.executeUpdate();
			if(x>0)
			{
				new JOptionPane().showMessageDialog(this,"SUCESSFUL");
				dispose();
			}
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(this,ex.getMessage());
		}
	}
}	// end actionPerformed

}

