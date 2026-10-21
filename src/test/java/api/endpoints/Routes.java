package api.endpoints;

public class Routes {

	// Base URI =   petstore.swagger.io/v2
	//  Post   =    petstore.swagger.io/v2/user
	//  Get     =   petstore.swagger.io/v2/user/{username}
	//  Put         petstore.swagger.io/v2/user/{username}
	//  Delete      petstore.swagger.io/v2user/{username}
	
	  public static String Base_Url="https://petstore.swagger.io/v2";
	  
	  
	  public static String Post_Url   =     Base_Url+"/user";
	  public static String Get_Url    =       Base_Url+"/user/{username}";
	  public static String Put_Url     =     Base_Url+"/user/{username}";
	  public static String Delete_Url  =       Base_Url+"/user/{username}";
	  
	  
	
}
