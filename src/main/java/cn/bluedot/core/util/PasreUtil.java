package cn.bluedot.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class PasreUtil {
	public static String[] decodeID(String ID) {

		return new String(ID.replace("\n", "")).split(":");
	}
}