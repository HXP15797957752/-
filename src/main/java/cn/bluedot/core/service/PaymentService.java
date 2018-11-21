package cn.bluedot.core.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import cn.bluedot.core.domain.Payment;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.core.BaseDao;
import cn.bluedot.framemarker.core.SqlResult;
import cn.bluedot.framemarker.dao.SuperDao;
import cn.bluedot.framemarker.dao.Transaction;
import cn.bluedot.framemarker.util.JdbcUtils;
import cn.bluedot.framemarker.util.ResultSetHandler;
import net.sf.json.JSONArray;

/**
 * @author : 游斌平
 *
 */
public class PaymentService extends RequestWare implements Service{
    SuperDao sd = new SuperDao();
    private static final BaseDao bd = new BaseDao();
	/**
	 * 插入支付
	 * UGF5bWVudFNlcnZpY2U6cGF5SW5zZXJ0
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String insertPayInformation(Map data) {
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		try {
			superDao.save(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "a^插入成功";
	}
	/**
	 * 插入支付
	 * UGF5bWVudFNlcnZpY2U6cGF5SW5zZXJ0
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String paymentInsert(Map data) {
		/*Payment payment = MyBeanUtils.toBean(data, Payment.class);
		try {
			superDao.save(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Map<String, String> dataMap = null;
		try {
			dataMap = getMap();
		}catch (Exception e) {
			// TODO: handle exception
			 return "t^数据格式错误";
		}
		 try {
			 Payment payment = (Payment) MyBeanUtils.toBean(dataMap, Payment.class); 
			 System.out.println(payment.toString());
			 String hql = "Payment|paymentID=?";
			 List<Object> vos = superDao.HQLQuery(hql, payment.getPaymentID());
			 if(vos==null||vos.size()==0) {
				 superDao.save(payment);
			 }else {
				 return "t^收款单存在";
			 }
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				return "t^插入失败";
		}
		return "t^插入成功";
	}
	public String paymentUpload(Map data) {
		// 工厂
				DiskFileItemFactory factory = new DiskFileItemFactory(2048*1024, new File("/temp"));
				// 解析器
				ServletFileUpload sfu = new ServletFileUpload(factory);
//				sfu.setFileSizeMax(100 * 1024);//限制单个文件大小为100K
//				sfu.setSizeMax(1024 * 1024);//限制整个表单大小为1M
		HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
		// 解析，得到List
		System.out.println("you");
		System.out.println(request.getParameter("username"));
		// 解析，得到List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(0);
			System.out.println(list);
			System.out.println(fi);
			Map<String,String> map = new HashMap<String,String>();
			for(FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				}
			}
			/*
			 * 1. 得到文件保存的路径
			 */
			String root = request.getSession().getServletContext().getRealPath("/files");
			/*
			 * 2. 生成二层目录
			 *   1). 得到文件名称
			 *   2). 得到hashCode
			 *   3). 转发成16进制
			 *   4). 获取前二个字符用来生成目录
			 */
			String filename = fi.getName();//获取上传的文件名称
			/*
			 * 处理文件名的绝对路径问题
			 */
			System.out.println(filename);
			int index = filename.lastIndexOf("\\");
			if(index != -1) {
				filename = filename.substring(index+1);
			}
			/*
			 * 给文件名称添加uuid前缀，处理文件同名问题
			 */
			String savename = UUID.randomUUID().toString()+ "_" + filename;
			
			/*
			 * 1. 得到hashCode
			 */
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);
			
			/*
			 * 2. 获取hex的前两个字母，与root连接在一起，生成一个完整的路径
			 */
			File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));
			
			/*
			 * 3. 创建目录链
			 */
			dirFile.mkdirs();
			
			/*
			 * 4. 创建目录文件
			 */
			File destFile = new File(dirFile, savename);
			/*
			 * 5. 保存
			 */
			System.out.println(destFile.getAbsolutePath());
			fi.write(destFile);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
			if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
				return "t^您上传的文件超出了2M！";
			}
			return "t^您上传的文件错误！";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "t^您上传错误！";
		}
	    return "t^插入成功";
	}
	
	
	
	public String paymentUpdate(Map data) {
		Map<String, String> dataMap = null;
		try {
			dataMap = getMap();
		}catch (Exception e) {
			// TODO: handle exception
			 return "t^数据格式错误";
		}
		 Payment payment = (Payment) MyBeanUtils.toBean(dataMap, Payment.class); 
		 superDao.update(payment);
		 return "t^更新成功存在";
	}
	
	public String paymentDelete(Map data) {
		Map<String, String> dataMap = null;
		// 取出request
		HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
		Payment payment = new Payment();
		payment.setPaymentID(Integer.parseInt(request.getParameter("ID")));
		System.out.println(payment.toString());
		try {
			superDao.delete(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "t^删除失败";
		}
		return "t^删除成功";
	}
	/**
	 * 删除支付
	 * @param data :传输过来的边界类的数据
	 * @return  执行情况，代表转发页面、数据
	 */
	public String deletePayInformmation(Map data) {
	/*	Payment payment = MyBeanUtils.toBean(data, Payment.class);
		try {
			superDao.delete(payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "a^删除成功";
	}
	/**
	 * 更新支付
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String updatePayInformation(Map data) {
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		superDao.update(payment);
		return "a^更新成功";
	}
	public String paymentSelect(Map data) {
		Map dataMap = null;
		try {
			dataMap = getMap();
		}catch (Exception e) {
			// TODO: handle exception
			 return "t^数据格式错误";
		}
		String paymentSql = getSql("payment",dataMap);
		System.out.println(paymentSql);
		Map<String, Object> viewmap =new LinkedHashMap<>();
		initPayment(viewmap);
		List<Object> vos = null;
		try {
			vos = query(paymentSql, "cn.bluedot.core.domain.Payment", vos);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
             
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        JSONArray View = JSONArray.fromObject(vo);
        System.out.println(View);
        return "a^"+View.toString();
	}
	  public List<Object> query(String sql ,String className , List<Object> list) throws SQLException{    
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs =null;
	        SqlResult sr = null;
	        Class clazz = null;
	        try {          
				clazz = Class.forName(className);
				sr = new SqlResult(sql, list,clazz.newInstance());
	            conn = JdbcUtils.getConnection();
	            Transaction.beginTransaction(); 
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery(); 
	            list = ResultSetHandler.RsToList(rs,sr);
	            Transaction.commitTransaction();
	        }catch(Exception e) {
	           
	            Transaction.rollbackTransaction();
	            e.printStackTrace();
	        }finally {
	            if(conn!=null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        System.out.println(list);
	        return list;
	    }
	/**
	 * @param string
	 * @param dataMap
	 * @return
	 */
	private String getSql(String tableName, Map dataMap) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer, Integer>> entries = dataMap.entrySet().iterator(); 
		String sql = "select * from " + tableName+" where 1=1 ";
		while (entries.hasNext()) { 
		  Map.Entry<Integer, Integer> entry = entries.next(); 
		  sql +=" and " +entry.getKey() +"  like '%"+entry.getValue() +"%'";
		}
		return sql;
	}
	public List<Object> getClassList(String sql ,String className , List<Object> list) {
		Class clazz =null;
		try {
			clazz = Class.forName(className);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
        return null;
	}
	/**
	 * 
	 * 查找支付
     * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String searchPayInformation(Map data) {
		Map<String, Object> viewmap =new LinkedHashMap<>();
		initPayment(viewmap);
		 // 根据map字段参数生成Algorithm查询条件
		Payment payment = MyBeanUtils.toBean(data, Payment.class);
		String hql = "Payment";
		List<Object> vos = superDao.HQLQuery(hql, payment.getPaymentID());
		List<Map> vot = new LinkedList<>() ;
        vot.add(viewmap);
             
        List vo = new LinkedList<>();
        vo.add(vot);
        vo.add(vos);
        JSONArray View = JSONArray.fromObject(vo);
        return "a^"+View.toString();
	}
	 private String comment(Class clazz, Map viewmap){
	        List<BoSuper> vos = new LinkedList<>() ;
	        
	        try {
	            vos.addAll(sd.query(clazz, null));
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            
	            e.printStackTrace();
	        }
	        
	        List<Map> vot = new LinkedList<>() ;
	        vot.add(viewmap);
	             
	        List vo = new LinkedList<>();
	        vo.add(vot);
	        vo.add(vos);
	        
	        JSONArray View = JSONArray.fromObject(vo);
	        return "a^"+View.toString();
	    }
	
	/**
     * 查询支付
     * @param viewmap
     */
    private void initPayment(Map<String, Object> viewmap) {
        viewmap.put("paymentID", "付款单号");
        viewmap.put("paymentType", "付款类型");
        viewmap.put("orderNumber", "物品订单号");
        viewmap.put("money", "金额");
        viewmap.put("serialNumber", "付款流水号");
        viewmap.put("paymentReason", "付款原因");
        viewmap.put("applicant", "订单申请人员");
        viewmap.put("manager", " 处理人员");
        viewmap.put("paymentDate", "付款时间");
    }
	/**
	 * 导入
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String paymentDownloadExcel(Map<String, String[]> data) {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
		response.setContentType("octets/stream");
	    String excelName = "文件名";
	    try {
	      response.addHeader("Content-Disposition", "attachment;filename="+new String(excelName.getBytes("gb2312"), "ISO8859-1" )+".xls");
	      OutputStream out = response.getOutputStream();
	   // 第一步，创建一个webbook，对应一个Excel文件 
	      HSSFWorkbook wb = new HSSFWorkbook();
	      //生成一个表格 
	      HSSFSheet sheet = wb.createSheet(excelName); 
	      // 第三步，在sheet中添加表头第0行
	      HSSFRow row = sheet.createRow(0);
	       
	      // 第四步，创建单元格，并设置值表头 设置表头居中 
	      HSSFCellStyle style = wb.createCellStyle(); 
	      HSSFCell cell = row.createCell(0);
	      cell.setCellStyle(style);
	      wb.write(out);
	      out.flush();
	      out.close();
	      wb.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return null;
	}
	/**
	 * 导出
	 * @param data:传输过来的边界类的数据
	 * @return  :执行情况，代表转发页面、数据
	 */
	public String paymentDownloadPDF(Map<String, String[]> data) {
		HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
		HttpServletResponse response = (HttpServletResponse) req_rep.get("response");
		try {
			request.setCharacterEncoding("UTF-8");
			String ctxPath = request.getSession().getServletContext().getRealPath("");
			System.out.println(ctxPath);
		    String downLoadPath = ctxPath + "/files/" + "test.pdf";
			response.setContentType("application/pdf");
			FileInputStream in = new FileInputStream(new File(downLoadPath));
			OutputStream out = response.getOutputStream();
			byte[] b = new byte[1024];
			while ((in.read(b))!=-1) {
				System.out.println("hello");
			  out.write(b);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}
}
