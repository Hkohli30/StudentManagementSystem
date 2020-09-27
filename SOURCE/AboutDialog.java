import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.Image;

class AboutDialog extends JFrame 
{

public static void main(String ar[])
{
new AboutDialog();
}


JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19;


public AboutDialog()

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






ImageIcon imgLabel = new ImageIcon("About.png");
JLabel lab = new JLabel(imgLabel);

ImageIcon img=new ImageIcon("About.png");

setIconImage(img.getImage());
setContentPane(new JLabel(new ImageIcon("security2.jpg")));


setContentPane(new JLabel(new ImageIcon("grey.jpg"))); //SETS BACKGROUND IMAGE


setLayout(new GridLayout(19,19)); //14,14


label1 = new JLabel("");


label2 = new JLabel("    About Student Information System");
label2.setFont(new Font("Segoe UI",Font.BOLD, 23));
label2.setForeground(Color.white);

label3 = new JLabel("");

label4 = new JLabel("This program aims to ease the way you insert any student");
label4.setFont(new Font("Century", Font.PLAIN, 16));
label4.setForeground(Color.white);

label5 = new JLabel("record in database. This program has inbuilt database that");
label5.setForeground(Color.white);
label5.setFont(new Font("Century",Font.PLAIN, 16));


label6 = new JLabel("records each entry you want to store in the database.");
label6.setForeground(Color.white);
label6.setFont(new Font("Century",Font.PLAIN, 16));

label7 = new JLabel("You can also view/alter any information previously stored.");
label7.setFont(new Font("Century", Font.PLAIN, 16));
label7.setForeground(Color.white);

label8 = new JLabel(" ");

label9 = new JLabel("This program has multiple authors. The database works have");
label9.setForeground(Color.white);
label9.setFont(new Font("Century", Font.PLAIN, 16));

label10 = new JLabel("been done by Mr. Himanshu Kohli, UI work has been done by");
label10.setForeground(Color.white);
label10.setFont(new Font("Century", Font.PLAIN, 16));


label11 = new JLabel("both Mr. Himanshu Kohli & Mr. Naveen Chadha. The Oracle");
label11.setForeground(Color.white);
label11.setFont(new Font("Century", Font.PLAIN, 16));

label12 = new JLabel("Database Express Edition has been used.");
label12.setForeground(Color.white);
label12.setFont(new Font("Century", Font.PLAIN, 16));

label13 = new JLabel("");

label14 = new JLabel("Thank You for using this program.");
label14.setForeground(Color.white);
label14.setFont(new Font("Century", Font.PLAIN, 16));

label15 = new JLabel("Want to contact?");
label15.setForeground(Color.white);
label15.setFont(new Font("Century", Font.PLAIN, 16));

label16 = new JLabel("Drop an email to one of the following:");
label16.setForeground(Color.white);
label16.setFont(new Font("Century", Font.PLAIN, 16));


label17 = new JLabel("Mr. Himanshu Kohli: himanshukohli31@yahoo.in");
label17.setForeground(Color.white);
label17.setFont(new Font("Century", Font.PLAIN, 16));

label18 = new JLabel("Mr. Naveen Chadha: naveenchadha2221995@gmail.com");
label18.setForeground(Color.white);
label18.setFont(new Font("Century", Font.PLAIN, 16));


label19 = new JLabel("");

add(label1);
add(label2);
add(label3);
add(label4);
add(label5);
add(label6);
add(label7);
add(label8);
add(label9);
add(label10);
add(label11);
add(label12);
add(label13);
add(label14);
add(label15);
add(label16);
add(label17);
add(label18);
add(label19);

setSize(460,650);          //500,500
setResizable(false);
setTitle("About NCDataShield");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setVisible(true);
}

}