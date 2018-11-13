package cn.bluedot.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {
	public static String[] decodeID(String ID) {

		final Base64.Decoder decoder = Base64.getDecoder();
		// 解码
		try {
			return new String(decoder.decode(ID), "UTF-8").replace("\n", "").split(":");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encode(String string){
	    if(string == null){
	        return null;
	    }
	    return new sun.misc.BASE64Encoder().encode(string.getBytes());
	}
}