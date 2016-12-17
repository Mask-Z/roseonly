package com.mask.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mr丶周 on 2016/12/18.
 */
public class PropertiesUtils {
	private static Properties properties;
	/**
	 * 加载属性文件
	 * @param filePath 文件路径
	 * @return
	 */
	public static Properties loadProps(String filePath){
		properties = new Properties();
		try {
//			String path = PropertiesUtils.class.getResource(filePath).getPath();
			InputStream in =new BufferedInputStream(new FileInputStream(filePath));
			properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 读取配置文件
	 * @param
	 * @param key
	 * @return
	 */
	public static String getString(Properties properties,String key){
		return properties.getProperty(key);
	}

	/**
	 * 更新配置文件
	 * @param
	 * @param
	 * @return
	 */
	public static void updatePropertyLoginError(Properties properties,String filePath,String keyname,String keyvalue) {
		try {
			properties.setProperty(keyname, keyvalue);
			String path = PropertiesUtils.class.getResource(filePath).getPath();
			FileOutputStream outputFile = new FileOutputStream(path);
			properties.store(outputFile, "modify");
			outputFile.flush();
			outputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}}