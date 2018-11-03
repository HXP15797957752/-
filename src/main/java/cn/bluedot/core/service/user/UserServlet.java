package cn.bluedot.core.service.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author renzhijiang
 *  对于/user 路径进行拦截, 用户业务
 */
import cn.bluedot.core.domain.User;
import cn.bluedot.core.service.PowerManage;
import cn.bluedot.core.service.user.validation.ValidationUtil;
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.dao.SuperDao;
import net.sf.json.JSONObject;
@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    /**
     * 登陆业务
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String ps = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        String errCode = "0";
        if (name != null && !"".equals(name) && ps != null && !"".equals(ps)) {
            String hql = "User|userNo=?";
            List<Object> list = superDao.HQLQuery(hql, name);
            User findUser = null;
            if (list == null || list.isEmpty()) {
                errCode = "10100";
            }else if((findUser = (User)list.get(0)) != null && !findUser.getPassword().equals(ps)) {
                errCode = "10101";
            }else if(findUser.getState() == 0) {
                errCode = "10102";
            }else if(findUser.getState() == 2) {
                errCode = "10103";
            }else {
                request.getSession().setAttribute("user", findUser);
                System.out.println(findUser + "已经登陆!!!");
                //以下为获取对应用户的菜单权限显示，并保存到session
                Map menuMap  = new HashMap();
                menuMap.put("userNo", findUser.getUserNo());
                List menuList = new PowerManage().loadPage(menuMap);
                System.out.println("menuList=="+menuList);
                request.getSession().setAttribute("menuList", menuList);
                
                if (rememberMe.equals("true")) {
                    Cookie c1 = new Cookie("cname", name);
                    Cookie c2 = new Cookie("cps", ps);
                    c1.setMaxAge(604800);
                    c2.setMaxAge(604800);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
            }
        }
        response.getWriter().append("{code:'" + errCode + "', 'data':'/index.jsp'}");
        return null;
    }
    
    
    /**
     * 注册业务逻辑
     * 用户状态补充:待审核状态0; 审核通过1;审核不通过2;注销状态3
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxRegist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User registUser = MyBeanUtils.toBean(req.getParameterMap(), User.class);
        
        List<Object> list = superDao.HQLQuery("User|userNo=?", registUser.getUserNo());
        Map<String, String> map = ValidationUtil.validat(registUser);
        
        if (!list.isEmpty() || ValidationUtil.validat(map) == false) {
            // 验证不通过
            reqP2A(req);
            res.getWriter().append("{code:'0', data:''}");
            return null;
        }
        // userNo (0, 32],ps (0, 16], phoneNumber len=11, IDCard len=18, sex 0/1
        // 通过验证, 注册(但是还需要通过审核用户才能登陆成功)
        
        if (registUser.getAnswer() == null || "".equals(registUser.getAnswer())) {
            registUser.setQuestion(null);
        }
        // 验证通过
        registUser.setCreateDate(new Date());
        registUser.setState(0);// 待审核状态0
        try {
            superDao.save(registUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.getWriter().append("{code:'1', data:'" + registUser.getUserNo() +"', 'backurl':'/login.html'}");
        return null;
    }
    /**
     * 注册字段校验
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     * 
     * 
     */
    public String registCheck(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String msg = ValidationUtil.validat(req, User.class, "name", "value");
        res.getWriter().append("{msg:'" + msg + "'}");
        return null;
    }
    /**
     * 返回 User对象的JSON
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String sessionUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        if (user != null) {
            String t = JSONObject.fromObject(user).toString();
            res.getWriter().append(t);
        }
        return null;
    }
    
    /**
     * 修改密码
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updatePassword(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //userNo, 原密码, 新密码
        String userNo = req.getParameter("userNo");
        String oldPs = req.getParameter("oldps");
        String newPs = req.getParameter("newps");
        List<Object> list = superDao.HQLQuery("User|userNo=?", userNo);
        if (!list.isEmpty()) {
            User user = (User) list.get(0);
            if (user.getPassword().equals(oldPs)){
                user.setPassword(newPs);
                if ("".equals(ValidationUtil.validat("password", user))) {
                    superDao.update(user);
                    
                    res.getWriter().append("{msg:'修改成功', code:'0'}");
                    return null;
                }
            }
        }
        // 修改失败
        res.getWriter().append("{msg:'修改失败', code:'1'}");
        return null;
    }
    /**
     * 更新 个人信息
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 主要页面: persData.html
        System.out.println("guolaile, update");
        User user = MyBeanUtils.toBean(req.getParameterMap(), User.class);
        List<Object> list = superDao.HQLQuery("User|userNo=?", user.getUserNo());
        if (!list.isEmpty()) {
            
            if (ValidationUtil.validat(ValidationUtil.validat(user))) {
                superDao.update(user);
                
                res.getWriter().append("{msg:'修改成功', code:'0'}");
                list = superDao.HQLQuery("User|userNo=?", user.getUserNo());
                req.getSession().setAttribute("user", list.get(0));
                return null;
            }
        }
        res.getWriter().append("{msg:'修改失败', code:'1'}");
        return null;
    }
    public String updateMibao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 主要页面: persData.html
        User user = MyBeanUtils.toBean(req.getParameterMap(), User.class);
        List<Object> list = superDao.HQLQuery("User|userNo=?", user.getUserNo());
        if (!list.isEmpty()) {
            
            if ("".equals(ValidationUtil.validat("question", user)) && "".equals(ValidationUtil.validat("answer", user))) {
                superDao.update(user);
                
                res.getWriter().append("{msg:'修改成功', code:'0'}");
                list = superDao.HQLQuery("User|userNo=?", user.getUserNo());
                req.getSession().setAttribute("user", list.get(0));
                return null;
            }
        }
        res.getWriter().append("{msg:'修改失败', code:'1'}");
        return null;
    }
    /**
     * Dao 数据访问对象
     */
    private SuperDao superDao = new SuperDao();
    
    public static void main(String[] args) {
        SuperDao superDao = new SuperDao();
        String name = "admin";
        String hql = "User|userNo=?";
        List<Object> users = superDao.HQLQuery(hql, name);
        System.out.println(users);
        
    }
}
