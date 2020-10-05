package org.commandodetails.details.bean;


public class UserDetails {

	public static final String STUDY = "S";
    public static final String JOB_HOLDER = "J";
    
    private String userName;
    private String emailID;
    private String phone;
    private String password;
    private String title;
    private String interestedTopic;
    
    private String role;

    
    public UserDetails() {
       
    }
    
    public String getUserName() {
    	return this.userName;
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    
    public String getEmailID() {
    	return this.emailID;
    }
    
    public void setEmailID(String emailID) {
    	this.emailID = emailID;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getInterestedTopic() {
    	return this.interestedTopic;
    }
    
    public void setInterestedTopic(String interestedTopic) {
    	this.interestedTopic = interestedTopic;
    }
    
    public String getRole() {
    	return this.role;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
}
