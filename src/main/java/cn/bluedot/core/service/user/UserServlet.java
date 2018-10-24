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
import cn.bluedot.core.util.MyBeanUtils;
import cn.bluedot.framemarker.dao.SuperDao;
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
        String errCode = "1";
        if (name != null && !"".equals(name) && ps != null && !"".equals(ps)) {
            String hql = "User|userNo=?";
            List<Object> list = superDao.HQLQuery(hql, name);
            System.out.println(list.size());
            User findUser = null;
            if (list == null || list.isEmpty()) {
                errCode = "10100";
            }else if((findUser = (User)list.get(0)) != null && !findUser.getPassword().equals(ps)) {
                errCode = "10101";
            }else {
                request.getSession().setAttribute("user", findUser);
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
        response.getWriter().append("{code:'" + errCode + "', 'data':'/user?method=toIndex'}");
        return null;
    }
    /**
     * 跳转到处理登陆业务 
     * @param request
     * @param resonse
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String tologin(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
        System.out.println(request.getCookies().length + "......");
        for (Cookie cookie : request.getCookies()) {
            if ("cname".equals(cookie.getName())) {
                request.setAttribute("username", cookie.getValue());
            }else if("cps".equals(cookie.getName())) {
                request.setAttribute("password", cookie.getValue());
            }
        }
        return "f:/login.jsp";
    }
    /**
     * 登陆之后跳转到主页
     * @param request
     * @param resonse
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String toIndex(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
        System.out.println("toIndex");
        return "f:/index.html";
    }
    /**
     * 注册业务逻辑
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String ajaxRegist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User registUser = MyBeanUtils.toBean(req.getParameterMap(), User.class);
        
        Map<String, String> errMap = new HashMap<>();
        List<Object> list = superDao.HQLQuery("User|userNo=?", registUser.getUserNo());
        System.out.println(list.size());
        if (!list.isEmpty()) {
            errMap.put("userNo_err", "该用户名已经注册");
        }else if (registUser.getUserNo().length() <= 0) {
            errMap.put("userNo_err", "用户名不能为空");
        }else if (registUser.getUserNo().length() > 32) {
            errMap.put("userNo_err", "用户名长度最大12位");
        }
        if (registUser.getPassword().length() <= 0) {
            errMap.put("password_err", "密码不能为空");
        }else if(registUser.getPassword().length() > 16) {
            errMap.put("password_err", "密码最大长度16位");
        }
        if (registUser.getIDCard().length() != 18) {
            errMap.put("IDCard_err", "身份证错误");
        }
        if (registUser.getPhoneNumber().length() != 11) {
            errMap.put("phoneNumber_err", "电话号码错误");
        }
        if (registUser.getSex() != 0 && registUser.getSex() != 1) {
            errMap.put("sex_err", "性别错误");
        }
        if (registUser.getQuestion() != null && registUser.getQuestion().length()>100) {
            errMap.put("question_err", "问题长度过长");
        }
        if (registUser.getAnswer() != null && registUser.getAnswer().length() > 100) {
            errMap.put("answer_err", "答案长度过长");
        }
        // userNo (0, 32],ps (0, 16], phoneNumber len=11, IDCard len=18, sex 0/1
        // 通过验证, 注册(但是还需要通过审核用户才能登陆成功)
        if (!errMap.isEmpty()) {
            // 验证不通过
            reqP2A(req);
            toReq(errMap, req);
            res.getWriter().append("{code:'0', data:''}");
            return null;
        }
        if (registUser.getAnswer() == null || "".equals(registUser.getAnswer())) {
            registUser.setQuestion(null);
        }
        // 验证通过
        registUser.setCreateDate(new Date());
        registUser.setState(0);// 待审核状态0
        System.out.println(registUser+"]]]");
        try {
            int t = superDao.save(registUser);
            System.out.println(":::t=" + t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.getWriter().append("{code:'1', data:'" + registUser.getUserNo() +"', 'backurl':'/user?method=tologin'}");
        return null;
    }
    /**
     * 找回密码
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findPassword(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        return null;
    }
    /**
     * 更新用户信息
     * 包括了修改密码, 密保, 个人信息, 和用户状态修改
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 主要页面: persData.html
        User user = MyBeanUtils.toBean(req.getParameterMap(), User.class);
        List<Object> list = superDao.HQLQuery("User|userNo=?", user.getUserNo());
        Map<String, String> errMap = new HashMap<>();
        if (list.isEmpty()) {
            errMap.put("userNo_err", "用户名不能修改");
        }else if (user.getUserNo().length() <= 0) {
            errMap.put("userNo_err", "用户名不能为空");
        }else if (user.getUserNo().length() > 32) {
            errMap.put("userNo_err", "用户名长度最大32位");
        }
        if (user.getPassword().length() <= 0) {
            errMap.put("password_err", "密码不能为空");
        }else if(user.getPassword().length() > 16) {
            errMap.put("password_err", "密码最大长度16位");
        }
        if (user.getIDCard().length() != 18) {
            errMap.put("IDCard_err", "身份证错误");
        }
        if (user.getPhoneNumber().length() != 11) {
            errMap.put("phoneNumber_err", "电话号码错误");
        }
        if (user.getSex() != 0 && user.getSex() != 1) {
            errMap.put("sex_err", "性别错误");
        }
        // 还有其他的验证暂时不写
        if (!errMap.isEmpty()) {
            reqP2A(req);
            toReq(errMap, req);
            return "f:/persData.jsp";
        }
        superDao.update(user);
        return "r:/persData.jsp";
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
