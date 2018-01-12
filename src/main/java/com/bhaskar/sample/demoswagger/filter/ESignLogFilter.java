package com.bhaskar.sample.demoswagger.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class ESignLogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String mdcData = String.format("[transactionID: %s] ", transactionID());
            MDC.put("uniqueTrackingNumber", mdcData);
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    private String transactionID() {
        return System.currentTimeMillis() + "";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
