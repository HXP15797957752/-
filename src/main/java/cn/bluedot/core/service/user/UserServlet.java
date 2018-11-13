package cn.bluedot.core.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author renzhijiang
 *  对于/user 路径进行拦截, 用户业务
 */
import cn.bluedot.core.domain.User;
import cn.bluedot.framemarker.dao.SuperDao;
@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    
    
    public String login(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
        String name = request.getParameter("username");
        String ps = request.getParameter("password");
        
        if (name != null && !"".equals(name) && ps != null && !"".equals(ps)) {
            String hql = "User|userNo=?";
            User findUser = (User)superDao.HQLQuery(hql, name).get(0);
            if (findUser != null && findUser.getPassword().equals(ps)) {
                // login success and save to session
                request.getSession().setAttribute("user", findUser);
<<<<<<< HEAD
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
=======
                System.out.println(findUser);
                // goto index.jsp
                return "r:/index.jsp";
>>>>>>> bd4e2ee511dea28118651148b46f441458a9acdf
            }
        }
        // login fail
        System.out.println("fail signin:");
        return "r:/login.jsp";
    }
    
    public String regist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
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
        
        return null;
    }
    
    /**
     * Dao 数据访问对象
     */
    private SuperDao superDao = new SuperDao();
    
    public static void main(String[] args) {
        SuperDao superDao = new SuperDao();
        String name = "1";
        String hql = "User|userNo=?";
        List<Object> users = superDao.HQLQuery(hql, name);
        System.out.println(users);
    }
}
