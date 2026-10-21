package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {

	// Created for CRUD operations
	
	                // Create User
	public static Response createUser(User payload){
		Response res=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().post(Routes.Post_Url);
		return res;
	}
	
	               //Get User
public static Response getUser(String userName){
		Response res=given().pathParam("username", userName)
		.when().get(Routes.Get_Url);
		return res;
	}

             //Put User
public static Response putUser(User payload , String userName){
	Response res=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).pathParam("username", userName)
	.when().put(Routes.Put_Url);
	return res;
}
	
	           //  Delete User
	public static Response dUser(String userName){	
		Response res=given().pathParam("username", userName)
		.when().delete(Routes.Delete_Url);
		return res;
}

	
	
	
	
	
}
