package com.shivi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DB;

/**
 * Servlet implementation class memberadder
 */

public class memberadder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberadder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hs = request.getParameter("limit1");
		String lm = request.getParameter("house");
		int lmin = Integer.parseInt(lm);
		PrintWriter out = response.getWriter();
		String[] mem_arr = new String[lmin];
		try{
			Connection conn = DB.getConnect();
			Statement stmt = conn.createStatement();
			String sql = "insert into members(house_number)values" + "(" + "\'" +hs+"\'" +")";
			stmt.executeUpdate(sql);
		
		for(int i = 0; i< lmin; i++){
			int j  = i+1;
			
			String x = "member"+String.valueOf(j);
			mem_arr[i]= request.getParameter(x);
			System.out.println("x ="+x );
			System.out.println("mem_arr[i] ="+ mem_arr[i]);
			String y = String.valueOf(x);
			String k = ("UPDATE members SET "+ x +"=" +"\""+ mem_arr[i]+"\"" + "where house_number ="+"\'"+hs+"\'");
			System.out.println(k);
			stmt.executeUpdate(k);
			}
		out.println("your data has been saved");
	
		conn.close();
	}
		catch(Exception e){
			e.printStackTrace();
		}

}}
