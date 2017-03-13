package sql;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class sqltest {
	public static void main(String[] args){
		
		ylfysql yl=new ylfysql();
	
	String jString=yl.getylfyxx();;
	//病人费用
	//String jString=userzyfymx.getuserfymx("2016003850");
		System.out.print(jString);
		
		
	}
	
}
