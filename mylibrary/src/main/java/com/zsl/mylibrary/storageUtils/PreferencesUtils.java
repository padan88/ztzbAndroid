package com.zsl.mylibrary.storageUtils;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * 
 * 类名:PreferencesUtils<br/>
 * 描述:Preference工具类<br/>
 * 发布版本号:1.0<br/>
 * 开发人员:赵三龙<br/>
 * 创建时间:2020年8月20日
 */
public class PreferencesUtils {

	public static String PREFERENCE_NAME = "AppSettings.PREFERENCE_NAME";

	public static boolean putString(Context context, String key, String value) {
		if (context == null || key == null || value == null) {
			return false;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		return editor.commit();
	}

	public static String getString(Context context, String key) {
		return getString(context, key, null);
	}

	public static String getString(Context context, String key, String defaultValue) {
		if (context == null || key == null) {
			return null;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getString(key, defaultValue);
	}

	public static boolean putInt(Context context, String key, int value) {
		if (context == null || key == null) {
			return false;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		return editor.commit();
	}

	public static int getInt(Context context, String key) {
		return getInt(context, key, -1);
	}

	public static int getInt(Context context, String key, int defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getInt(key, defaultValue);
	}

	public static boolean putLong(Context context, String key, long value) {
		if (context == null || key == null) {
			return false;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putLong(key, value);
		return editor.commit();
	}

	public static long getLong(Context context, String key) {
		return getLong(context, key, -1);
	}

	public static long getLong(Context context, String key, long defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getLong(key, defaultValue);
	}

	public static boolean putFloat(Context context, String key, float value) {
		if (context == null || key == null) {
			return false;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat(key, value);
		return editor.commit();
	}

	public static float getFloat(Context context, String key) {
		return getFloat(context, key, -1);
	}

	public static float getFloat(Context context, String key, float defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getFloat(key, defaultValue);
	}

	public static boolean putBoolean(Context context, String key, boolean value) {
		if (context == null || key == null) {
			return false;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	public static boolean getBoolean(Context context, String key) {
		return getBoolean(context, key, false);
	}

	public static boolean getBoolean(Context context, String key, boolean defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		return settings.getBoolean(key, defaultValue);
	}
}
