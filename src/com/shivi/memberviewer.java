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
 * Servlet implementation class memberviewer
 */
@WebServlet("/memberviewer")
public class memberviewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter  wr = response.getWriter();
		String hno = request.getParameter("param1");
		String b = request.getParameter("param2");
		int c = Integer.parseInt(b);
		try{
			Connection con = DB.getConnect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from members where house_number ="+"\'" +hno +"\'");
		    rs.first();
			for (int i =0;i<c;i++){
		    	int k = i+1;
		    	String l = String.valueOf(k);
		    	String j = "member"+l;
		    	String name = rs.getString(j);
		    	wr.print("    member"+k+":"+name+"  ");
		    	wr.print("\r\n");
		    	System.out.println("final");
			}
		    con.close();
		    
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
