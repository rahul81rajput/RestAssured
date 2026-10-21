package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	User up;
	Faker f;
@BeforeClass
	void payload() {
		 f =new Faker();
		up=new User();
		
		up.setId(f.idNumber().hashCode());
		up.setEmail(f.internet().emailAddress());
		up.setUsername(f.name().username());
		up.setFirstName(f.name().firstName());
		up.setLastName(f.name().lastName());
		up.setPassword(f.internet().password());
		up.setPhone(f.phoneNumber().cellPhone());	
	}
	
@Test
       void create() {
    	   
	        Response res = UserEndPoints.createUser(up);
	        res.then().log().all();
	      Assert.assertEquals(res.getStatusCode(), 200);
       }
@Test
     void get() {
    	 Response res = UserEndPoints.getUser(this.up.getUsername());
    	 res.then().log().all().statusCode(200);
    	 
    	 
     }

@Test
    void setUser() {
    	up.setId(f.idNumber().hashCode());
		up.setEmail(f.internet().emailAddress());
    	Response res = UserEndPoints.putUser( up,this.up.getUsername());
    	res.then().log().all().statusCode(200);
    }

@Test (priority=4)
void delete() {
	Response res = UserEndPoints.dUser(this.up.getUsername());
	res.then().log().all().statusCode(200);
}
	
}
