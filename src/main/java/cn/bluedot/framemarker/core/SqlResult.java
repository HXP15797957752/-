package cn.bluedot.framemarker.core;

import java.util.List;
import java.util.Map;

public class SqlResult {
    private String sql;
    private List<Object> params;
    /**
     * po/bo
     */
    private Object obj;
    /**
     * Po=classname -- 
     */
    private Map<String, String> setmap;
    /**
     * 
     * @return
     */
    
    private Map<String, String> listmap;
    
    public String getSql() {
        return sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
    public List<Object> getParams() {
        return params;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    
    public void setParams(List<Object> params) {
        this.params = params;
    }
    public SqlResult(String sql, List<Object> params) {
        super();
        this.sql = sql;
        this.params = params;
    }
    public SqlResult(String sql, List<Object> params, Object obj) {
        super();
        this.sql = sql;
        this.params = params;
        this.obj = obj;
    }
    public SqlResult() {
        super();
    }
   
    public Map<String, String> getSetmap() {
        return setmap;
    }
    public void setSetmap(Map<String, String> setmap) {
        this.setmap = setmap;
    }
    public Map<String, String> getListmap() {
        return listmap;
    }
    public void setListmap(Map<String, String> listmap) {
        this.listmap = listmap;
    }
}
