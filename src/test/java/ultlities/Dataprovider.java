package ultlities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider (name ="LoginData")
	public String[][]  getData () throws IOException {
		String path =".\\testdata\\opencart_logindata.xlsx";
		ExcelUltility xlutil = new ExcelUltility(path);
		int totalrows=xlutil.getrowcount("sheet1");
	int totalcols=	xlutil.getcellcount("sheet1", 1);
	String logindata [][]	= new String [totalrows] [totalcols];	
	for (int i =1; i<=totalrows; i++) {
		for (int j=0; j<totalcols; j++) {
			logindata [i-1][j] = xlutil.getCellData("sheet1", i, j);
			return logindata;
		}
	}
	return logindata;
	
	}

}
