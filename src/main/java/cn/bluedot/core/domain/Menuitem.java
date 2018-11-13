package cn.bluedot.core.domain;

public class Menuitem {
    //菜单子项ID
    private Integer menuItemID;
    private String userNo;
    private Integer menuID;
    //菜单子项名称
    private String itemName;
    //子项标签id
    private String labelId;
    //目标页面
    private String targetPage;
    //调用service路径
    private String serviceURL;
    public Integer getMenuItemID() {
        return menuItemID;
    }
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public Integer getMenuID() {
        return menuID;
    }
    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getLabelId() {
        return labelId;
    }
    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
    public String getTargetPage() {
        return targetPage;
    }
    public void setTargetPage(String targetPage) {
        this.targetPage = targetPage;
    }
    public String getServiceURL() {
        return serviceURL;
    }
    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }
    public void setMenuItemID(Integer menuItemID) {
        this.menuItemID = menuItemID;
    }
    @Override
    public String toString() {
        return "Menuitem [menuItemID=" + menuItemID + ", userNo=" + userNo + ", menuID=" + menuID + ", itemName="
                + itemName + ", labelId=" + labelId + ", targetPage=" + targetPage + ", serviceURL=" + serviceURL + "]";
    }
    
    
    
}
