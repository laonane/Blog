package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import wiki.laona.domain.User;
import wiki.laona.service.ILoginService;

/**
 * @program: Blog
 * @description: 登录 action
 * @author: HuaiAnGG
 * @create: 2020-11-25 00:38
 **/
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    /**
     * 用户实体
     * 使用 modelDriven 管理
     */
    private User user = new User();

    /**
     * 注入登录业务层
     */
    public ILoginService loginService;

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录方法
     *
     * @return 成功(失败)返回后台首页(登录界面)
     */
    public String login() {
        User user = loginService.login(this.user);
        // System.out.println("user = " + user);
        // 用户登录成功
        if (user != null) {
            ActionContext.getContext().getSession().put("curUser", user);
            // 转跳首页
            return SUCCESS;
        }
        // 登录失败，返回报错信息
        this.addActionError("用户名或者密码错误~!");
        // 重新登录
        return LOGIN;
    }

    /**
     * 用户退出功能
     * @return 退出功能
     */
    public String loginOut() {
        // User curUser = (User) ActionContext.getContext().getSession().get("curUser");
        // System.out.println(curUser.getUsername() + "  用户退出。");
        // 清楚用户信息
        ActionContext.getContext().getSession().remove("curUser");
        return "login_out";
    }

    @Override
    public User getModel() {
        return user;
    }

}
