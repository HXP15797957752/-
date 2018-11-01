package cn.bluedot.core.service;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RequestWare {
	Map req_rep ;

	public Map getReq_rep() {
		return req_rep;
	}

	public void setReq_rep(Map req_rep) {
		this.req_rep = req_rep;
	}
	/*
	*获取参数封装到map
	*/
	public Map getMap() {
		HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
		String classAtrrName = request.getParameter("formName");
		String classValue = request.getParameter("formVal");
		String className = request.getParameter("className");
		classAtrrName = classAtrrName.substring(0, classAtrrName.length()-1);
		classValue  = classValue .substring(0, classValue.length()-1);
		String[] arrAtrrNames = classAtrrName.split(",");
		String[] classValues  = classValue.split(",");
		for(int i=0;i<classValues.length;i++) {
			System.out.print(classValues[i]+"  ");
		}
		System.out.println(arrAtrrNames.length +"  "+classValues.length);
		Map map = new LinkedHashMap<>();
	/*	String  relclassName = "cn.bluedot.core.domain."+className;*/
		for(int i = 0; i < arrAtrrNames.length;i++) {
			map.put(arrAtrrNames[i], classValues[i]);
		}
		return map;
	}
}
