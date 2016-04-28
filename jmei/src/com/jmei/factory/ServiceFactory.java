package com.jmei.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;  

public abstract class  ServiceFactory {
	private static Properties pro = new Properties();
	private static String className;
	static{
		try {
			String path = ServiceFactory.class.getResource("").getPath()+"/service.properties";
			InputStream is = new FileInputStream(path);
			pro.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static Object newInstance(String key){
		 className = (String) pro.get(key);
		 //通过反射创建对象    new UserDAOImpl()
		 try {
			return Class.forName(className).newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	 }
}
