package com.jince.android.utility;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 功能：查找本机的Appium.js和node.exe路径
 * 作者：Make
 */
public class InitEnvPaths {

	public static String[] FindEnvPaths(){
		Map<String, String> map = System.getenv();  
		String path = (String) map.get("Path");
		String[] paths = path.split(";");
		String[] nodeAppiumPaths = new String[2];
		String nodePath = null;
		String appiumPath = null;
		String regEx1 = "^*nodejs*";
		String regEx2 = "^*appium*";
		Pattern pattern1 = Pattern.compile(regEx1,Pattern.CASE_INSENSITIVE);
		Pattern pattern2 = Pattern.compile(regEx2,Pattern.CASE_INSENSITIVE);
		for(int i=0;i<paths.length;i++){
			Matcher matcher1 = pattern1.matcher(paths[i]);
			Matcher matcher2 = pattern2.matcher(paths[i]);
			if(matcher1.find()){
				nodePath=paths[i]+"node.exe";
				nodePath = nodePath.replaceAll("\\\\", "\\\\\\\\");
			}else if(matcher2.find()){
				appiumPath= paths[i].substring(0, paths[i].indexOf("."))+"appium\\bin\\appium.js";
				appiumPath = appiumPath.replaceAll("\\\\", "\\\\\\\\");
			}
		}
		System.out.println("Node Path is "+nodePath);
		System.out.println("Appium Path is "+appiumPath);
		if(nodePath==null||appiumPath==null){
			ConPrint.warn("Can not find paths in ENV_PATHS,Please make sure that node and "
					+ "appium was installed on your PC!");
		}else{
			nodeAppiumPaths[0] = nodePath;
			nodeAppiumPaths[1] = appiumPath;
		}
		return nodeAppiumPaths;
	}
}
