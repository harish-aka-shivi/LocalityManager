package com.shivi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.mysql.*;

import com.jdbc.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.ResultSet;



/**
 * Servlet implementation class housecreator
 */

public class housecreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public housecreator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String housenumber1 = request.getParameter("housenumber");
		String member = request.getParameter("members");
		PrintWriter writ = response.getWriter();
		try{
		System.out.println("hello");
		Connection conn = DB.getConnect();
		String sql = "insert into houses(house_number, number_of_members) values(?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, housenumber1);
		stmt.setString(2, member);
		int rs = stmt.executeUpdate();
		System.out.println("rows affected" + rs);
		
		conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}	
		writ.println("Your data has been saved");
	}

}
