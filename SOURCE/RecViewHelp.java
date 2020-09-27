import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.Image;

class RecViewHelp extends JFrame 
{

public static void main(String ar[])
{
new RecViewHelp();
}

JLabel label001, label01, label0, label, label3, label4, label5, label6, label8, label7, label71, label9, label10, label11, label12, label13, label99, label14, label15;

JButton btn, btn1;


public RecViewHelp()
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





ImageIcon imgLabel = new ImageIcon("Abiut.JPG");
JLabel lab = new JLabel(imgLabel);

ImageIcon img=new ImageIcon("About.jpg");

setIconImage(img.getImage());
setContentPane(new JLabel(new ImageIcon("UI_COLOR.jpg")));


setContentPane(new JLabel(new ImageIcon("UI_COLOR.jpg"))); //SETS BACKGROUNG IMAGE


setLayout(new GridLayout(18,18));

label001 = new JLabel("                       HELP FOR VIEWING RECORDS");
label001.setFont(new Font("Segoe UI",Font.BOLD, 20));
label001.setForeground(Color.white);


label0 = new JLabel("This program has 2 panels, ADMIN PANEL & USER PANEL. ADMIN Panel is granted all the");
label0.setFont(new Font("Segoe UI",Font.PLAIN, 14));
label0.setForeground(Color.white);

label = new JLabel("permissions & USER panel is offered limited permissions. Steps to operate program are:");
label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label.setForeground(Color.white);

label4 = new JLabel("Steps to view a record FOR USER PANEL------------------------------------------------");
label4.setFont(new Font("Segoe UI", Font.BOLD|Font.ITALIC, 16));
label4.setForeground(Color.white);

label3 = new JLabel("Step 1: LOGIN as a USER: Enter NAME & PASSWORD; Click Login. Dialog box will tell result of login.");
label3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label3.setForeground(Color.white);

label6 = new JLabel("Step 2: Now choose 'Encryption' using radio button at the top. Provide text to encrypt & key.");
label6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label6.setForeground(Color.white);


label7 = new JLabel("Step 3: Click 'Encrypt' button. The encrypted text will be shown under 'CIPHERTEXT' section.");
label7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label7.setForeground(Color.white);




label9 = new JLabel("STEPS FOR DECRYPTION --------------------------------------------------------------------");
label9.setFont(new Font("Segoe UI", Font.BOLD, 14));
label9.setForeground(Color.white);

label71 = new JLabel("Step 1: Copy the CipherText by selecting full text (press Ctrl+A) and then copy it (press Ctrl+C).");
label71.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label71.setForeground(Color.white);


label8 = new JLabel("Step 2: Now, choose 'Decryption' by clicking the radio button at top of window. Provide the key.");
label8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label8.setForeground(Color.white);


label10 = new JLabel("            Provide the same key that was provided during encryption, else result may differ.");
label10.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label10.setForeground(Color.white);


label11 = new JLabel("Step 3: Paste the previously copied CipherText in its field and click 'Decrypt' button.");
label11.setFont(new Font("Segoe UI", Font.PLAIN, 14));
label11.setForeground(Color.white);


label13 = new JLabel ("");


label01 = new JLabel("STEPS TO USE VISUAL CRYPTOGRAPHY -------------------------------------------------");
label01.setFont(new Font("Segoe UI",Font.BOLD, 16));
label01.setForeground(Color.white);

label99 = new JLabel("Click 'Use Visual Cryptography' from main menu. Choose Image to encrypt. Click Crypt button.");
label99.setFont(new Font("Segoe UI",Font.PLAIN, 14));
label99.setForeground(Color.white);

label12 = new JLabel ("Image will be saved as name 'encryptedFile'. This image cannot be viewed. Now, to decrypt this");
label12.setFont(new Font("Segoe UI",Font.PLAIN, 14));
label12.setForeground(Color.white);



label14 = new JLabel ("image, again click 'Browse' button. Click 'Crypt' button to decrypt the encrypted image.");
label14.setFont(new Font("Segoe UI",Font.PLAIN, 14));
label14.setForeground(Color.white);



label15 = new JLabel ("The decrypted image will be saved as 'decryptedFile'. Congrats! Your data is secured now :).");
label15.setFont(new Font("Segoe UI",Font.PLAIN, 14));
label15.setForeground(Color.white);



add(label001);
add(label0);
add(label);
add(label4);
add(label3);
add(label6);
add(label7);
add(label9);
add(label71);
add(label8);
add(label10);
add(label11);
add(label13);
add(label01);
add(label99);
add(label12);
add(label14);
add(label15);



setSize(600,630);
setResizable(false);
setTitle("Help on Viewing a Record");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setVisible(true);
}


}