package com.shivi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adder
 */

public class adder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String house = request.getParameter("param2");
		int houseint = Integer.parseInt(house);
		String limit = request.getParameter("param1");
		//int limit = Integer.parseInt(a);
		System.out.println("limit  = " +limit);
		System.out.println("house = "+house);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html><body>");
		out.println("<form method = \"post\" action =\"addmember\">");
		for(int i = 0;i<houseint;i++){
			int j= i+1; 
			String k = String.valueOf(j);
			String l = "member"+k;
			
			
			out.println("Member "+j+":<input name ="+"\"" +l+"\"" +"/><br>");
			System.out.println("5");
			System.out.println("member name is "+ l);
		}
		out.println("<input type = \"hidden\" name=house value = "+ house+">");
		String limit1 = request.getParameter("param1");
		out.println("<input type = \"hidden\" name = limit1 value =" + limit1 + ">");
		out.println("<input type = \"submit\">");
		out.println("</form></body></html>");
	}

}
