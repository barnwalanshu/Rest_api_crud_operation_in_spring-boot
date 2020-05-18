package org.app.uport.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.app.uport.beans.Forget_Password;
import org.app.uport.beans.User_Details;
import org.app.uport.beans.User_Login;
import org.app.uport.entity.User_Detail_Entity;
import org.app.uport.repository.User_Details_Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Provider implements IService_Provider {

	private static Logger logger  = LogManager.getLogger(Service_Provider.class);

	@Autowired
	User_Details_Repos user_Details_Repository ;

	@Override
	public String UserCreatetion_SvcProvider(User_Details user_Details)
	{
		System.out.println("value to be insert "+user_Details);
		User_Detail_Entity user_Detail_Entity = new User_Detail_Entity() ;

		if(user_Details_Repository.existsById(user_Details.getId()))
		{
			System.out.println("User id already registered ,cannot create with existed id .");
			logger.error("Tried to create new user but User id already registered into our DB  ");

			return "This user id already exist, kindly register with new id " ;
		}else {
			user_Detail_Entity.setId(user_Details.getId());
			user_Detail_Entity.setEmail_id(user_Details.getEmail_id());
			user_Detail_Entity.setName(user_Details.getName());
			user_Detail_Entity.setPassword(user_Details.getPassword());
			user_Detail_Entity.setPhone_number(user_Details.getPhone_number());
			user_Detail_Entity.setDate_of_birth(user_Details.getDate_of_birth());
			user_Detail_Entity.setAddress(user_Details.getAddress());
			user_Detail_Entity.setGender(user_Details.getGender());

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user_Detail_Entity.setUpdated_at(timestamp);

			user_Details_Repository.save(user_Detail_Entity);

			System.out.println("Inserted value in the Table :- "+user_Detail_Entity.toString());
			logger.info("New User Created for the id :- "+user_Details.getId());

			return "Value Inserted for the id :- "+user_Details.getId() ;
		}
	}

	@Override
	public User_Details login_SvcProvider(User_Login user_Login)
	{
		System.out.println(user_Login);
		User_Detail_Entity user_detail_Entity = user_Details_Repository.findAllById(user_Login.getId());

		User_Details user_Details = new User_Details();
		if(user_detail_Entity != null && user_Login.getPassword().equals(user_detail_Entity.getPassword()))
		{
			user_Details.setId(user_detail_Entity.getId());
			user_Details.setName(user_detail_Entity.getName());
			user_Details.setEmail_id(user_detail_Entity.getEmail_id());
			user_Details.setPassword(user_detail_Entity.getPassword());
			user_Details.setPhone_number(user_detail_Entity.getPhone_number());
			user_Details.setDate_of_birth(user_detail_Entity.getDate_of_birth());
			user_Details.setAddress(user_detail_Entity.getAddress());
			user_Details.setGender(user_detail_Entity.getGender());
			user_Details.setUpdated_at(user_detail_Entity.getUpdated_at());

			System.out.println("Login success with user id :- "+user_detail_Entity.getId());
			logger.info("Login Success with id :- "+user_Login.getId());

			return  user_Details ;
		}else {
			System.out.println("Login attempted failed with userid :- " +user_Login.getId());
			logger .error("login failure with id :- "+user_Login.getId());

			return user_Details ;
		}		
	}

	@Override
	public User_Details fetch_IdUser_SvcProvider(Long id)
	{
		System.out.println("Fetching the detail for the id :- "+ id);
		User_Detail_Entity user_entity = user_Details_Repository.findAllById(id) ;
		System.out.println(user_entity);
		if(user_entity!=null){
			User_Details user_Details = new User_Details();

			user_Details.setId(user_entity.getId());
			user_Details.setEmail_id(user_entity.getEmail_id());
			user_Details.setName(user_entity.getName());
			user_Details.setPassword(user_entity.getPassword());
			user_Details.setPhone_number(user_entity.getPhone_number());
			user_Details.setDate_of_birth(user_entity.getDate_of_birth());
			user_Details.setAddress(user_entity.getAddress());
			user_Details.setGender(user_entity.getGender());
			user_Details.setUpdated_at(user_entity.getUpdated_at());

			logger.info("Detail retrieved by user id :- "+id);

			return  user_Details;
		}else
			logger.error("User retrieval failed, Detail not Available for the id :- "+ id);

		return null ;

	}

	@Override
	public List<User_Details> fetch_AllUsers_SvcProvider(){

		List<User_Details> user_DetailsList = new ArrayList<User_Details>();
		List<User_Detail_Entity> user_Entities_List = user_Details_Repository.findAll();

		System.out.println("Fetching all the details.............");
		for (User_Detail_Entity user_Detail_Entity : user_Entities_List) {			
			User_Details user_Details = new User_Details();

			user_Details.setId(user_Detail_Entity.getId());
			user_Details.setEmail_id(user_Detail_Entity.getEmail_id());
			user_Details.setName(user_Detail_Entity.getName());
			user_Details.setPassword(user_Detail_Entity.getPassword());
			user_Details.setPhone_number(user_Detail_Entity.getPhone_number());
			user_Details.setDate_of_birth(user_Detail_Entity.getDate_of_birth());
			user_Details.setAddress(user_Detail_Entity.getAddress());
			user_Details.setGender(user_Detail_Entity.getGender());
			user_Details.setUpdated_at(user_Detail_Entity.getUpdated_at());

			user_DetailsList.add(user_Details);
		}
		System.out.println("Details of all the users :- "+user_DetailsList);
		logger.info("Detail of all Users fetched ........");

		return  user_DetailsList ;
	}


	@Override
	public String forgetPassowrd_SvcProvider(Forget_Password forget_Password)
	{
		if(!(forget_Password.getNewpassword()).equals(forget_Password.getConfirmpassword())) {
			System.out.println("Both entered password should be same .");
			logger.info("setting of new password failed ......");

			return  "Error occured, Both password fields should be same . " ; 
		}
		System.out.println("Process started for setting new password....");
		System.out.println(forget_Password);

		User_Detail_Entity user_Detail_Entity = user_Details_Repository.findAllById(forget_Password.getId());

		System.out.println("User's DB Detail :- id : "+user_Detail_Entity.getId()+" Email_id : "+user_Detail_Entity.getEmail_id()+" Date_of_birth : "+user_Detail_Entity.getDate_of_birth());
		System.out.println("User's entered Detail :- id : "+forget_Password.getId()+" Email_id : "+forget_Password.getEmail_id()+" Date_of_birth : "+forget_Password.getDate_of_birth());

		if(user_Detail_Entity.getId().equals(forget_Password.getId()) && user_Detail_Entity.getEmail_id().equals(forget_Password.getEmail_id()) 
				&& user_Detail_Entity.getDate_of_birth().equals(forget_Password.getDate_of_birth()))
		{
			System.out.println("condition passed........");
			user_Detail_Entity.setPassword(forget_Password.getConfirmpassword());
			user_Details_Repository.save(user_Detail_Entity);
			System.out.println("password changed ");
			logger.info("password changed successfully for the id :- "+forget_Password.getId());

			return "password changed ." ;
		}else
			System.out.println("condition failed .....");
		logger.fatal("wrong credentials passed in forget password activity process with id :- "+forget_Password.getId());

		return "Error occured while changing password ." ; 
	}

	@Override
	public String deleteUser_SvcProvider(Long id)
	{
		if(user_Details_Repository.existsById(id)) {  
			user_Details_Repository.deleteById(id);
			System.out.println("Successfully deleted the id :- "+ id);
			logger.info("seccessfully deleted the details for the id :- " + id);

			return "Successfully deleted the id....:- "+id; 
		}else {
			System.out.println(" : This id does not Exist..:- "+id);
			logger.info("Tried to delete the details for the id which doesnot exist into DB ");

			return " Id does not exist... :- "+id ;
		}
	}
}
