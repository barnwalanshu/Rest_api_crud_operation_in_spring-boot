package org.app.uport.controller;

import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.app.uport.beans.Forget_Password;
import org.app.uport.beans.User_Details;
import org.app.uport.beans.User_Login;
import org.app.uport.repository.User_Details_Repos;
import org.app.uport.service.IService_Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 * 
 * @author ANSHU
 *
 */

@RestController
public class User_Controller {

	private static final Logger logger = LogManager.getLogger(User_Controller.class) ;

	@Autowired
	User_Details_Repos user_Details_Repository ;

	@Autowired
	IService_Provider service_Provider ;


	// 1. Create one new User by entering all the details .
	@RequestMapping(value="/uport/createuser",method=RequestMethod.POST, consumes= {MediaType.TEXT_PLAIN_VALUE, 
			MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> userCreation(@RequestBody User_Details user_Details)
	{

		System.out.println("Creating process started............");
		String response = service_Provider.UserCreatetion_SvcProvider(user_Details);
		return new ResponseEntity<String>(response,HttpStatus.OK) ;
	}

	// 2. By entering the user id and password , user can access and get all the detail 
	@RequestMapping(value="/uport/userLogin",method=RequestMethod.POST, consumes= {MediaType.TEXT_PLAIN_VALUE, 
			MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User_Details> loginUser(@RequestBody User_Login user_Login)
	{

		User_Details response = service_Provider.login_SvcProvider(user_Login);
		return new ResponseEntity<User_Details>(response,HttpStatus.OK);
	}

	// 3. Get all the  detail for the user id passed by user
	@RequestMapping(value="/uport/getuser/{id}", method=RequestMethod.GET)
	public ResponseEntity<User_Details> getUserDetailById(@PathVariable("id") Long id){

		User_Details userdetail = service_Provider.fetch_IdUser_SvcProvider(id);
		return new ResponseEntity<User_Details>(userdetail, HttpStatus.OK) ;
	}

	// 4. Get all the User Details from DataBase
	@RequestMapping(value="/uport/getAllusers",method=RequestMethod.GET)
	public ResponseEntity<List<User_Details>> getAllUsers()
	{

		List<User_Details> user_DetailsList = service_Provider.fetch_AllUsers_SvcProvider() ;
		return new ResponseEntity<List<User_Details>>(user_DetailsList,HttpStatus.OK);
	}

	// 5. In case of forget the password ,user can set the new password by entering the credentials .
	@RequestMapping(value="/uport/forgotpswd", method = RequestMethod.POST, consumes = {MediaType.TEXT_PLAIN_VALUE, 
			MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> forgotPassword(@RequestBody Forget_Password forget_Password){

		String resp = service_Provider.forgetPassowrd_SvcProvider(forget_Password) ;
		return new ResponseEntity<String>(resp,HttpStatus.OK);
	}

	// 6. delete the user detail of passed id  .
	@RequestMapping(value="/uport/deleteUser/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserId(@PathVariable("id") Long id)
	{
		String resp = service_Provider.deleteUser_SvcProvider(id);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	//-------for testing purpose ....
	@RequestMapping(value="/uport/gettime", method = RequestMethod.GET)
	public String getAll() {

		logger.info("printing the current time .........");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		//return "Getting values on UI pages ............. " ;
		return "Executed at time :- "+timestamp ;

	}
}
