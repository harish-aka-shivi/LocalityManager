package com.shivi;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bluecarbon
 */

public class bluecarbon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writ = response.getWriter();
		writ.println("<html>");
		writ.println("<head></head> ");
		writ.println("<body>");
		writ.println("<h1>Welcome</h1>");
		writ.println("<ol>");
		writ.println("<li><a href = \"http://localhost:8080/jdbcdemo/houseform.html\">Create House </a></li>");
		writ.println("<li><a href = \"http://localhost:8080/jdbcdemo/viewhouse\">View houses and members name</a></li>");
		writ.println("<li><a href = \"http://localhost:8080/jdbcdemo/finalview\">view members</a></li>");
		writ.println("</ol>");
		writ.println("</body>");
		writ.println("</html>");
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
