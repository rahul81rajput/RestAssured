package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	@DataProvider (name="dp")
	public  Object[][] data() throws IOException {
	
	int row=xlUtilities.getRowCount("UserData");
	int col=xlUtilities.getCellCount("Userdata", 1);
	Object [][]arr=new Object[row-1][col];
			for(int i=1;i<row;i++) {
		for(int j=0;j<col;j++) {
			arr[i-1][j]=xlUtilities.getCellData("UserData", i, j);
		}
	}
	
	return arr;
	}

}
