package cn.mandroid.wtshanxun.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单数据缓存工具类
 * 
 * @author Administrator
 * 
 */
public class Preference {

	public static String USER_VERIFIED="userVerified";
	private final String SHARED_PREFERENCE_NAME = "cn.mandroid.Shanxun";
	private static Preference catche;
	// private static Preference catcheWithName;
	private static Map<String, Preference> Premap = new HashMap<String, Preference>();
	private SharedPreferences spf;
	public static String ROUTER_TYPE = "routerType1";
	public static String ROUTER_ACC = "routerAcc";
	public static String ROUTER_IP = "routerIp";
	public static String ROUTER_PASS = "routerPass";
	public static String SX_PASS = "sxPass";
	public static String FIRSTRUN = "firstRun";
	public  static  String AUTO_GET_PASSWORD="autoGetPassword";
	public static String SEND_HEART="sendHeart";
	public static String SMSDATE="smsDate";
	public static String SX_USER = "sxUser";
	public static String SESSION_ID = "sessionId";
	public static Preference instance(Context context) {
		if (catche == null) {
			catche = new Preference(context);
		}
		return catche;
	}

	public static Preference instance(Context context, String name) {
		if (!Premap.containsKey(name)) {
			Premap.put(name, new Preference(context, name));
		}
		return Premap.get(name);
	}

	public Preference(Context context) {
		spf = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
				Context.MODE_PRIVATE);
	}

	public Preference(Context context, String name) {
		spf = context.getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	public void putBoolean(String key, boolean value) {
		spf.edit().putBoolean(key, value).commit();
	}

	public boolean getBoolean(String key) {
		return spf.getBoolean(key, false);
	}

	public void putString(String key, String value) {
		spf.edit().putString(key, value).commit();
	}

	public String getString(String key) {
		return spf.getString(key, "");
	}

	public void putInt(String key, int value) {
		spf.edit().putInt(key, value).commit();
	}

	public void putLong(String key, long value) {
		spf.edit().putLong(key, value).commit();
	}

	public int getInt(String key) {
		return spf.getInt(key, 0);
	}

	public int getInt(String key, int defaultValue) {
		return spf.getInt(key, defaultValue);
	}

	public long getLong(String key) {
		return spf.getLong(key, 0);
	}

	public long getLong(String key, long def) {
		return spf.getLong(key, def);
	}

	public void clearData() {
		spf.edit().clear().commit();
	}

	public void remove(String key) {
		spf.edit().remove(key).commit();
	}

	public void commit() {
		spf.edit().commit();
	}

}
