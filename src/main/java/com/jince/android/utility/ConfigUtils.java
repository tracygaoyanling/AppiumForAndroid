package com.jince.android.utility;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
import com.jince.android.util.ConPrint;
import com.jince.android.config.UIConfig;

public class ConfigUtils {
	public static void main(String[] args){
		//Properties pro = ConfigUtils.getProperties(UIConfig.class, "mainConfig.properties");
		autowireConfig(UIConfig.class,"mainConfig.properties");
//		System.out.println("Message "+pro);
//		System.out.println("Path "+pro1);
	}
	public static Properties getProperties(@SuppressWarnings("rawtypes") Class clazz,String filename){
		InputStream in =null;
		try{
			Properties pros = new Properties();
			in = clazz.getClassLoader().getResourceAsStream(filename);
			pros.load(in);
			return pros;
		}catch(Exception e){
			ConPrint.error("Error thing to load config file. "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(in!=null){
					in.close();
				}
			}catch(IOException e){
				
			}		
		}
		return null;	
	}
	@SuppressWarnings("rawtypes")
	public static void autowireConfig(Class clazz,String file){
		System.out.println(UIConfig.phone);
		System.out.println(UIConfig.password);
		System.out.println(UIConfig.test);
		Properties pros = getProperties(clazz,file);
		System.out.println("Pros " +pros);
		if(pros == null){
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields){
			if(Modifier.isStatic(field.getModifiers())){
				field.setAccessible(true);
				String name = field.getName();
				String value = pros.getProperty(name);
				System.out.println("Field " +field);
				System.out.println("Name " +name);
				System.out.println("value " +value);
				if(value==null){
					continue;
				}else{
					Class type = field.getType();
					String typeName =type.getName();
//					System.out.println("Type " +type);
//					System.out.println("typeName " +typeName);
					try{
						if(typeName.equals("int")){
							field.set(clazz, Integer.valueOf(value));	
						}else if(typeName.equals("long")){
							field.set(clazz, Long.valueOf(value));
						}else if(typeName.equals("boolean")){
							field.set(clazz, Boolean.valueOf(value));
						}else{
							field.set(clazz, value);
						}	
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
				System.out.println(UIConfig.phone);
				System.out.println(UIConfig.password);
				System.out.println(UIConfig.test);
			}
		}
	}
}
