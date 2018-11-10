/**
 * 
 */
package cn.bluedot.core.domain;

import java.util.List;

/**
 * @author hxp
 * 2018年10月30日 下午11:17:17
 */
public class Menu {
    //菜单ID
    private Integer menuID;
    //用户编号
    private String userNo ;
    //菜单名
    private String menuName;
    //菜单图标标签
    private String label;
    /*private List<MuneItem> menuItemList;*/
    public int getMenuID() {
        return menuID;
    }
    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return "Menu [menuID=" + menuID + ", userNo=" + userNo + ", menuName=" + menuName + ", label=" + label + "]";
    }
    
}
