package com.ax.recyclerviewdemo;

import android.app.Application;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by VERTU on 2018/4/29.
 */

public class ContextUtils {
	public static Application getApplication(){
		Application application = null;
		try {
			application = (Application) Class.forName("android.app.AppGlobals")
					.getMethod("getInitialApplication").invoke(null, (Object[]) null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return application;
	}
}
