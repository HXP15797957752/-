package cn.bluedot.framemarker.parse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.bluedot.framemarker.dao.DaoException;


/**
 * @author asus
 * 
 */
public class Config {
    public static void main(String[] args) {
        
        System.out.println(getBoKeyAttrNameByListPoSimName("TestBo", "Book"));
    }
    /**
     * Map中的String是 bO的className的simpleName
     */
    private static Map<String, BoConfig> map = new HashMap<>();
    /**
     * classname(simplename) ,  id
     */
    private static volatile Map<String, String> keys = new HashMap<>();
    
    private Config(){
        
    }
    /**
     * 加载配置文件
     */
    static {
        String fileName = "bluedot.xml";
        map = parseBoConfigFile(fileName);
        initKeys("key.properties");
    }
    
    
    public static BoConfig getBoconfig(String className){
        return map.get(className.substring(className.lastIndexOf(".")+1));
    }
    
    public static String getpoclassName(String simpleName){
        //Role=id|cn.xxx.xxx.Role
        String temp = keys.get(simpleName);
        return temp.substring(temp.indexOf("|")+1);
    }
    
    public static String getKey(String simpleName){
       //Role=id|cn.xxx.xxx.Role
    	System.out.println(simpleName);
        String temp = keys.get(simpleName);
        return temp.substring(0, temp.indexOf("|"));
    }
    /**
     * 查出bo里面根据指定的po的简单名称， 查出 bo里于它相关联的属性主键名称
     * @param bosimpleName
     * @param poSimpleName
     * @return
     */
    public static String getBoKeyAttrNameByListPoSimName(String bosimpleName, String poSimpleName){
        // <ref potablename="book" columnname="userid"  refpotablename="user" refname="id" ></ref>
        BoConfig boc = map.get(bosimpleName);
        if (boc == null){
           throw new DaoException("无效的BO类名称:" + bosimpleName); 
        }
        String poname = null;
        String columnName = null;
        Set<String> keys = boc.getRefs().keySet();
        
        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            Ref vr = boc.getRefs().get(key);
            if (poSimpleName.equalsIgnoreCase(vr.getPotablename())){
                poname = vr.getRefpotablename();
                columnName = vr.getRefname();
                break;
            }
        }
        
        Set<String> kks2 = boc.getNotListPoConfig().keySet();
        for (Iterator iterator = kks2.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            PoConfig poc = boc.getNotListPoConfig().get(key);
            if (poc.getTableName().equalsIgnoreCase(poname)){
                Set<String> kks3 = poc.getFields().keySet();
                for (String fkey : kks3) {
                    FieldConfig fieldConfig = poc.getFields().get(fkey);
                    if (fieldConfig.getColumnname().equals(columnName)){
                        return fieldConfig.getAttrname();
                    }
                }
                break;
            }
        }
        return null;
    }
    /**
     * 初始化key.properties
     */
    private static void initKeys(String path) {
        Properties properties = new Properties();
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream(path));
            Set<Object> keyset = properties.keySet();
            for (Iterator iterator = keyset.iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                keys.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    //Bo map解析
    /**
     * <bo classname="类名">
    
    <!-- 如果写了listname, property的attrname可以不写  : tablename.columnname-->
    <po classname="" tablename="" listname="setName">
         <id type="" columnname=""></id>
         <property type=""  columnname = ""></property>
         <property></property>
         <property></property>
     </po>
     <!-- 不是一个集合,必须写attrname -->
    <po classname="" tablename="" >
         <id type="" attrname = "" columnname = ""></id>
         <property></property>
         <property></property>
    </po>
</bo>
     * @param fileName
     * @return
     */
    private static Map<String, BoConfig> parseBoConfigFile(String fileName) {
        SAXReader reader = new SAXReader();
        Map<String, BoConfig> map = new HashMap<>();
        try {
        	System.out.println(fileName);
            Document doc = reader.read(Config.class.getClassLoader().getResourceAsStream(fileName));
            System.out.println(doc);
            Element root = doc.getRootElement();
            //先拿到所有的BO
            List<Element> list = root.selectNodes("bo");
            for(Element element : list) {
                BoConfig boConfig = new BoConfig();
                String classname = element.attributeValue("classname");
                boConfig.setClassName(classname);
                //refs 
                Map<String, Ref> refMap = new HashMap<>();
                List<Element> refList = element.elements("ref");
                for(Element refE:refList) {
                    Ref ref_t = new Ref();
                    ref_t.setColumnname(refE.attributeValue("columnname"));
                    ref_t.setPotablename(refE.attributeValue("potablename"));
                    ref_t.setRefpotablename(refE.attributeValue("refpotablename"));
                    ref_t.setRefname(refE.attributeValue("refname"));
                    refMap.put(ref_t.getPotablename()+"."+ref_t.getColumnname(), ref_t);
                }
                boConfig.setRefs(refMap);
                
                //获取bo下面的所有的po
                Map<String, PoConfig> isListposMap = new HashMap<>();
                Map<String, PoConfig> notListposMap = new HashMap<>();
                
                
                List<Element> posList = element.elements("po");
                for(Element poe:posList) {
                    PoConfig poConfig = new PoConfig();
                    Map<String, FieldConfig> fieldMap = new HashMap<>();
                    poConfig.setFields(fieldMap);
                    poConfig.setClassName(poe.attributeValue("classname"));
                    poConfig.setTableName(poe.attributeValue("tablename"));
                    
                    Element id_element = poe.element("id");
                    FieldConfig idfield = new FieldConfig();
                    //type="" attrname = "" attrname = ""
                    idfield.setType(id_element.attributeValue("type"));
                    idfield.setAttrname(id_element.attributeValue("attrname"));
                    idfield.setColumnname(id_element.attributeValue("columnname"));
                    idfield.setKey(true);
                    fieldMap.put(idfield.getColumnname(), idfield);
                    List<Element> fList = poe.elements("property");
                    for(Element f:fList) {
                        FieldConfig fc_t = new FieldConfig();
                        fc_t.setType(f.attributeValue("type"));
                        fc_t.setAttrname(f.attributeValue("attrname"));
                        fc_t.setColumnname(f.attributeValue("columnname"));
                        fc_t.setKey(false);
                        fieldMap.put(fc_t.getColumnname(), fc_t);
                    }
                    
                    String listname = poe.attributeValue("listname");
                    if(listname!=null&&!"".equals(listname)) {
                        poConfig.setListname(listname);
                        isListposMap.put(poConfig.getClassName().substring(poConfig.getClassName().lastIndexOf(".")+1).toLowerCase(), poConfig);
                    }else{
                        notListposMap.put(poConfig.getClassName().substring(poConfig.getClassName().lastIndexOf(".")+1).toLowerCase(), poConfig);
                    }
                }
                boConfig.setIsListPoConfigs(isListposMap);
                boConfig.setNotListPoConfig(notListposMap);
                String boc_simpleName = boConfig.getClassName();
                boc_simpleName = boc_simpleName.substring(boc_simpleName.lastIndexOf(".")+1);
                map.put(boc_simpleName, boConfig);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return map;
        
    }
    
}
