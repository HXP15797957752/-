package cn.bluedot.core.service;

import java.io.InputStream;
import java.util.Iterator;
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
	
}
