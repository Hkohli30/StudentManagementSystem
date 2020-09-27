import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

	class Info2 extends JFrame implements ActionListener
	{
		public static void main(String args[]) 
    		{
			String bogus = "2012-2016";
			new Info2(bogus);
		} 
Connection con;
JTextField tname,tfather,tachive,tskill,taddress,troll,tsem1,tsem2,tsem3,tsem4,tsem5,tsem6,tsem7,tsem8,tnumber;
JButton bsubmit,search,reap,delete,bpercent,blist;
JComboBox cbatch;
ResultSet rst,rst2,rest;
PreparedStatement pst3,pst4,pst5,pst6,ppt;
String batcher;
	public Info2(String bxtr)
	{
			batcher = bxtr;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");
	}
	catch(Exception ex)
	{
		System.out.print(ex.getMessage());
	}
	// LABAES
	JLabel text1 = new JLabel("ADMIN SEARCH AND UPDATE PORTAL                                                         ");
             JLabel lbatch = new JLabel("Batch");
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
        bsubmit = new JButton("UPDATE");
	search = new JButton("SEARCH");
	reap = new JButton("Reappear or Detained Record");
	delete = new JButton("DELETE STUDENT RECORD");
	bpercent = new JButton("PERCENTAGE");
	blist = new JButton("LIST");
        
        //TEXTFIELDS
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
	tnumber = new JTextField(12);

// COMBOBOX

	cbatch = new JComboBox();
	cbatch.addItem("Select Batch");
	get();

// FONTS

	Font f = new Font("Segoe UI",Font.BOLD,20);
	Font f2 = new Font("Segoe UI",Font.BOLD,20);
	text1.setFont(f);
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
	search.setFont(f);
	reap.setFont(f);
	delete.setFont(f);
	bpercent.setFont(f);
	blist.setFont(f);
	
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
	
	JLabel sp = new JLabel("                        ");
        
        // Panels
        JPanel northpanel = new JPanel(new FlowLayout());
	JPanel eastpanel = new JPanel(new GridLayout(9,4,20,10));   // center
	JPanel southpanel = new JPanel(new FlowLayout());
       


// NORTHPANEL
		northpanel.add(text1);
		northpanel.add(sp);
		northpanel.add(new JLabel("       "));
		northpanel.add(search);
		


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
		southpanel.add(blist);
		southpanel.add(bpercent);
		southpanel.add(reap);		
		southpanel.add(bsubmit);		southpanel.add(delete);

// ADD LISTENERS

	bsubmit.addActionListener(this);
	search.addActionListener(this);
	reap.addActionListener(this);
	delete.addActionListener(this);
	cbatch.addActionListener(this);
	bpercent.addActionListener(this);
	blist.addActionListener(this);

// ADD TO FRAME
		setLayout(new BorderLayout());
		add(northpanel,BorderLayout.NORTH);
		add(eastpanel,BorderLayout.CENTER);
		add(southpanel,BorderLayout.SOUTH);

// Colors

	northpanel.setBackground(new  Color(255,99,71));
	southpanel.setBackground(new Color(255,99,71));
	eastpanel.setBackground(new Color(238,232,170));
	text1.setForeground(new Color(230,230,230));
	lreappear.setForeground(new Color(230,230,230));
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


	cbatch.setForeground(new Color(255,69,0));
	tname.setForeground(new Color(255,69,0));
	tfather.setForeground(new Color(255,69,0));
	taddress.setForeground(new Color(255,69,0));
	tskill.setForeground(new Color(255,69,0));
	taddress.setForeground(new Color(255,69,0));
	tachive.setForeground(new Color(255,69,0));
	tsem1.setForeground(new Color(255,69,0));
	tsem2.setForeground(new Color(255,69,0));
	tsem3.setForeground(new Color(255,69,0));
	tsem4.setForeground(new Color(255,69,0));
	tsem5.setForeground(new Color(255,69,0));
	tsem6.setForeground(new Color(255,69,0));
	tsem7.setForeground(new Color(255,69,0));
	tsem8.setForeground(new Color(255,69,0));
	troll.setForeground(new Color(255,69,0));
	bsubmit.setForeground(new Color(255,69,0));
	tnumber.setForeground(new Color(255,69,0));
	reap.setForeground(new Color(255,69,0));
	bpercent.setForeground(new Color(255,69,0));
	search.setForeground(new Color(255,69,0));
	delete.setForeground(new Color(255,69,0));
	blist.setForeground(new Color(255,69,0));	
		
// FUC
		fuc();
northpanel.add(new JLabel("   "));
northpanel.add(jcomb);

setTitle("Admin Search and Update Portal");
	setVisible(true);
	setSize(1200,600);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}  


PreparedStatement pst,pst2;
String sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
float psem1,psem2,psem3,psem4,psem5,psem6,psem7,psem8;
String a;

	public void action(String m)
	{
	
    		try
		{
		String one = "select * from INFO where roll_no_id="+m;
		String two ="select * from RECORDS where roll_no="+m;
		
			pst = con.prepareStatement(one);
			pst2 = con.prepareStatement(two);
			
			rst = pst.executeQuery();
			rst2 = pst2.executeQuery();
if(rst.next())
{
String roll = Long.toString(rst.getLong(1));		
			troll.setText(roll);
			tname.setText(rst.getString(2));
			tfather.setText(rst.getString(3));
			tachive.setText(rst.getString(4));
			tskill.setText(rst.getString(5));

			cbatch.setSelectedItem(rst.getString(6));
			taddress.setText(rst.getString(7));
			tnumber.setText(Long.toString(rst.getLong(8)));
if(rst2.next())
{
			sem1 = Integer.toString(rst2.getInt(2));
			sem2 = Integer.toString(rst2.getInt(3));
			sem3 = Integer.toString(rst2.getInt(4));
			sem4 = Integer.toString(rst2.getInt(5));
			sem5 = Integer.toString(rst2.getInt(6));
			sem6 = Integer.toString(rst2.getInt(7));
			sem7 = Integer.toString(rst2.getInt(8));
			sem8 = Integer.toString(rst2.getInt(9));

			tsem1.setText(sem1);
			tsem2.setText(sem2);
			tsem3.setText(sem3);
			tsem4.setText(sem4);
			tsem5.setText(sem5);
			tsem6.setText(sem6);
			tsem7.setText(sem7);
			tsem8.setText(sem8);
			percentage();
}
}	
else
{
	new JOptionPane().showMessageDialog(null,"RECORD NOT FOUND");
}		
		}		
		catch(SQLException ex)
		{
			new JOptionPane().showMessageDialog(null,"Error"+ex.getMessage());
		}
		    }
public void percentage()
{
	psem1 = (Float.parseFloat(tsem1.getText())/750)*100;
	psem2 = (Float.parseFloat(tsem2.getText())/850)*100;
	psem3 = (Float.parseFloat(tsem3.getText())/750)*100;
	psem4 = (Float.parseFloat(tsem4.getText())/800)*100;
	psem5 = (Float.parseFloat(tsem5.getText())/800)*100;
	psem6 = (Float.parseFloat(tsem6.getText())/800)*100;
	psem7 = (Float.parseFloat(tsem7.getText())/850)*100;
	psem8 = (Float.parseFloat(tsem8.getText())/750)*100;

	
}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == bsubmit)
		{
			try
		{
pst3 = con.prepareStatement(("update INFO set name=?, fathers_name=?,email=?,skills=?,batch=?,address=?,phone_no=? where roll_no_id =? "));
        		
			long rl = Long.parseLong(troll.getText());
			String name,father,achive,skill,address;
			name = tname.getText();
			father = tfather.getText();
			achive = tachive.getText();
			skill = tskill.getText();
			address = taddress.getText();
			Long number = Long.parseLong(tnumber.getText());

       			 pst3.setString(1,name);
        			pst3.setString(2,father);
       			 pst3.setString(3,achive);
      			  pst3.setString(4,skill);
       		 	pst3.setString(5,item);
        			pst3.setString(6,address);
			pst3.setLong(7,number);
			pst3.setLong(8,rl);
int a,b;

pst4 = con.prepareStatement(("update RECORDS set semester_1=?,semester_2=?,semester_3=?,semester_4=?,semester_5=?,semester_6=?,semester_7=?,semester_8=? where roll_no=? "));

			checkmks();

			pst4.setInt(1,isem1);
			pst4.setInt(2,isem2);
			pst4.setInt(3,isem3);
			pst4.setInt(4,isem4);
			pst4.setInt(5,isem5);
			pst4.setInt(6,isem6);
			pst4.setInt(7,isem7);
			pst4.setInt(8,isem8);
			pst4.setLong(9,rl);

			a = pst3.executeUpdate();
			b = pst4.executeUpdate();
			if(a>0 && b>0)
			{
				new JOptionPane().showMessageDialog(null,"SUCCESSFUL UPDATE");
				cleartext();
			}
			else
			{
				new JOptionPane().showMessageDialog(null,"Failed");
			}
        		}
		catch(SQLException ex)
		{
			new JOptionPane().showMessageDialog(null,"Error :: ::"+ex.getMessage());
		}

		}		//end of if
		
		if(ae.getSource() == search)
		{
			JOptionPane jop = new JOptionPane();
			a = jop.showInputDialog(this,"ENTER ROLL NUMBER");
			action(a);
			//jcomb.setSelectedIndex(0);
		}
			
		if(ae.getSource() == reap)
		{
			try
		{
			ppt = con.prepareStatement("select * from REAPPEARS where roll_no="+a);
			
			rest = ppt.executeQuery();

			if(rest.next())
			{
				new JOptionPane().showMessageDialog(this,rest.getString(2));
			}
			else
			{
				new JOptionPane().showMessageDialog(this,"NO REAPPEAR RECORD");
			}
		}
		catch(Exception ex)
		{		
			new JOptionPane().showMessageDialog(null,ex.getMessage());
		}
		}		// reappear action ends

		if(ae.getSource() == delete)
		{
			try
			{
				pst5 = con.prepareStatement("delete from INFO where roll_no_id =?");
				pst6 = con.prepareStatement("delete from RECORDS where roll_no = ?");
				int x,y;
				
				pst5.setString(1,troll.getText());
				pst6.setString(1,troll.getText());
				 String blaba = troll.getText();
				int val = 1;
				JOptionPane op = new JOptionPane();
				val = op.showConfirmDialog(this,"ARE U SURE U WANT TO DELETE STUDENT ?");
				if(val == JOptionPane.YES_OPTION)
				{	
				x = pst5.executeUpdate();
				y = pst6.executeUpdate();
				
				if(x>0 && y>0)
				{
					new JOptionPane().showMessageDialog(this,"RECORD DELETED SUCCESSFULLY");
				
					JOptionPane chhk = new JOptionPane();
					int chhhk = chhk.showConfirmDialog(this,"Would you like to check student reappear record and delete it ?");
					
					cleartext();
					new Info2(batcher);
					if(chhhk == JOptionPane.YES_OPTION)
					{
						new Reappear2(Long.parseLong(blaba));
					}
					dispose();
				}
				}
			}
			catch(Exception ex)
			{
				new JOptionPane().showMessageDialog(null,"ERROR : "+ex.getMessage());
			}
		}

		if(ae.getSource() == cbatch)
		{
			item = (String)cbatch.getSelectedItem();
		}

		if(ae.getSource() == bpercent)
		{
			new JOptionPane().showMessageDialog(this,"SEM 1 :  "+psem1+"\n SEM 2 :  "+psem2
			+"\n SEM 3 :  "+psem3+"\n SEM 4 :  "+psem4+"\n SEM 5 :  "+psem5+"\n SEM 6 : "+psem6
			+"\n SEM 7 :  "+psem7+"\n SEM 8 :  "+psem8);
		}
	
		if(ae.getSource() == blist)
		{
			new Selector_List();
		}
		
		if(ae.getSource() == jcomb)
		{
			a = (String)jcomb.getSelectedItem();
			if(!a.equals(""))
			{
				action(a);
			}
		}
		
		
	}

String item;


int isem1,isem2,isem3,isem4,isem5,isem6,isem7,isem8;

public void checkmks()
{
isem1=0;
isem2=0;
isem3=0;
isem4=0;
isem5=0;
isem6=0;
isem7=0;
isem8=0;	
	if(!tsem1.getText().equals(""))
	{	
		isem1 = Integer.parseInt(tsem1.getText());
	}
	if(!tsem2.getText().equals(""))
	{
		isem2 = Integer.parseInt(tsem2.getText());
	}
	if(!tsem3.getText().equals(""))
	{
		isem3 = Integer.parseInt(tsem3.getText());
	}
	if(!tsem4.getText().equals(""))
	{		
		isem4 = Integer.parseInt(tsem4.getText());
	}
	if(!tsem5.getText().equals(""))
	{
		isem5 = Integer.parseInt(tsem5.getText());
	}
	if(!tsem6.getText().equals(""))
	{
		isem6 = Integer.parseInt(tsem6.getText());
	}
	
	if(!tsem7.getText().equals(""))
	{
		isem7 = Integer.parseInt(tsem7.getText());
	}
	if(!tsem8.getText().equals(""))
	{
		isem8 = Integer.parseInt(tsem8.getText());
	}
}
	
public void cleartext()
{
		
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
			cbatch.setSelectedIndex(0);
			tnumber.setText("");
			//jcomb.setSelectedIndex(0);
			
}
PreparedStatement pre;
ResultSet res;
JComboBox jcomb;
	public void fuc()
	{
		jcomb = new JComboBox();
		jcomb.setFont(new Font("Segoe Print",Font.BOLD,20));
		jcomb.setBackground(new Color(230,230,230));
		jcomb.setForeground(new Color(255,99,71));
		jcomb.addItem("");
		try
		{
			pre = con.prepareStatement("select * from INFO where batch=? ORDER BY roll_no_id ");
			pre.setString(1,batcher);
			res = pre.executeQuery();
		
			while(res.next())
			{
				jcomb.addItem(Long.toString(res.getLong(1)));
			}
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(null,ex.getMessage());
		}
		jcomb.addActionListener(this);
	}

PreparedStatement pre_get;
ResultSet res_get;
	public void get()
	{
		try
		{
		pre_get = con.prepareStatement("select * from BATCHES");

		 res_get = pre_get.executeQuery();

			while(res_get.next())
			{
				cbatch.addItem(res_get.getString(1));
			}
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(null,ex.getMessage());
		}
	}
	
}
