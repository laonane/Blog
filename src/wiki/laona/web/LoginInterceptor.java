package wiki.laona.web;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;
import wiki.laona.domain.User;

/**
 * @program: Blog
 * @description: 登录拦截器
 * @author: HuaiAnGG
 * @create: 2020-12-02 20:00
 **/
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 判断是否用用户登录
        User curUser = (User) ServletActionContext.getRequest().getSession().getAttribute("curUser");
        if (curUser == null) {
            ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
            actionSupport.addActionError("您还没有登录，没有权限访问");
            return "login";
        }else {
            // 对请求方法进行放行
            return actionInvocation.invoke();
        }
    }
}
