package cn.bluedot.core.service.echarts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bluedot.core.domain.Gathering;
import cn.bluedot.core.domain.JsonData;
import cn.bluedot.core.domain.Line;
import cn.bluedot.core.domain.ParBar;
import cn.bluedot.core.domain.Payment;
import cn.bluedot.framemarker.dao.Transaction;
import cn.bluedot.framemarker.util.JdbcUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author : 游斌平
 *
 */
@WebServlet("/echarts")
public class Echarts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Echarts() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String startDate = request.getParameter("startTime");
		String endDate = request.getParameter("endTime");
		ParBar payData = new ParBar();
		ParBar getData = new ParBar();
		ParBar sumData = new ParBar();
		List<ParBar> sumBar = new ArrayList<>();
		List<ParBar> payBar = new ArrayList<>();
		List<ParBar> getBar = new ArrayList<>();
		if(startDate==null) {
			 String paysql = "SELECT paymentType,money FROM payment WHERE DATE_FORMAT( paymentDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )";
			 String getsql = "SELECT gatheringType,money FROM gathering WHERE DATE_FORMAT( gatherDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )";
			 try {
				Map<Integer, Double> payMap = new HashMap<>();
				Map<Integer, Double> getherMap = new HashMap<>();
				payData.setName("付款");
				getData.setName("收款");
				sumData.setName("利润");
				getList(paysql, payMap, payData);
				getList(getsql, getherMap, getData);
				payBar =  getBarJson(payMap, 1);
				getBar =  getBarJson(getherMap, 0);
				sumData.setMoney(getData.getMoney()-payData.getMoney());
				sumBar.add(payData);
				sumBar.add(getData);
				sumBar.add(sumData);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			 String paysql = "select paymentType,money from payment where paymentDate >='"+startDate+"' and paymentDate<='" + endDate + "'";
			 String getsql =  "select gatheringType,money from gathering where gatherDate >='"+startDate+"' and gatherDate<='" + endDate + "'";
			 try {
				Map<Integer, Double> payMap = new HashMap<>();
				Map<Integer, Double> getherMap = new HashMap<>();
				payData.setName("付款");
				getData.setName("收款");
				sumData.setName("利润");
				getList(paysql, payMap, payData);
				getList(getsql, getherMap, getData);
				payBar =  getBarJson(payMap, 1);
				getBar =  getBarJson(getherMap, 0);
				sumData.setMoney(getData.getMoney()-payData.getMoney());
				sumBar.add(payData);
				sumBar.add(getData);
				sumBar.add(sumData);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<JsonData> datas  = new ArrayList<>();
		datas = getdatas();
		
		String[] xcontent = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		
		Line line = new Line();
		line.setData(datas);
		line.setXcontent(xcontent);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("categorys",line);
        jsonObject.put("payCategorys", payBar);
        jsonObject.put("getCategorys", getBar);
        jsonObject.put("sumCategorys", sumBar);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(jsonArray.toString());
	}
	/**
	 * @return
	 */
	private List<JsonData> getdatas() {
		// TODO Auto-generated method stub
		Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        List<JsonData> datas = new ArrayList<>();
        Double []  paydata = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        Double []  getdata = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        Double []  lidata = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        for(int i=0; i<12; i++) {
        	String sql ="select money from payment where date_format(paymentDate,'%Y-%m')=";
          	String sql1 ="select money from gathering where date_format(gatherDate,'%Y-%m')=";
			if(i>=9) {
				sql+= "'"+year+"-"+(i+1)+"'";
				sql1+= "'"+year+"-"+(i+1)+"'";
			}else {
				sql+= "'"+year+"-0"+(i+1)+"'";
				sql1+= "'"+year+"-0"+(i+1)+"'";
			}
			paydata[i] = getSum(sql);
			getdata[i] = getSum(sql1);
			lidata[i] = getdata[i] -  paydata[i]; 
		}
        JsonData jd1 = new JsonData();
		jd1.setName("付款");
		jd1.setData(paydata);
		
		JsonData jd2 = new JsonData();
		jd2.setName("收款");
		jd2.setData(getdata);
		
		JsonData jd3 = new JsonData();
		jd3.setName("利润");
		jd3.setData(lidata);
		List<JsonData> data = new ArrayList<JsonData>();
		data.add(jd1);
		data.add(jd2);
		data.add(jd3);
		return data;
	}
	private List<ParBar> getBarJson(Map<Integer,Double> dataMap ,int type){
		List<ParBar> list = new ArrayList<>();
		ParBar data = null; 
		if(type==1) {
			for (Integer key : dataMap.keySet()) {
				data = new ParBar();
				if(key==1) {
					data.setName("药");
					data.setMoney(dataMap.get(key));
				}else if(key==2){
					data.setName("饲料");
					data.setMoney(dataMap.get(key));
				}else if(key==3){
					data.setName("设备");
					data.setMoney(dataMap.get(key));
				}else if(key==4){
					data.setName("猪种");
					data.setMoney(dataMap.get(key));
				}else if(key==5){
					data.setName("员工工资");
					data.setMoney(dataMap.get(key));
				}else if(key==6){
					data.setName("水电费");
					data.setMoney(dataMap.get(key));
				}else if(key==7){
					data.setName("其他");
					data.setMoney(dataMap.get(key));
				}
				list.add(data);
			}
		}else {
			for (Integer key : dataMap.keySet()) {
				data = new ParBar();
				if(key==1) {
					data.setName("出售猪");
					data.setMoney(dataMap.get(key));
				}else if(key==2){
					data.setName("淘汰设备");
					data.setMoney(dataMap.get(key));
				}else if(key==3){
					data.setName("入股资金");
					data.setMoney(dataMap.get(key));
				}else{
					data.setName("其他");
					data.setMoney(dataMap.get(key));
				}
				list.add(data);
			}
		}
		return list;
	}
	
	public Double getSum(String sql) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        Double sum=0.0;
        try {
            conn = JdbcUtils.getConnection();
            Transaction.beginTransaction();
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
            	sum+=(Double)rs.getObject(1);
            }  
            Transaction.commitTransaction();
        }catch(SQLException e) {
            try {
				Transaction.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
	}
	
	public void getList(String sql, Map<Integer,Double> dataMap, ParBar sumBar) throws SQLException {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        Double sum=0.0;
        try {
            conn = JdbcUtils.getConnection();
            Transaction.beginTransaction();
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
            	if(dataMap.get((Integer)rs.getObject(1))==null) {
            		dataMap.put((Integer)rs.getObject(1), (Double)rs.getObject(2));
            	}else {
            		dataMap.put((Integer)rs.getObject(1), dataMap.get((Integer)rs.getObject(1))+(Double)rs.getObject(2));
            	}
            	sum+=(Double)rs.getObject(2);
            }  
            sumBar.setMoney(sum);
            Transaction.commitTransaction();
        }catch(SQLException e) {
            try {
				Transaction.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public void getList(String sql,int type,Map<Integer,Double> dataMap) throws SQLException {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            conn = JdbcUtils.getConnection();
            Transaction.beginTransaction();
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
            	if(dataMap.get((Integer)rs.getObject(1))==null) {
            		dataMap.put((Integer)rs.getObject(1), (Double)rs.getObject(2));
            	}else {
            		dataMap.put((Integer)rs.getObject(1), dataMap.get((Integer)rs.getObject(1))+(Double)rs.getObject(2));
            	}
            }   
            Transaction.commitTransaction();
        }catch(SQLException e) {
            try {
				Transaction.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally {
            JdbcUtils.free(rs, pstmt, conn);
        }
	}
	@SuppressWarnings({ "rawtypes"})
	public List getList(String sql,int type) throws SQLException {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        if(type==1) {
        	List<Payment> list = new ArrayList<>();
        	Payment payment = null;;
            try {
                conn = JdbcUtils.getConnection();
                Transaction.beginTransaction();
                pstmt = conn.prepareStatement(sql);
                rs=pstmt.executeQuery();
                while(rs.next()) {
                	payment = new Payment();
                	payment.setPaymentType((Integer)rs.getObject(1));
                	payment.setMoney((Double)rs.getObject(2));
                	list.add(payment);
                }     
                Transaction.commitTransaction();
            }catch(SQLException e) {
                try {
					Transaction.rollbackTransaction();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }finally {
                if(conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return list;
        }else {
        	List<Gathering> list = new ArrayList<>();
        	Gathering gathering = null ;
            try {
                conn = JdbcUtils.getConnection();
                Transaction.beginTransaction();
                pstmt = conn.prepareStatement(sql);
                rs=pstmt.executeQuery();
                while(rs.next()) {
                	gathering = new Gathering();
                	gathering.setGatheringType((Integer)rs.getObject(1));
                	gathering.setMoney((Double)rs.getObject(2));
                	list.add(gathering);
                }     
                Transaction.commitTransaction();
            }catch(SQLException e) {
                Transaction.rollbackTransaction();
            }finally {
                if(conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return list;
        }
	}
}
