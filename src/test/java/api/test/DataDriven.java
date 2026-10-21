package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDriven {
@Test  (dataProvider="dp" ,dataProviderClass= api.utilities.DataProviders.class)
	void datadriven(String username,String firstname,String lastname,String email,String pass,String phone,String status) {
	Logger logger = LogManager.getLogger(this.getClass());
	User up=new User(); 
	up.setUsername(username); logger.info("Username enter");
	up.setFirstName(firstname);logger.info("Firstname enter");
	up.setLastName(lastname); logger.info("LastName");
	up.setEmail(email);logger.info("Email entered");
	up.setPassword(pass);logger.info("Pass entered");
	up.setEmail(phone);logger.info("phone");
	up.setUserStatus(0);
	
	Response res = UserEndPoints.createUser(up);
	Assert.assertEquals(res.statusCode(), 200);
	
	}
	
	
	
}
