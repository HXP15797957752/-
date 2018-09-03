package cn.bluedot.framemarker.parse;

/**
 * 
 * @author asus
 *
 */
public class FieldConfig {
    private Boolean key;
    private String type;
    private String attrname;
    private String columnname;
    
    
    public Boolean getKey() {
        return key;
    }
    public void setKey(Boolean key) {
        this.key = key;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAttrname() {
        return attrname;
    }
    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }
    public String getColumnname() {
        return columnname;
    }
    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }
}
