package com.mask.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * Created by Mr丶周 on 2016/12/18.
 */
public class MyControl extends ResourceBundle.Control {
	// 存在此变量的配置文件名字将执行一次更新
	private final static List<String> needsReloadBaseNameArray = new ArrayList<String>();
	// 配置文件控制器
	private static MyControl myControl;

	private MyControl() {
	}

	public synchronized static MyControl getControl() {
		if (myControl == null) {
			myControl = new MyControl();
		}
		return myControl;
	}

	/**
	 * 检查间隔(对符合条件的对象立即更新)
	 */
	@Override
	public long getTimeToLive(String baseName, Locale locale) {
		return 0;
	}

	/**
	 * 是否需要重新加载的判断函数
	 * overriding方法
	 *
	 */
	@Override
	public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
		boolean needsReload = false;
		if (needsReloadBaseNameArray.size() > 0) {
			// 检查需要更新的队列是否有此次读取的内容
			for (String needsReloadBaseName : needsReloadBaseNameArray) {
				if (needsReloadBaseName.equals(baseName)) {
					// 需要更新
					needsReload = true;
					// 更新一次从队列中移出
					needsReloadBaseNameArray.remove(needsReloadBaseName);
					break;
				}
			}
		}
		return needsReload;
	}

	/**
	 * 添加需要更新的配置
	 *
	 */
	public static void addNeedsReloadBaseName(String baseName) {
		needsReloadBaseNameArray.add(baseName);
	}
}

//现在就可以控制是否对配置文件进行重加载了：
//public class GetProperties {
//	/**
//	 * 得到配置文件中key对应值
//	 *
//	 * @param key
//	 * @param name 不包含后缀名的名字
//	 * @return String
//	 */
//	public static String getValue(String key, String name) {
//		ResourceBundle myResources = ResourceBundle.getBundle(name, MyControl.getControl());
//		// ........中间省略
//		return value;
//	}
//
//	/**
//	 * 设置并更新配置文件
//	 * @author: slzs
//	 * Nov 2, 2011 11:09:39 AM
//	 * @param key 键
//	 * @param value 值
//	 * @param path 物理路径
//	 * @param baseName 部署路径  www.it165.net
//	 * 每位工程师都有保持代码优雅的义务
//	 * each engineer has a duty to keep the code elegant
//	 */
//	public static void setProperties(String key, String value, String path, String baseName) {
//		// ...中间写入省略
//		// 将baseName设置更新读取，下次读取时就会读取最新数据
//		myControl.addNeedsReloadBaseName(baseName);
//		ResourceBundle.getBundle(rootPath + baseName, MyControl.getControl());
//	}
//}

