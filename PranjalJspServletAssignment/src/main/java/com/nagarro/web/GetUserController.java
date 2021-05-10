package com.nagarro.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.nagarro.web.dao.UserDao;
import com.nagarro.web.model.User;

/**
 * Servlet implementation class GetUserController
 */
public class GetUserController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aid=request.getParameter("aid");
		String password=request.getParameter("pass");		
		UserDao dao=new UserDao();
		
		try {
			boolean isuser=UserDao.getUser(aid,password);
			String destpage="index.jsp";
			
			if(isuser == true)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username",aid);
				destpage="showUser.jsp";
			}else {
				String message="This is Invalid email or password. Please check again";
				request.setAttribute("message",message);
			}
			RequestDispatcher dispatcher=request.getRequestDispatcher(destpage);
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("Failed - Problem occured!");
			throw new ServletException(e);
		}
		
	}

}
