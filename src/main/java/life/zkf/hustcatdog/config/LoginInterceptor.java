package life.zkf.hustcatdog.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");

        if (user == null) { // 没有登录
            request.setAttribute("message", "没有权限");
            request.getRequestDispatcher("/admin").forward(request, response);
            return false;
        }

        return true;
    }
}
