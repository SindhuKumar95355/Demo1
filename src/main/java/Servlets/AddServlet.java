package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import todo.Entities;
import todo.FactoryProvider;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Entities e = new Entities(title , content , new Date());
		
//		System.out.println(title + " :" + content + e.getSavedDate() );
		
		Session s = FactoryProvider.getFactory().openSession();
		
		Transaction t = s.beginTransaction();
		s.save(e);
		t.commit();
		s.close();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("notes is added successfully");
		out.print(" <a href=AllNotes.jsp><h3>click here to see</h></a> ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
