package com.nagarro.web;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.web.model.Image;

/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String image_link=request.getParameter("imglink");
		

		Image img=new Image();
		img.setPreview(image_link);
		img.setSize(1.0);
		img.setActions("car");
		
		String separator = "\\";
		String[] str_arr=image_link.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
		String image_info=null;
		for(String s:str_arr)
		{
			image_info=s;
		}
		img.setName(image_info);
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Image.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		Session session=sessionFactory.openSession();
		Transaction tnx=session.beginTransaction();
		session.save(img);
		tnx.commit();
		System.out.println(img);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("DisplayImage");
		dispatcher.forward(request, response);
		
		
//		RequestDispatcher dis=request.getRequestDispatcher("showUser.jsp");
//		dis.forward(request, response);
		
	}

}
