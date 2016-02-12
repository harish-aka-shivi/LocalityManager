package com.shivi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DB;

/**
 * Servlet implementation class finalviewer
 */
@WebServlet("/finalviewer")
public class finalviewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finalviewer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		System.out.println("anything");
		try{
			Connection conn = DB.getConnect();
			System.out.print("do it");
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from houses");
			out.println("<table border=2 cellpadding=\"5\">");
			out.println("<thead><tr><th>S. No.</th> <th> House no.</th> <th> No of Members </th> <th> View members </th></tr></thead>");
			out.println("<tbody>");
			
			while(rs.next()){
				int a = rs.getInt("id");
				String b = rs.getString("house_number");
				String c = rs.getString("number_of_members");
				//String e = String.valueOf(a);
				String d = "<a href = http://localhost:8080/jdbcdemo/memberview?param1="+b+"&param2="+c+">VIEW</a>";
				System.out.println(b);
				System.out.println(d);
				out.println("<tr><td>" + a +"</td><td>" + b + "</td><td>" + c + "</td><td>"+ d +"</td></tr>");
			}
			out.println("/tbody");
			out.println("</table");
			out.println("</body></html>");
			conn.close();
					}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
