package lk.ijse.servelt;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter  {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session =((HttpServletRequest) servletRequest).getSession(false);

        if(session == null){
            ((HttpServletResponse) servletResponse).sendError(401);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
