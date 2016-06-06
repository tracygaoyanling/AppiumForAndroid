package com.jince.android.tests;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args){
		testa();
	}
	public static String[] testa(){
		Map map = System.getenv();  
		String path = (String) map.get("Path");
		String[] paths = path.split(";");
		String[] nodeAppiumPaths = new String[2];
		String nodePath = null;
		String appiumPath = null;
		String regEx1 = "^*nodejs*";
		String regEx2 = "^*Appium*";
		Pattern pattern1 = Pattern.compile(regEx1);
		Pattern pattern2 = Pattern.compile(regEx2);
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
		nodeAppiumPaths[0] = nodePath;
		nodeAppiumPaths[1] = appiumPath;
		for(int i=0;i<nodeAppiumPaths.length;i++){
			System.out.println(nodeAppiumPaths[i]);
			
		}
		return nodeAppiumPaths;
	}
}
