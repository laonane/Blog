package wiki.laona.web.filter;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: Blog
 * @description: 自定义 Struts 过滤器
 * @author: HuaiAnGG
 * @create: 2020-11-30 13:56
 **/
public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 获取当前请求
        HttpServletRequest request = (HttpServletRequest) req;
        // 获取请求的复制
        String requestURI = request.getRequestURI();
        if (requestURI.contains("js/umedit/jsp/controller.jsp")){
            // 放行
            chain.doFilter(req, res);
        } else {
            // 不是富文本的请求就进行拦截（使用 struts 的拦截器）
            super.doFilter(req, res, chain);
        }
    }
}
