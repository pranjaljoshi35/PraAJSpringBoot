package com.nagarro.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.web.model.Image;

/**
 * Servlet implementation class DisplayImage
 */
public class DisplayImage extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		PrintWriter out=response.getWriter();
//		out.println("worked.......");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Image.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		Session session=sessionFactory.openSession();
		Transaction tnx=session.beginTransaction();

		Query q=session.createQuery("from Image");
		List<Image> lst=q.list();
		System.out.println(lst);		
		HttpSession sn = request.getSession();
		sn.setAttribute("images", lst);
		
		tnx.commit();
		RequestDispatcher dis=request.getRequestDispatcher("uploaded.jsp");
		dis.forward(request, response);
	}
}
