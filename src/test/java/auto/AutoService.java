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
			System.out.println("service�ӿ��ļ��Ѿ�����");
		}else{
			try {
				inter.createNewFile();
				System.out.println("service�ӿ��ļ��������");
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
			System.out.println("serviceʵ�����Ѿ�����");
		}else{
			try {
				inter.createNewFile();
				System.out.println("serviceʵ���ഴ�����");
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
