import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.Image;

class ViewHelp extends JFrame implements ActionListener
{

public static void main(String ar[])
{
new ViewHelp();
}

JLabel label1, label001, label0, label, label2, label3, label4, label5, label6, label7;

JButton btn, btn1;


public ViewHelp()
{
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





ImageIcon imgLabel = new ImageIcon("Help!.png");
JLabel lab = new JLabel(imgLabel);

ImageIcon img=new ImageIcon("Help!.png");

setIconImage(img.getImage());
setContentPane(new JLabel(new ImageIcon("Help_Back.png")));


setContentPane(new JLabel(new ImageIcon("Help_Back.png"))); //SETS BACKGROUNG IMAGE


setLayout(new GridLayout(9,10));
label0 = new JLabel("           Student Information System Help");
label0.setFont(new Font("Segoe UI",Font.BOLD, 20));
label0.setForeground(Color.WHITE);

label = new JLabel("Here, you will learn, how to use this program. The steps to operate this");
label.setFont(new Font("Segoe UI", Font.PLAIN, 15)); 
label.setForeground(Color.white);


label1 = new JLabel("program will be guided.");
label1.setFont(new Font("Segoe UI", Font.PLAIN, 15)); 
label1.setForeground(Color.white);

label3 = new JLabel("Choose the topic from following for which you want help:");
label3.setFont(new Font("Segoe UI", Font.PLAIN, 16)); 
label3.setForeground(Color.white);


label5 = new JLabel("");

btn = new JButton("Help on Viewing a record");
btn.setFont(new Font("Century", Font.PLAIN, 20)); 


label4 = new JLabel("");

btn1 = new JButton("Help on Inserting, Deleting & Changing a record");
btn1.setFont(new Font("Century", Font.PLAIN, 20)); 

add(label0);
add(label);
add(label1);
add(label3);


btn.addActionListener(this);		// HELPS TO LISTEN THE USER CLICK
btn1.addActionListener(this);		// HELPS TO LISTEN THE USER CLICK

add(btn);
add(label4);
add(btn1);
add(label5);


setSize(500,380);
setResizable(true);
setTitle("Student Information System Program Help");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==btn)
{
new RecViewHelp();
}


else if(ae.getSource()==btn1)
{
new RecModifyHelp();
}

}
}