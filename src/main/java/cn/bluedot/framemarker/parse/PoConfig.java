package cn.bluedot.framemarker.parse;

import java.util.Map;



public class PoConfig {
    private String tableName;
    private String className;
    /**
     * String是在bo中的字段名
     */
    private Map<String, FieldConfig> fields;
    
    private String listname;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, FieldConfig> getFields() {
        return fields;
    }

    public void setFields(Map<String, FieldConfig> fields) {
        this.fields = fields;
    }
    
//    public void addField(String attrName, FieldConfig fc) {
//       
//    }
//    
//    public FieldConfig getField(String attrName){
//        return null;
//    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    

    
}
