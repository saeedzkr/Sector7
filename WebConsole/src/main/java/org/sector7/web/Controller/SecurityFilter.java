package org.sector7.web.Controller;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.sector7.model.entity.Device;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created by sector7 on 12/12/15.
 */


public class SecurityFilter implements Filter {


    Logger logger = Logger.getLogger("callLogger");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.log(Level.INFO, "Security Filter has been initialize");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        Device device = (Device) session.getAttribute("device");
        String uri = req.getRequestURI();
        if (device == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet") || uri.endsWith("xhtml")) && cotnrolIpAddress()) {
            logger.log(Level.WARN, "Unauthorized access request");
            res.sendRedirect("login.xhtml");
        } else {
            if (device != null && device.getDeviceKey().isEmpty()) {
                filterChain.doFilter(servletRequest, servletResponse);


                logger.log(Level.INFO, "Requested Resource::" + uri);

            } else {

                logger.log(Level.INFO, "request Authorized");
                // pass the request along the filter chain
                filterChain.doFilter(req, res);
            }

        }
    }

    private boolean cotnrolIpAddress() {
        //todo control vpn
        return true;
    }

    @Override
    public void destroy() {

    }

}
