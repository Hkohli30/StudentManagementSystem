import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Selector_user extends JFrame implements ItemListener,ActionListener
{
	public static void main(String args[])
	{
		new Selector_user();
	}
	
JButton ok;
JComboBox cb;
String pass;	
	public Selector_user()
	{
		setLayout(new BorderLayout());

JLabel northtext = new JLabel("BATCH SELECTOR");
JLabel select = new JLabel("SELECT BATCH : ");
ok = new JButton("OK");
cb = new JComboBox();
JPanel center = new JPanel(new FlowLayout());
JPanel north = new JPanel(new FlowLayout());
JPanel south = new JPanel(new FlowLayout());

Font f = new Font("Segoe Print",Font.BOLD,20);
		
		northtext.setFont(f);	ok.setFont(f);
		cb.setFont(f);		select.setFont(f);

		center.add(select);		center.add(cb);

		north.add(northtext);

		south.add(ok);

		add(center,BorderLayout.CENTER);
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Batch Selector");
		setSize(490,200);
			
// SET DATA
		setdata();

ok.addActionListener(this);
cb.addItemListener(this);

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == ok)
		{
			if(pass == null || pass.equals(""))
			{
				new JOptionPane().showMessageDialog(this,"SELECT A BATCH ");
			}
			else
			{
				new Info_user(pass);
				dispose();
			}
		}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		pass = (String)cb.getSelectedItem();
	}
PreparedStatement pst;
ResultSet rst;
Connection con;
	public void setdata()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sbbs","sbbs");

			pst = con.prepareStatement("select * from BATCHES");
			rst = pst.executeQuery();
			cb.addItem("");
			while(rst.next())
			{
				cb.addItem(rst.getString(1));
			}
		}
		catch(Exception ex)
		{
			new JOptionPane().showMessageDialog(this,ex.getMessage());
		}
	}
}