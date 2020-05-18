package org.app.uport.service;

import java.util.List;

import org.app.uport.beans.Forget_Password;
import org.app.uport.beans.User_Details;
import org.app.uport.beans.User_Login;

public interface IService_Provider {

	String UserCreatetion_SvcProvider(User_Details user_Details);
	User_Details login_SvcProvider(User_Login user_Login);
	User_Details fetch_IdUser_SvcProvider(Long id);
	List<User_Details> fetch_AllUsers_SvcProvider();
	String forgetPassowrd_SvcProvider(Forget_Password forget_Password);
	String deleteUser_SvcProvider(Long id);

	
}
