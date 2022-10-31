package pack1;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	private static Connection con;
	private DBConnection() {}
	static
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://r8d0slgrnod73cvh:om2lja17rqlr05om@o2olb7w3xv09alub.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/miuocwropduzup1i";
		String username = "r8d0slgrnod73cvh";
		String password = "om2lja17rqlr05om";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl,username,password);
		}
		catch(Exception e) {e.printStackTrace();}	
	}
	public static Connection getCon()
	{
		return con;
	}
}
