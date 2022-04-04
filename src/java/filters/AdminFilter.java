package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import models.*;

/**
 *
 * @author emmari
 */
public class AdminFilter implements Filter {
    
   
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        

        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession();
        
        User user = new User();
        
        int roleId = user.getRole().getRoleId();

        
        //Check if user is an admin or not
        
            //User is an admin
            if (roleId == 1) {              
                    chain.doFilter(request, response);
            }
            //User is not an admin
            else {
                httpResponse.sendRedirect("notes");
            } 
    }
    

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        

    }

    
}
