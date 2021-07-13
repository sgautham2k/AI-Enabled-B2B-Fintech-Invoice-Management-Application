package com.higradius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.sql.Connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Initializing the database 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int Numberofrows = 12;
		
		try {
			Connection conn = ConnectionServlet.connectToDB();
			
			String pageInURL = request.getParameter("page");
			int page = Integer.parseInt(pageInURL) * Numberofrows;
			
			Statement st = conn.createStatement();
			String sql_statement = "SELECT cust_number, name_customer, invoice_id, total_open_amount, due_in_date, clear_date, delay_bucket from mytable" + page + "," + Numberofrows;
			ResultSet rs = st.executeQuery(sql_statement);
			
			ArrayList<InvoiceServlet> mytablelist = new ArrayList<>();
			while(rs.next()) {
				InvoiceServlet mytable = new InvoiceServlet();
				mytable.setName_customer(rs.getString("name_customer"));
				mytable.setCust_number(rs.getString("cust_number"));
				mytable.setInvoice_id(rs.getString("invoice_id"));
				mytable.setTotal_open_amount(rs.getString("total_open_amount"));
				mytable.setDue_in_date(rs.getString("due_in_date"));
				mytable.setClear_date(rs.getString("clear_date"));
				mytable.setDelay_bucket(rs.getString("delay_bucket"));
				mytablelist.add(mytable);
			}
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String invoices = gson.toJson(mytablelist);
			out.print(invoices);
			response.setStatus(200);
			out.flush();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
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