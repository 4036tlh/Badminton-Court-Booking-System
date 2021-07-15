package model;

public class user {
	private static String userId;
	private static String userName;
	private static String password;
	 
	
    public static String getUserName() {
		return userName;
	}


	public static void setUserName(String userName) {
		user.userName = userName;
	}


	public static String getPassword() {
		return password;
	}


	public static void setPassword(String password) {
		user.password = password;
	}


	public String getId() {
		return userId;
	}


	public void setId(String id) {
		userId = id;
	}
	
}
