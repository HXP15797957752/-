package cn.bluedot.framemarker.util;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author : 游斌平、余聪
 *
 */
public class Tool {
	/**
	 * 获取c3p0-config.xml的配置信息，用来初始化C3p0类
	 */
	  @SuppressWarnings({ "unchecked"})
	public Tool(){
		  	List<String> name=new LinkedList<String>();
			List<String>  value=new LinkedList<String>();
	        SAXReader reader = new SAXReader();
	        InputStream fis = null;
	        try{
	            fis = this.getClass().getResourceAsStream("/c3p0-config.xml");
	            //加载xml文档
	            Document doc = reader.read(fis);
	            //获取根元素
	            Element rootElt = doc.getRootElement();
	            List<Element> elements = rootElt.elements();
	            for(int i=0;i<elements.size();i++){
	                Element elt = elements.get(i);
	                List<Element> subEletList = elt.elements();
	                for(int j=0;j<subEletList.size();j++){
	                    Element subElt = subEletList.get(j);
	                    List<Element> eList=subElt.attributes();
	                    for(int n=0;n<eList.size();n++){
		                    Attribute attr = (Attribute)eList.get(n);
		                   name.add(attr.getValue());
		                }
	                    value.add(subElt.getText());
	                }
	            }
	            for(int i=0;i<name.size();i++) {
	            	if(name.get(i).equals("jdbcUrl")) {
	            		C3po.setJdbcUrl(value.get(i));
	            	}else if(name.get(i).equals("driverClass")) {
	            		C3po.setDriverClass(value.get(i));
	            	}else if(name.get(i).equals("user")) {
	            		C3po.setUser(value.get(i));
	            	}else if(name.get(i).equals("password")) {
	            		C3po.setPassword(value.get(i));
	            	}else if(name.get(i).equals("maxUseCount")) {
	            		C3po.setMaxUseCount(value.get(i));
	            	}else if(name.get(i).equals("initialPoolSize")) {
	            		C3po.setInitialPoolSize(value.get(i));
	            	}else if(name.get(i).equals("minPoolSize")) {
	            		C3po.setMinPoolSize(value.get(i));
	            	}else if(name.get(i).equals("maxPoolSize")) {
	            		C3po.setMaxPoolSize(value.get(i));
	            	}
	            }
	            C3po.Sysout();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            try{
	                if(fis !=null)
	                    fis.close();
	            }catch (Exception e) {
	                e.printStackTrace();
	            }finally{
	                
	            }
	        }
	    }

	}
