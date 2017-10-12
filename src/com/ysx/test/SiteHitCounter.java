package com.ysx.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class SiteHitCounter
 */
@WebFilter("/SiteHitCounter")
public class SiteHitCounter implements Filter {
    private int hitCount;

    /**
     * Default constructor.
     */
    public SiteHitCounter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // 这一步是可选的，但是如果需要，您可以把 hitCount 的值写入到数据库
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 把计数器的值增加 1
        hitCount++;

        // 输出计数器
        System.out.println("网站访问统计：" + hitCount);

        // 把请求传回到过滤器链
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // 重置点击计数器
        hitCount = 0;
    }

}
