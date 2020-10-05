package org.commandodetails.details.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

import org.commandodetails.details.bean.UserDetails;
import org.commandodetails.details.dao.RegisterUser;
/**
 * Servlet implementation class RegisterUser
 */
@WebServlet(urlPatterns = { "/loginuser"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		UserDetails commando = new UserDetails();
		
		commando.setUserName(userName);
		commando.setPassword(password);
		
		RegisterUser commandoDAO = new RegisterUser();
		
		try {
			String userValidate = commandoDAO.authenticateUser(commando);
			commando = commandoDAO.getCommando(commando);
			HttpSession session = request.getSession();
			
			if(userValidate.equals("Admin_Role")) {
				System.out.println("Admin Page");
				session.setAttribute("Admin", userName);
				request.setAttribute("userName", userName);
				request.setAttribute("commando", commando);
				request.getRequestDispatcher("/WEB-INF/views/Admin.jsp").forward(request, response);
			}else if(userValidate.equals("Commando_Role")) {
				System.out.println("Commando Page");
				session.setAttribute("Commando", userName);
				request.setAttribute("commando", commando);
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("WEB-INF/views/Commando.jsp").forward(request, response);
			}else {
				System.out.println("Error message = "+userValidate);
	            request.setAttribute("errMessage", userValidate);
	 
	            request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
