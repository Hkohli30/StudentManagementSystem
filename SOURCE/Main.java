import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame implements ActionListener
{
JButton btn1, btn2, btn3;
JFrame frame;
JLabel label;
public static void main(String ar[]) 
{
new Main();
}

JLabel label0, label01, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;

JMenuItem ViewHelp,About;

JMenu Help = new JMenu ("Help");


public Main()
{



/*

		setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}


*/

ImageIcon img=new ImageIcon("NCDataShield1.png");
setIconImage(img.getImage());

setContentPane(new JLabel(new ImageIcon("Black.jpg"))); //SETS BACKGROUND IMAGE



//Cryptography.setText("<HTML>Click the <FONT color=\"#000099\"><U>link</U></FONT>" + " to go to the Java website.</HTML>");
//Cryptography.addActionListener(new OpenUrlAction());



setLayout(new GridLayout(12,12));

		 
label0 = new JLabel("-----------------------STUDENT INFORMATION SYSTEM-----------------------");
label0.setFont(new Font("Segoe UI", Font.BOLD, 20));
label0.setForeground(Color.WHITE);

label01 = new JLabel("");

label1 = new JLabel("Welcome to student information system. This program helps you to view, insert/delete/");
label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
label1.setForeground(Color.WHITE);

label2 = new JLabel("modify student information.");
label2.setForeground(Color.WHITE);
label2.setFont(new Font("Segoe UI",Font.PLAIN, 18));


/*
TO MAKE THE FONT BOLD/ITALIC, SET FONT STYLE USE:
label.setFont(new Font("Segoe UI", Font.BOLD, 10));

TO SET THE FONT COLOUR
label.setForeground(Color.black);
*/




label3 = new JLabel("Please select how would you like to login from following:");
label3.setFont(new Font("Segoe UI", Font.BOLD, 20));
label3.setForeground(Color.WHITE);


label4 = new JLabel("                                              ");

btn1 = new JButton("Log in as an ADMINISTRATOR");
btn1.setFont(new Font("Segoe UI", Font.BOLD, 20));
btn1.addActionListener(this);

label5 = new JLabel("                                              ");

btn2 = new JButton("Log in as a USER");
btn2.setFont(new Font("Segoe UI", Font.BOLD, 20));
btn2.setForeground(Color.BLACK);


label6 = new JLabel("                                              ");


btn3 = new JButton("Exit this program");
btn3.addActionListener(this);
btn3.setFont(new Font("Segoe UI", Font.BOLD, 18));


label7 = new JLabel("                                              ");

label8 = new JLabel("Proceed to 'Help' section if you can not use this program.");
label8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
label8.setForeground(Color.white);


add(label0);
add(label1);
add(label2);
add(label3);
add(label4);
add(btn1);
add(label5);
add(btn2);
add(label6);
add(btn3);
add(label7);
add(label8);

ViewHelp = new JMenuItem("View Help");
About = new JMenuItem("About...");


Help.add(ViewHelp);
Help.add(About);


JMenuBar jmbar = new JMenuBar();

jmbar.add(Help);
setJMenuBar(jmbar);

About.addActionListener(this);
ViewHelp.addActionListener(this);
btn2.addActionListener(this);

setSize(700,500);
setResizable(false);
setTitle("Student Information System for CSE Branch");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




/*

{
Object[] options = {"Yes, please", "No way!"};
int n = JOptionPane.showOptionDialog(frame, "Hi there! Really want to exit this program?", "Action Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
    null,     //do not use a custom Icon
    options,  //the titles of buttons
    options[0]); //default button title

if(n == JOptionPane.YES_OPTION)
{
System.exit(1);
}

*/

setVisible(true);

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource() == btn1)
{
new Selector();
}

if(ae.getSource() == btn3)
{


Object[] options = {"Yes, please, Exit now", "No way! :))"};
int n = JOptionPane.showOptionDialog(frame, "Hi there! Really want to exit this program?", "Action Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
    null,     //do not use a custom Icon
    options,  //the titles of buttons
    options[0]); //default button title

if(n == JOptionPane.YES_OPTION)
{
System.exit(1);
}
}

if(ae.getSource() == btn2)
{
 	new Login();
}


else if(ae.getSource()==ViewHelp)
{
new ViewHelp();
}

else if(ae.getSource()==About)
{
new AboutDialog();
}


}

/*
public void windowClosing(WindowEvent e)
{
Object[] options = {"Yes, please", "No way! I want to be promoted!!!"};
int n = JOptionPane.showOptionDialog(frame, "Hi there! Really want to exit this program?", "Action Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
    null,     //do not use a custom Icon
    options,  //the titles of buttons
    options[0]); //default button title

if(n == JOptionPane.YES_OPTION)
{
System.exit(1);
}
}	*/

}