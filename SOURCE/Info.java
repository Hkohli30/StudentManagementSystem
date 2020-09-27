import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

	class Info extends JFrame implements ActionListener,ItemListener
	{
		public static void main(String args[]) 
    		{
			new Info();
		} 
Connection con;
JTextField tname,tfather,tachive,tskill,taddress,troll,tsem1,tsem2,tsem3,tsem4,tsem5,tsem6,tsem7,tsem8,tnumber;
JButton bsubmit;
JComboBox cbatch;
JRadioButton byes,bno;
ButtonGroup gp;
	public Info()
	{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");
	}
	catch(Exception ex)
	{
		new JOptionPane().showMessageDialog(this,ex.getMessage());
	}
	// LABAES
	JLabel text1 = new JLabel("FILL THE FOLLOWING TO ENTER A RECORD ");
             JLabel lbatch = new JLabel("Select Batch");
	JLabel lsem = new JLabel("Select Semester");
             JLabel lroll = new JLabel("Enter Roll No.");
             JLabel lsem1 = new JLabel("Semester 1 :");
             JLabel lsem2 = new JLabel("Semester 2 :");
	JLabel lsem3 = new JLabel("Semester 3 :");
	JLabel lsem4 = new JLabel("Semester 4 :");
            JLabel lsem5 = new JLabel("Semester 5 :");
            JLabel lsem6 = new JLabel("Semester 6 :");
           JLabel lsem7 = new JLabel("Semester 7 :");
        JLabel lsem8 = new JLabel("Semester 8 :");
        JLabel lreappear = new JLabel("DOES STUDENT HAS REAPPEAR :");
        JLabel lname = new JLabel("Student's Name : ");
        JLabel lfather = new JLabel("FATHER'S Name : ");
        JLabel lachive = new JLabel("E-MAIL : ");
        JLabel lskill = new JLabel("SKILLS : ");
        JLabel laddress = new JLabel("ADDRESS : ");
	JLabel lnumber = new JLabel("PHONE NO.");
        
        
        //BUTTONS
        bsubmit = new JButton("SUBMIT");
        byes = new JRadioButton("YES");
        bno = new JRadioButton("NO");
         gp = new ButtonGroup();
	gp.add(byes);
	gp.add(bno);
        
        //TEXTFIELDS
	tnumber = new JTextField(12);
        tname = new JTextField(200);
        tfather = new JTextField(200);
        troll = new JTextField(10);
        tachive = new JTextField(4000);
        tskill = new JTextField(4000);
        tsem1 = new JTextField(3);
        tsem2 = new JTextField(3);
        tsem3 = new JTextField(3);
        tsem4 = new JTextField(3);
        tsem5 = new JTextField(3);
        tsem6 = new JTextField(3);
        tsem7 = new JTextField(3);
        tsem8 = new JTextField(3);
        taddress = new JTextField(200);

// COMBOBOX

	cbatch = new JComboBox();
	cbatch.addItem("Select Batch");
	get();

// FONTS

	Font f = new Font("Segoe UI",Font.BOLD,20);
	Font f2 = new Font("Segoe UI",Font.BOLD,20);
	Font f3 = new Font("Segoe UI",Font.BOLD,24);
	text1.setFont(f3);
	lbatch.setFont(f);
	cbatch.setFont(f);
	lroll.setFont(f);
	troll.setFont(f);
	lname.setFont(f);
	tname.setFont(f);
	lsem1.setFont(f);
	lsem2.setFont(f);
	lsem3.setFont(f);
	lsem4.setFont(f);
	lsem5.setFont(f);
	lsem6.setFont(f);
	lsem7.setFont(f);
	lsem8.setFont(f);
	lfather.setFont(f);
	lachive.setFont(f);
	lskill.setFont(f);
	laddress.setFont(f);
	lreappear.setFont(f);
	lnumber.setFont(f);
		
	bsubmit.setFont(f);
	byes.setFont(f);
	bno.setFont(f);
	
	tsem1.setFont(f2);
	tsem2.setFont(f2);
	tsem3.setFont(f2);
	tsem4.setFont(f2);
	tsem5.setFont(f2);
	tsem6.setFont(f2);
	tsem7.setFont(f2);
	tsem8.setFont(f2);
	tfather.setFont(f2);
	tachive.setFont(f2);
	tskill.setFont(f2);
	taddress.setFont(f2);		
	tnumber.setFont(f2);
	

        
        // Panels
        JPanel northpanel = new JPanel(new FlowLayout());
	JPanel eastpanel = new JPanel(new GridLayout(9,4,20,10));   // center
	JPanel southpanel = new JPanel(new FlowLayout());
       
// Colors

	northpanel.setBackground(new  Color(255,99,71));
	southpanel.setBackground(new Color(255,99,71));
	eastpanel.setBackground(new Color(238,232,170));
	text1.setForeground(new Color(230,230,230));
	lreappear.setForeground(new Color(230,230,230));
	byes.setBackground(new Color(255,99,71));
	bno.setBackground(new Color(255,99,71));
	byes.setForeground(Color.WHITE);
	bno.setForeground(Color.WHITE);
	lbatch.setForeground(new Color(255,69,0));
	lname.setForeground(new Color(255,69,0));
	lfather.setForeground(new Color(255,69,0));
	laddress.setForeground(new Color(255,69,0));
	lskill.setForeground(new Color(255,69,0));
	laddress.setForeground(new Color(255,69,0));
	lachive.setForeground(new Color(255,69,0));
	lsem1.setForeground(new Color(255,69,0));
	lsem2.setForeground(new Color(255,69,0));
	lsem3.setForeground(new Color(255,69,0));
	lsem4.setForeground(new Color(255,69,0));
	lsem5.setForeground(new Color(255,69,0));
	lsem6.setForeground(new Color(255,69,0));
	lsem7.setForeground(new Color(255,69,0));
	lsem8.setForeground(new Color(255,69,0));
	lroll.setForeground(new Color(255,69,0));
	lnumber.setForeground(new Color(255,69,0));
	
	
// NORTHPANEL
		northpanel.add(text1);


//EASTPANEL
		eastpanel.add(lbatch);	eastpanel.add(cbatch);
		eastpanel.add(lroll);		eastpanel.add(troll);
		eastpanel.add(lsem1);	eastpanel.add(tsem1);
		eastpanel.add(lsem2);	eastpanel.add(tsem2);
		eastpanel.add(lsem3);	eastpanel.add(tsem3);
		eastpanel.add(lsem4);	eastpanel.add(tsem4);
		eastpanel.add(lsem5);	eastpanel.add(tsem5);
		eastpanel.add(lsem6);	eastpanel.add(tsem6);
		eastpanel.add(lsem7);	eastpanel.add(tsem7);
		eastpanel.add(lsem8);	eastpanel.add(tsem8);
		eastpanel.add(lname);	eastpanel.add(tname);
		eastpanel.add(lfather);	eastpanel.add(tfather);
		eastpanel.add(lachive);	eastpanel.add(tachive);
		eastpanel.add(lskill);	eastpanel.add(tskill);	
		eastpanel.add(laddress);	eastpanel.add(taddress);
		eastpanel.add(lnumber);	eastpanel.add(tnumber);
//SOUTHPANEL
JLabel sp = new JLabel("                                   ");
		southpanel.add(lreappear);
		southpanel.add(byes);	southpanel.add(bno);
		southpanel.add(sp);
		southpanel.add(bsubmit);

// ADD LISTENERS

	bsubmit.addActionListener(this);
	cbatch.addItemListener(this);
	byes.addActionListener(this);
	bno.addActionListener(this);
// ADD TO FRAME
		setLayout(new BorderLayout());
		add(northpanel,BorderLayout.NORTH);
		add(eastpanel,BorderLayout.CENTER);
		add(southpanel,BorderLayout.SOUTH);

	setTitle("Information Portal");
	setVisible(true);
	setSize(1200,600);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}  
PreparedStatement pst,pst2;
int sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;

	public void actionPerformed(ActionEvent ae)
	{
    		if(ae.getSource() == bsubmit)
    		{
		try
		{
        		pst = con.prepareStatement(("insert into INFO values(?,?,?,?,?,?,?,?)"));
        		
			long rl = Long.parseLong(troll.getText());
			String name,father,achive,skill,address;
			name = tname.getText();
			father = tfather.getText();
			achive = tachive.getText();
			skill = tskill.getText();
			address = taddress.getText();
			Long ph = Long.parseLong(tnumber.getText());
			

       		 	pst.setLong(1,rl);
       			 pst.setString(2,name);
        			pst.setString(3,father);
       			 pst.setString(4,achive);
      			  pst.setString(5,skill);
       		 	pst.setString(6,item);
        			pst.setString(7,address);
			pst.setLong(8,ph);
int a,b;

			pst2 = con.prepareStatement(("insert into RECORDS values(?,?,?,?,?,?,?,?,?)"));

			checkmks();

			pst2.setLong(1,rl);
			pst2.setInt(2,sem1);
			pst2.setInt(3,sem2);
			pst2.setInt(4,sem3);
			pst2.setInt(5,sem4);
			pst2.setInt(6,sem5);
			pst2.setInt(7,sem6);
			pst2.setInt(8,sem7);
			pst2.setInt(9,sem8);

			a = pst.executeUpdate();
			b = pst2.executeUpdate();
			if(a>0 && b>0)
			{
				new JOptionPane().showMessageDialog(null,"SUCCESSFUL");
				
			troll.setText("");
			tname.setText("");
			tfather.setText("");
			tachive.setText("");
			tskill.setText("");
			taddress.setText("");
			tsem1.setText("");
			tsem2.setText("");
			tsem3.setText("");
			tsem4.setText("");
			tsem5.setText("");
			tsem6.setText("");
			tsem7.setText("");
			tsem8.setText("");
			tnumber.setText("");
			cbatch.setSelectedIndex(0);
			byes.setSelected(false);
			bno.setSelected(false);
			gp.clearSelection();
				if(flag == true)
				{
					new Reappear(rl);	
					flag = null;
				}
			
			}
			else
			{
				new JOptionPane().showMessageDialog(null,"Failed");
			}
        		}
		catch(SQLException ex)
		{
			new JOptionPane().showMessageDialog(null,"Error"+ex.getMessage());
		}
		    }

		if(ae.getSource() == byes)
		{
			flag = true;	
		}
		if(ae.getSource() == bno)
		{
			flag = false;		
		}
	}
Boolean flag= false;
String item;
	public void itemStateChanged(ItemEvent ie)
	{
    		String item2 = (String)ie.getItem();
			if(item2.equals(""))
			{
				new JOptionPane().showMessageDialog(null,"Please Select Valid Batch");
				item = "";
			}
			else
			{
				item = item2;
			}
	}

public void checkmks()
{
sem1=0;
sem2=0;
sem3=0;
sem4=0;
sem5=0;
sem6=0;
sem7=0;
sem8=0;	
	if(!tsem1.getText().equals(""))
	{	
		sem1 = Integer.parseInt(tsem1.getText());
	}
	if(!tsem2.getText().equals(""))
	{
		sem2 = Integer.parseInt(tsem2.getText());
	}
	if(!tsem3.getText().equals(""))
	{
		sem3 = Integer.parseInt(tsem3.getText());
	}
	if(!tsem4.getText().equals(""))
	{		
		sem4 = Integer.parseInt(tsem4.getText());
	}
	if(!tsem5.getText().equals(""))
	{
		sem5 = Integer.parseInt(tsem5.getText());
	}
	if(!tsem6.getText().equals(""))
	{
		sem6 = Integer.parseInt(tsem6.getText());
	}
	
	if(!tsem7.getText().equals(""))
	{
		sem7 = Integer.parseInt(tsem7.getText());
	}
	if(!tsem8.getText().equals(""))
	{
		sem8 = Integer.parseInt(tsem8.getText());
	}
}
PreparedStatement pre;
ResultSet res;
	public void get()
	{
		try
		{
		pre = con.prepareStatement("select * from BATCHES");

		res = pre.executeQuery();

			while(res.next())
			{
				cbatch.addItem(res.getString(1));
			}
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(null,ex.getMessage());
		}
	}
} 

