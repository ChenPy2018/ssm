package auto;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import util.Column;
import util.ID;
import util.Table;

public class AutoDao {
	public static void createInterface(){
		 String interfile=AutoUtil.BEAN+"Dao.java";
		 File daopath=new File(AutoUtil.DAOPATH);
		 File inter = new File(daopath, interfile);
		 if(inter.exists()){
			 System.out.println("dao接口文件已经存在");
		 }else{
			 try {
				inter.createNewFile();
				System.out.println("接口文件生成成功");
				File interpath=new File(AutoUtil.TMP,AutoUtil.DAOINTERFILE);
				String str = FileUtils.readFileToString(interpath,"utf-8");
				String result = str.replaceAll("\\[Bean\\]", AutoUtil.BEAN)
						.replaceAll("\\[bean\\]", AutoUtil.SMALLBEAN);
				FileUtils.writeStringToFile(inter, result,"utf-8");
			 } catch (IOException e) {
				e.printStackTrace();
			}
		 }		 
	} 
	
	
	public static void createMapper(){
		String interfile=AutoUtil.BEAN+"Dao.xml";
		File daopath=new File(AutoUtil.MAPPERPATH);
		File inter=new File(daopath, interfile);
		String tableName=AutoUtil.SMALLBEAN;
		StringBuilder resultMap=new StringBuilder();
		List<String> fieldList=new ArrayList<>();
		StringBuilder insertField=new StringBuilder();
		StringBuilder insertValue=new StringBuilder();
		StringBuilder updateField=new StringBuilder();
		if(inter.exists()){
			System.out.println("Mapper文件已经存在");
		}else{
			try {
				inter.createNewFile();
				System.out.println("mapper文件创建完成");
				Class clz = Class.forName(AutoUtil.PACK+"."+AutoUtil.BEAN);
				Annotation ann = clz.getDeclaredAnnotation(Table.class);
				if(ann!=null){
					Table table=(Table)ann;
					tableName=table.value();
				}
				Field[]  fields=clz.getDeclaredFields();
				for (Field field : fields) {
					String columnName=field.getName();
					Column column=field.getDeclaredAnnotation(Column.class);
					if(column!=null){
						columnName=column.value();
					}
					resultMap.append("<result column=\""+columnName+"\" property=\""+field.getName()+"\"></result>\n");
					fieldList.add(columnName);
					ID id=field.getDeclaredAnnotation(ID.class);
					if(id==null){
						insertField.append("<if test=\""+field.getName()+"!=null\">\n");
						insertField.append(columnName+",\n");
						insertField.append("</if>\n");
						insertValue.append("<if test=\""+field.getName()+"!=null\">\n");
						insertValue.append("#{"+field.getName()+"},\n");
						insertValue.append("</if>\n");
						updateField.append("<if test=\""+field.getName()+"!=null\">\n");
						updateField.append(columnName+"=#{"+field.getName()+"},\n");
						updateField.append("</if>\n");
					}
					
				}
				File interpath=new File(AutoUtil.TMP, AutoUtil.MAPPERFILE);
				String str= FileUtils.readFileToString(interpath, "UTF-8");
				String result = str.replaceAll("\\[Bean\\]", AutoUtil.BEAN)
					.replaceAll("\\[bean\\]", AutoUtil.SMALLBEAN)
					.replaceAll("\\[resultMap\\]", resultMap.toString())
					.replaceAll("\\[table\\]", tableName)
					.replaceAll("\\[field\\]", fieldList.toString().replaceAll("\\[", "").replaceAll("\\]", ""))
					.replaceAll("\\[insertField\\]", insertField.toString())
					.replaceAll("\\[insertValue\\]", insertValue.toString())
					.replaceAll("\\[updateField\\]", updateField.toString());
				FileUtils.writeStringToFile(inter, result, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
}
