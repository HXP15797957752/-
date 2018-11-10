package cn.bluedot.core.domain;

import java.util.List;

import cn.bluedot.framemarker.common.BoSuper;

public class MenuBo implements BoSuper{
  //菜单ID
    private Integer menuID;
    //用户编号
    private String userNo ;
    //菜单名
    private String menuName;
    //菜单图标标签
    private String label;
    private List<Menuitem> menuItemList;
    public Integer getMenuID() {
        return menuID;
    }
    public void setMenuID(Integer menuID) {
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
    public List<Menuitem> getMenuItemList() {
        return menuItemList;
    }
    public void setMenuItemList(List<Menuitem> muneItemList) {
        this.menuItemList = muneItemList;
    }
    @Override
    public String toString() {
        return "MuneBo [menuID=" + menuID + ", userNo=" + userNo + ", menuName=" + menuName + ", label=" + label
                + ", muneItemList=" + menuItemList + "]";
    }
    
}
