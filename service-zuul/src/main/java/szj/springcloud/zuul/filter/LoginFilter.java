package szj.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest req = context.getRequest();
        logger.info(String.format("%s>>>>%s",req.getMethod(),req.getRequestURL().toString()));
        Object token = req.getParameter("token");
        if(token == null){
            logger.warn("token is null");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try{
                context.getResponse().getWriter().write("token is null");
            }catch (Exception e){

            }
        }
        return null;
    }
}