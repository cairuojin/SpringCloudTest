package com.gjsyoung.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class);

    @Override
    public String filterType() {
        return "pre";       //告知为前置过滤器
    }

    @Override
    public int filterOrder() {
        return 1;           //过滤器执行顺序
    }

    @Override
    public boolean shouldFilter() {
        return true;       //返回该过滤器是否要执行
    }

    @Override
    public Object run() {   //过滤器内容
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.debug(request.getRequestURL() + "\n" + request.getMethod());
        return null;
    }
}
