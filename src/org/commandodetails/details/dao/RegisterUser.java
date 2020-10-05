package org.commandodetails.details.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import org.commandodetails.details.bean.UserDetails;
import org.commandodetails.details.utils.MySQLConn;

public class RegisterUser {

	public String insertUser(UserDetails commando) {
		
		String userName = commando.getUserName();
	    String emailID = commando.getEmailID();
	    String phone = commando.getPhone();
	    String password = commando.getPassword();
	    String title = commando.getTitle();
	    String interestedTopic = commando.getInterestedTopic();
	    
	    Connection conn = null;
	    PreparedStatement ps = null;
	    
	    try {
	    	conn = MySQLConn.establishConn();
	    	String stmt = "insert into USER_DETAILS(Username, EmailId, Phone, Password, Title, InterestedTopic)" //
	    			+ " values(?, ?, ?, ?, ?, ?)";
	    	ps = conn.prepareStatement(stmt);
	    	ps.setString(1, userName);
	    	ps.setString(2, emailID);
	    	ps.setString(3, phone);
	    	ps.setString(4, password);
	    	ps.setString(5, title);
	    	ps.setString(6, interestedTopic);
	    	
	    	if(ps.executeUpdate() != 0)
	    		return "SUCCESS";
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		
		return "Something was wrong... try again.";
	}
	
	public List<String> listTopics(){
		List<String> topicList = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySQLConn.establishConn();
			String stmt = "Select Topicname from USER_TOPICS";
			
			ps = conn.prepareStatement(stmt);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String topicName = rs.getString("Topicname");
				topicList.add(topicName);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return topicList;
	}
	
	public String authenticateUser(UserDetails commando) {
		
		String userName = commando.getUserName();
		String password = commando.getPassword();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";
		
		try {
			conn = MySQLConn.establishConn();
			String stmt = "Select Username, Password, Userrole from USER_DETAILS";
			ps = conn.prepareStatement(stmt);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				userNameDB = rs.getString("Username");
				passwordDB = rs.getString("Password");
				roleDB = rs.getString("Userrole");
				
				if(userNameDB.equals(userName) && passwordDB.equals(password)) {
					if(roleDB.equals("admin")) {
						return "Admin_Role";
					}else if(roleDB.equals("commando")) {
						return "Commando_Role";
					}
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "Either UserName or Password is incorrect";
	}
	
	public UserDetails getCommando(UserDetails commando) {
		
		String userName = commando.getUserName();
	    String emailID = "";
	    String phone = "";
	    String password = commando.getPassword();
	    String title = "";
	    String interestedTopic = "";
	    
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	    	conn = MySQLConn.establishConn();
	    	String stmt = "select EmailId, Phone, Title, InterestedTopic from USER_DETAILS where Username=? and Password=?";
	    	ps = conn.prepareStatement(stmt);
	    	ps.setString(1, userName);
	    	ps.setString(2, password);
	    	
	    	rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
	    		emailID = rs.getString("EmailId");
	    		phone = rs.getString("Phone");
	    		title = rs.getString("Title");
	    		interestedTopic = rs.getString("InterestedTopic");
	    		
	    		commando.setEmailID(emailID);
	    		commando.setPhone(phone);
	    		commando.setTitle(title);
	    		commando.setInterestedTopic(interestedTopic);
	    	}
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		
		
		return commando;
	}
}
