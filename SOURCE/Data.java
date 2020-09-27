import java.sql.*;

class Data
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:Madmax");
			Statement st = con.createStatement();
			String sql = "Select *  from Play";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){ 
			System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		 }
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}