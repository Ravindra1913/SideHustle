package pack1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class FollowersServlet extends HttpServlet {

	
	public Connection con;
	public void init() throws ServletException
	{
		con = DBConnection.getCon();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Followers Servlet Has been triggered");
		okhttp3.Response response = null;
		
		String msg = InstaInfoProviderService.getFollowerCount();
		System.out.println(msg);
		pw.println(msg);
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.include(req, res);
	
			
	}
}
