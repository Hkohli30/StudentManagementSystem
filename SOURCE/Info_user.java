import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

	class Info_user extends JFrame implements ActionListener
	{
		public static void main(String args[]) 
    		{
			String bogus ="2012-2016";
			new Info_user(bogus);
		} 
Connection con;
JLabel tname,tfather,tachive,tskill,troll,tsem1,tsem2,tsem3,tsem4,tsem5,tsem6,tsem7,tsem8,cbatch,tnumber;
JButton bsubmit,reappear,bpercent,blist,blist2;
JLabel taddress;
ResultSet rst,rst2;
float psem1,psem2,psem3,psem4,psem5,psem6,psem7,psem8;
String batcher;
	public Info_user(String bxtr)
	{
		batcher = bxtr;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");
	}
	catch(Exception ex)
	{
		JOptionPane jp = new JOptionPane();
		jp.showMessageDialog(this,ex.getMessage());
	}
	// LABAES
	JLabel text1 = new JLabel("USER VIEW & SEARCH PANEL ");
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
        bsubmit = new JButton("NEW SEARCH");
	reappear = new JButton("Reapper Records");
	bpercent = new JButton("PERCENTAGE");
        blist = new JButton(" LIST ");
	blist2 = new JButton("REAPPEAR LIST");	

        //TEXTFIELDS
        tname = new JLabel();
        tfather = new JLabel();
        troll = new JLabel();
        tachive = new JLabel();
        tskill = new JLabel();
        tsem1 = new JLabel();
        tsem2 = new JLabel();
        tsem3 = new JLabel();
        tsem4 = new JLabel();
        tsem5 = new JLabel();
        tsem6 = new JLabel();
        tsem7 = new JLabel();
        tsem8 = new JLabel();
        taddress = new JLabel();
cbatch = new JLabel();
tnumber = new JLabel();
	

// FONTS

	Font f = new Font("Segoe UI",Font.BOLD,20);
	Font f2 = new Font("Segoe UI",Font.BOLD,20);
	Font f3 = new Font("Segoe UI",Font.BOLD,30);
	
	
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
	bpercent.setFont(f);
	reappear.setFont(f);
	blist.setFont(f);
	blist2.setFont(f);	

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


// NORTHPANEL
		northpanel.add(text1);
		northpanel.add(new JLabel("                "));


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
		southpanel.add(blist);
		southpanel.add(new JLabel("                     "));
		southpanel.add(blist2);
		southpanel.add(new JLabel("                     "));
		southpanel.add(bpercent);
		southpanel.add(sp);
		southpanel.add(reappear);
		southpanel.add(new JLabel("                     "));
		southpanel.add(bsubmit);
		
// ADD LISTENERS

	bsubmit.addActionListener(this);
	reappear.addActionListener(this);
	bpercent.addActionListener(this);
	blist.addActionListener(this);
 	blist2.addActionListener(this);
	

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
	blist.setForeground(new Color(255,69,0));
	blist2.setForeground(new Color(255,69,0));


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
	reappear.setForeground(new Color(255,69,0));
	bpercent.setForeground(new Color(255,69,0));

//JOptionPane op = new JOptionPane();
//		a = op.showInputDialog(this,"ENTER THE ROLL NO.");
//		action(a);
			
// 	fuc
		fuc();
		northpanel.add(jcomb);

	setTitle("Information Portal");
	setVisible(true);
	setSize(1200,600);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}  
PreparedStatement pst,pst2;
int sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;

	public void action(String a)
	{
    		
		try
		{
			pst = con.prepareStatement(("select * from INFO where roll_no_id="+a));
			pst2 = con.prepareStatement(("select * from RECORDS where roll_no="+a));
			
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
			cbatch.setText(rst.getString(6));
			taddress.setText(rst.getString(7));
			tnumber.setText(Long.toString(rst.getLong(8)));
String sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
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
}
}		
else
{
	new JOptionPane().showMessageDialog(null,"RECORD DO NOT EXIST");
}	
		percentage();
		}		

		catch(SQLException ex)
		{
			new JOptionPane().showMessageDialog(null,"Error"+ex.getMessage());
			System.exit(0);
		}
		    
	}
String a;
PreparedStatement ppt;
ResultSet rest,rrt;
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource() == bsubmit)
	{
		
		JOptionPane jop = new JOptionPane();
		a = jop.showInputDialog(this,"ENTER ROLL NO.");
		if(a != null)
		{
		action(a);
		}
	}

	if(ae.getSource() == reappear)
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
	}

	if(ae.getSource() == bpercent)
		{
			new JOptionPane().showMessageDialog(this,"SEM 1 :  "+psem1+"\n SEM 2 :  "+psem2
			+"\n SEM 3 :  "+psem3+"\n SEM 4 :  "+psem4+"\n SEM 5 :  "+psem5+"\n SEM 6 : "+psem6
			+"\n SEM 7 :  "+psem7+"\n SEM 8 :  "+psem8);
		}

		if(ae.getSource() ==  blist)
		{
			new Selector_List();
		}
	
		if(ae.getSource() == blist2)
		{
			new Selector_Reap();
		}
		
		if(ae.getSource() == jcomb)
		{
			String l = (String)jcomb.getSelectedItem();
			if( l == "")
			{
				new JOptionPane().showMessageDialog(null,"Select Valid RollNo");
			}
			else
			{
				a=l;
				action(a);
			}
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
			pre = con.prepareStatement("select * from INFO where batch = ? ORDER BY roll_no_id");
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
} 

