package com.Wonderwe.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;

public class ReadConfig {
Properties pro;
	
	
	
	public  ReadConfig()
	{
		File src= new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
			
		}
		
	}
	
		public String getApplicationurl()
		{		String url=pro.getProperty("url");
			return url;
			
		}
		
		public String getusername()
		{
			String username=pro.getProperty("usename");
			return username;
		}
		
		public String getpassword()
		{
			String password=pro.getProperty("password");
			return password;
		}

}
