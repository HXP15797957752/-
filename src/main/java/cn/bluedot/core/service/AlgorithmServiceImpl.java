package cn.bluedot.core.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class  AlgorithmServiceImpl extends RequestWare implements Service  {
	
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
	    this.getRequest();
		return null;
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
		return null;
	}
	
	/**
	 * 删除算法插件
	 * 用例描述	系统管理员或管理员选择要删除的算法的相应信息
	 * 参与者	系统管理员或管理员
	 * 前置条件	系统管理员或管理员进入算法管理并删除算法
	 * 后置条件	系统对响应算法状态进行更改
	 * 基本操作流程	
	 * 	①系统管理员或管理员查询要删除的算法见表(2-1),选择要删除的算法（单分析算法、分析建议算法）
	 * 	②操作有误，则系统进行相应提示；若无误，则算法的状态为“已废弃”
	 * 可选操作	
	 * @param map
	 * @return
	 */
	public String deleteAlgorithmPlug (Map map) {
		return null;
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
		return null;
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
