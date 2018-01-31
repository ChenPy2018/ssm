package auto;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AutoService {

	public static void createInterface(){
		String interfile="I"+AutoUtil.SMALLBEAN+"Service.java";
		File servicePath=new File(AutoUtil.SERVICEPATH+"\\"+AutoUtil.SMALLBEAN);
		if(!servicePath.exists()){
			servicePath.mkdirs();
		}
		File inter=new File(servicePath,interfile);
		if(inter.exists()){
			System.out.println("service接口文件已经存在");
		}else{
			try {
				inter.createNewFile();
				System.out.println("service接口文件创建完成");
				File interpath=new File(AutoUtil.TMP,AutoUtil.SERVICEINTERFILE);
				String str = FileUtils.readFileToString(interpath, "utf-8");
				String result = str.replaceAll("\\[Bean\\]", AutoUtil.BEAN)
						.replaceAll("\\[bean\\]", AutoUtil.SMALLBEAN);
				FileUtils.writeStringToFile(inter, result,"utf-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void createImpl(){
		String interfile=AutoUtil.BEAN+"serviceImpl.java";
		File servicePath = new File(AutoUtil.SERVICEPATH+"\\"+AutoUtil.SMALLBEAN);
		if(!servicePath.exists()){
			servicePath.mkdirs();
		}
		File inter = new File(servicePath, interfile);
		if(inter.exists()){
			System.out.println("service实现类已经存在");
		}else{
			try {
				inter.createNewFile();
				System.out.println("service实现类创建完成");
				File interpath = new File(AutoUtil.TMP, AutoUtil.SERVICEIMPLFILE);
				String str = FileUtils.readFileToString(interpath, "utf-8");
				String result = str.replaceAll("\\[Bean\\]", AutoUtil.BEAN)
						.replaceAll("\\[bean\\]", AutoUtil.SMALLBEAN);
				FileUtils.writeStringToFile(inter, result, "utf-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
