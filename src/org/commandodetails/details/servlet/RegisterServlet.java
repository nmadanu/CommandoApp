package org.commandodetails.details.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import org.commandodetails.details.bean.UserDetails;
import org.commandodetails.details.dao.RegisterUser;
/**
 * Servlet implementation class RegisterUser
 */
@WebServlet(urlPatterns = { "/registeruser"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> topicList = new ArrayList<String>();
		
		RegisterUser commandoDAO = new RegisterUser();
		
		topicList = commandoDAO.listTopics();
		
		request.setAttribute("topicList", topicList);
		request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
	    String emailID = request.getParameter("emailID");
	    String phone = request.getParameter("phone");
	    String password = request.getParameter("password");
	    String title = request.getParameter("title");
	    String interestedTopic = request.getParameter("interestedTopic");
	    
	    UserDetails commando = new UserDetails();
	    
	    commando.setUserName(userName);
	    commando.setEmailID(emailID);
	    commando.setPhone(phone);
	    commando.setPassword(password);
	    commando.setTitle(title);
	    commando.setInterestedTopic(interestedTopic);
	    
	    RegisterUser commandoDAO = new RegisterUser();
	    
	    String commandoRegistered = commandoDAO.insertUser(commando);
	    
	    if(commandoRegistered.equals("SUCCESS")) {
	    	request.setAttribute("regMessage", "Registered Successfully");
	    	request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
	    }else {
	    	request.setAttribute("errMessage", commandoRegistered);
	    	request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
	    }
	}

}
