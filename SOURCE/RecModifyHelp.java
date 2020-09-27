import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.Image;

class RecModifyHelp extends JFrame implements ActionListener
{

public static void main(String ar[])
{
new RecModifyHelp();
}

JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, label20, label21, label22, label23, label24, label25, label26, label27, label28, label29, label30, label31;

//JButton btn, btn1;


public RecModifyHelp()
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






 // Get the container and set the background
getContentPane().setBackground(Color.orange);



/*
ImageIcon imgLabel = new ImageIcon("About.JPG");
JLabel lab = new JLabel(imgLabel);

ImageIcon img=new ImageIcon("About.jpg");

setIconImage(img.getImage());
setContentPane(new JLabel(new ImageIcon("security2.jpg")));


setContentPane(new JLabel(new ImageIcon("info.jpg"))); //SETS BACKGROUND IMAGE
*/

setLayout(new GridLayout(30,30));

label1 = new JLabel("In Steganography, the text is encrypted inside an image.");
label1.setFont(new Font("Sylfaen",Font.ITALIC, 18));
//label1.setForeground(Color.BLACK);

//label2 = new JLabel("    ");
label3 = new JLabel("    ");

label4 = new JLabel("To perform Steganography, follow the under written instructions: ");
//label.setVerticalAlignment(SwingConstants.TOP);
label4.setFont(new Font("Montserrat", Font.PLAIN, 14));
//label.setForeground(Color.white);

label5 = new JLabel("    ");

label6 = new JLabel("1. Click 'Image' button, after opening VisualStegano program window.");
label6.setFont(new Font("Montserrat", Font.ITALIC, 12));

label7 = new JLabel("    ");


label8 = new JLabel("2. Choose, which option do you want the program to perform.");
//label6.setFont(new Font("Sylfaen", Font.ITALIC, 16));

label9 = new JLabel("    ");

label10 = new JLabel("3. For encryption, click 'Encoding' radiobutton.");
//label10.setFont(new Font("Sylfaen", Font.ITALIC, 16));

label11 = new JLabel("    ");

label12 = new JLabel("3.1. Provide the desired image by clicking 'Image' button' ");

label13 = new JLabel("    ");

label14 = new JLabel("3.2. Also, provide the text that you want the program to encrypt in image, in 'Message' field.");
//label14.setFont(new Font("Sylfaen", Font.ITALIC, 16));


label15 = new JLabel("    ");

label16 = new JLabel("3.3. Click 'Do Stegnograph'. The path for encrypted image will be same as that of the original image.");
//label16.setFont(new Font("Sylfaen", Font.ITALIC, 16));


label17 = new JLabel("    ");

label18 = new JLabel("4. For Decryption, click 'Decoding' radiobutton.");
//label18.setFont(new Font("Sylfaen", Font.ITALIC, 16));

label19 = new JLabel("4.1. Provide the previously encrypted image. Encrypted image should be present in same folder, ");
//label19.setFont(new Font("Sylfaen", Font.ITALIC, 16));

label20 = new JLabel("as that of original image.");
//label20.setFont(new Font("Sylfaen", Font.ITALIC, 16));

label21 = new JLabel("    ");

label22 = new JLabel("for example: Path for Original Image: 'D:>Image>image1.jpg' ");
//label22.setFont(new Font("Sylfaen", Font.ITALIC, 16));


label23 = new JLabel("    ");

label24 = new JLabel("                       Path for previously Encrypted Image: 'D:>Image>encryptedFile' ");
//label24.setFont(new Font("Sylfaen", Font.ITALIC, 16));

label25 = new JLabel("    ");

label26 = new JLabel("4.2. This 'encryptedFile' cannot be opened. It can only be opened if decryption is performed.");
//label26.setFont(new Font("Sylfaen", Font.ITALIC, 16));



label27 = new JLabel("    ");

label28 = new JLabel("4.3. The encrypted image will now be decrypted and will have same path as told above.");
//label28.setFont(new Font("Sylfaen", Font.ITALIC, 16));


label29 = new JLabel("    ");

label30 = new JLabel("4.3. Name of decrypted image will be, 'decryptedFile'.");
//label30.setFont(new Font("Sylfaen", Font.ITALIC, 16));


add(label1);
//add(label2);
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
add(label20);
add(label21);
add(label22);
add(label23);
add(label24);
add(label25);
add(label26);
add(label27);
add(label28);
add(label29);
add(label30);




setSize(662,527);
setResizable(false);
setTitle("Steganography Help");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
//if(ae.getSource() == btn4)
{
System.exit(1);
}



}
}