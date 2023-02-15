package xyz.zlflearn.wisdom.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import xyz.zlflearn.wisdom.common.BaseContext;
import xyz.zlflearn.wisdom.common.R;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengLongfei
 * @date 2023-02-13-8:43
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1、获取本次请求的URI
        String requestURI = request.getRequestURI();
        //2、判断本次请求是否需要处理
        log.info("本次拦截到请求，{}",requestURI);
        //定义不需要拦截的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };
        boolean cheak = check(urls,requestURI);

        //3、如果不需要处理，则直接放行
        if(cheak){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }

        //4、判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("employee") != null){
            log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("employee"));

            Long empId = (Long)request.getSession().getAttribute("employee");
            //存到线程里
            BaseContext.set(empId);

            filterChain.doFilter(request,response);
            return;
        }
        //5、如果未登录则返回未登录结果，通过输出流方式向客户端页面响应数据
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }
    /**
     * 用于检查是否拦截的uri
     * */
    public boolean check(String[] urls,String requestURI){
        for (String url:urls
             ) {
            if(PATH_MATCHER.match(url,requestURI)){
                return true;
            }
        }
        return false;
    }
}
