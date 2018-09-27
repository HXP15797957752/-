package cn.bluedot.core.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import cn.bluedot.core.domain.Algorithm;
import cn.bluedot.core.domain.CombinatorialAlgorithm;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.core.util.ParseUpload;
import cn.bluedot.framemarker.common.BoSuper;
import cn.bluedot.framemarker.dao.SuperDao;
import net.sf.json.JSONArray;

public class  AlgorithmService extends RequestWare implements Service  {
	private SuperDao superDao = new SuperDao();
	
	/**
	 * 提交算法插件
	 * 用例描述	系统管理员或管理员填写要提交算法的相应信息
	 * 参与者	系统管理员或管理员
	 * 前置条件	系统管理员或管理员进入算法管理并提交算法
	 * 后置条件	系统保存提交的算法
	 * 基本操作流程	
	 * 	①系统管理员或管理员填写要提交算法的相应信息,算法类型（单分析算法、分析建议算法）,
	 * 	②若输入有误，则系统进行相应提示；若输入无误，则完成算法的上传“待审核”，由实验人员审核
	 * @param map
	 * @return
	 */
	public String commitAlgorithmPlug (Map map) {
		// 因为是 multipart/form-data 所有map是空的
		// 表单中普通字段的参数
		Map<String,String> params = new HashMap<>();
		// 取出request
		HttpServletRequest request = (HttpServletRequest) req_rep.get("request");
		
		// 用通用工具栏解析 is是文件流 params解析后就是普通字段的参数
		InputStream is = ParseUpload.parseUpload(request, params);
		
		Algorithm algorithm = MyBeanUtils.toBean(params, Algorithm.class);

		File Folder= new File(request.getSession().getServletContext().
				getRealPath("algorithm/"));
		// 将上传的文件以自定义后缀 列如algo的形式保存在服务器,当需要使用时,
		// 再根据数据库记录的类型处理
		File file = new File(Folder,algorithm.getAlgorithmID()+".algo");
		
		try {
			if(null!=is && 0!=is.available()){
			    try(FileOutputStream fos = new FileOutputStream(file)){
			        byte b[] = new byte[1024 * 1024];
			        int length = 0;
			        while (-1 != (length = is.read(b))) {
			            fos.write(b, 0, length);
			        }
			        fos.flush();
			    }
			    catch(Exception e){
			    	e.printStackTrace();
			    }
			}
			/*
		 	  ' ─ wow ──▌▒█───────────▄▀▒▌─── 
		  	  ' ────────▌▒▒▀▄───────▄▀▒▒▒▐─── 
		  	  ' ───────▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐─── 
		  	  ' ─────▄▄▀▒▒▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐─── 
		  	  ' ───▄▀▒▒▒▒▒▒有请P9操作一波DAO── 
		  	  ' ──▐▒▒▒▄▄▄▒▒▒▒▒▒▒▒▒▒▒▒▒▀▄▒▒▌── 
		  	  ' ──▌▒▒▐▄█▀▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐── 
		  	  ' ─▐▒▒▒▒▒▒▒▒▒▒▒▌██▀▒▒▒▒▒▒▒▒▀▄▌─ 
		  	  ' ─▌▒▀▄██▄▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▌─ 
		  	  ' ─▌▀▐▄█▄█▌▄▒▀▒▒▒▒▒▒░░░░░░▒▒▒▐─ 
		  	  ' ▐▒▀▐▀▐▀▒▒▄▄▒▄▒▒▒实在不会DAO ▒▌ 
		  	  ' ▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒░░░░░░▒▒▒▐─ 
		  	  ' ─▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒▒▒░░░░▒▒▒▒▌─ 
		  	  ' ─▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▐── 
		  	  ' ──▀ amaze ▒▒▒▒▒▒▒▒▒▒▒▄▒▒▒▒▌── 
		  	  ' ────▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀─── 
		  	  ' ───▐▀▒▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀───── 
		  	  ' ──▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▀▀────────
			*/
			// 大概dao的用法
			superDao.save(algorithm);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 异步响应
		return "a^算法插件上传成功";
	}
	
	/**
	 * 算法组合
	 * 用例描述	系统管理员或管理员填写要提交算法的相应信息
	 * 参与者	系统管理员或管理员
	 * 前置条件	系统管理员或管理员进入算法管理并提交算法
	 * 后置条件	系统保存提交的算法
	 * 基本操作流程
	 * 	①系统管理员或管理员填写要提交算法的相应信息,算法类型（单分析算法、分析建议算法）,
	 * 	②若输入有误，则系统进行相应提示；若输入无误，则完成算法的上传“待审核”，由实验人员审核
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String algorithmCombination (Map map) {
		CombinatorialAlgorithm combinatorialAlgorithm = MyBeanUtils.toBean(map, CombinatorialAlgorithm.class);
		try {
			superDao.save(combinatorialAlgorithm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "a^算法组合成功";
	}
	
	/**
	 * 删除算法插件
	 * 用例描述	系统管理员或管理员选择要删除的算法的相应信息
	 * 参与者	系统管理员或管理员
	 * 前置条件	系统管理员或管理员进入算法管理并删除算法
	 * 后置条件	系统对响应
	 * 算法状态进行更改
	 * 基本操作流程	
	 * 	①系统管理员或管理员查询要删除的算法见表(2-1),选择要删除的算法（单分析算法、分析建议算法）
	 * 	②操作有误，则系统进行相应提示；若无误，则算法的状态为“已废弃”
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String deleteAlgorithmPlug (Map map) {
		Algorithm algorithm = MyBeanUtils.toBean(map, Algorithm.class);
		try {
			superDao.delete(algorithm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "a^算法删除成功";
	}
	
	/**
	 * 查看算法文件
	 * 用例描述	系统管理员或管理员查看算法的相应信息
	 * 参与者	系统管理员或管理员
	 * 前置条件	系统管理员或管理员进入算法管理并查看算法
	 * 后置条件	系统保存提交的算法
	 * 基本操作流程	
	 * 	①系统管理员或管理员查询算法,见表(2-1)
	 * 	②若输入有误，则系统进行相应提示；若输入无误，则完成算法的上传“待审核”，由实验人员审核
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String viewAlgorithmfiles (Map map) {
		Algorithm algorithm = MyBeanUtils.toBean(map, Algorithm.class);
		String hql = "Algorithm|algorithmID=?|limit 0,10";
		List vo= superDao.HQLQuery(hql, algorithm.getAlgorithmID());
		JSONArray View = JSONArray.fromObject(vo);
		return View.toString();
	}
	
	/**
	 * 移动算法文件
	 * 用例描述	系统管理员或管理员可以将算法文件移动到指定位置
	 * 参与者	系统管理员或管理员
	 * 前置条件	系统管理员或管理员进入算法管理并移动算法文件
	 * 后置条件	系统保存移动后算法位置
	 * 基本操作流程	
	 * 	①系统管理员或管理员查询算法,见表(2-1),并移动算法
	 * 	②若操作有误，则系统进行相应提示；若输入无误，则完成算法的保存位置移动
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String mobileAlgorithmfiles (Map map) {
		return null;
	}
	
	/**
	 * 公开算法
	 * 用例描述	系统管理员选择要提交公开的算法
	 * 参与者	用户
	 * 前置条件	系统管理员进入算法管理并公开算法
	 * 后置条件	系统改变被公开算法的可视状态
	 * 基本操作流程	
	 * 	①查询算法组合,见表(2-1),系统管理员选择已经保存的组合算法公开
	 * 	②若输入有误，则系统进行相应提示；若输入无误，则完成算法的公开
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String publicAlgorithm (Map map) {
	    
		return null;
	}
	
	/**
	 * 下载算法
	 * 用例描述	用户下载自己的算法到本地
	 * 参与者	用户
	 * 前置条件	此算法已公开公开算法
	 * 后置条件	系统算法下载次数增加
	 * 基本操作流程	用户查询算法,见表(2-1).并下载已公开的算法
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String downloadAlgorithm (Map map) {
		return null;
	}

}
