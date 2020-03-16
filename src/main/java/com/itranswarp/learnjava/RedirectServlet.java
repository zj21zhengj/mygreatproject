package com.itranswarp.learnjava;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hi")
public class RedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        //构造重定向的路径
        String name = req.getParameter("name");
        String redirectToUrl = "/hello" + (name == null ?"":"?name"+name);
        rep.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        rep.setHeader("Location", "/hello");
        rep.sendRedirect(redirectToUrl);
    }
}
