package cn.bluedot.framemarker.parse;

import java.util.Map;

public class BoConfig {
    
    /**
     * BO 的类名
     */
    private String className;
    /**
     * POclassName  ->  POConfig
     */
    private Map<String, PoConfig> isListPoConfigs;
    
    private Map<String, PoConfig> notListPoConfig;
    
    /**
     * potableName.pocolumnname  ->  ref
     */
    private Map<String, Ref> refs;
    
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, PoConfig> getIsListPoConfigs() {
        return isListPoConfigs;
    }

    public void setIsListPoConfigs(Map<String, PoConfig> isListPoConfigs) {
        this.isListPoConfigs = isListPoConfigs;
    }

    public Map<String, PoConfig> getNotListPoConfig() {
        return notListPoConfig;
    }

    public void setNotListPoConfig(Map<String, PoConfig> notListPoConfig) {
        this.notListPoConfig = notListPoConfig;
    }

    public Map<String, Ref> getRefs() {
        return refs;
    }

    public void setRefs(Map<String, Ref> refs) {
        this.refs = refs;
    }
    
    
}
