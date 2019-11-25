package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.hibernate.validator.constraints.SafeHtml;
import org.slf4j.*;
import java.io.IOException;
import java.util.UUID;
//http://rubenjgarcia.es/log-requests-spring-boot-microservices/ 
@Component
public class RequestFilter implements Filter {
 
	Logger logger = LoggerFactory.getLogger(RequestFilter.class);
	
    public static final String REQUEST_HEADER_NAME = "X-REQUEST-UUID";
   
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String id = httpServletRequest.getHeader(REQUEST_HEADER_NAME);
        if (id == null || "".equals(id)) 
        {
            id = UUID.randomUUID().toString();
        }
        request.setAttribute("UUID", id);
        chain.doFilter(request, response);
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
 
    @Override
    public void destroy() {
    }
}
