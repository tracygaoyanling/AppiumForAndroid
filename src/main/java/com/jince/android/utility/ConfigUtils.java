package com.jince.android.utility;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
/*
 * 功能：读取属性文件，并把属性文件的值赋值给配置文件中的参数
 * 作者：Make
 */
public class ConfigUtils {
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
		Properties pros = getProperties(clazz,file);
		if(pros == null){
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields){
			if(Modifier.isStatic(field.getModifiers())){
				field.setAccessible(true);
				String name = field.getName();
				String value = pros.getProperty(name);
				if(value==null){
					continue;
				}else{
					Class type = field.getType();
					String typeName =type.getName();
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
			}
		}
	}
}
