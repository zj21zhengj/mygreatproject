package com.itranswarp.learnjava;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/name")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应类型:
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        if(name == null) name = "world";
        String html = String.format("<h1>Hello, %s!</h1>",name);
        // 获取输出流:
        PrintWriter pw = resp.getWriter();
        // 写入响应:
        pw.write(html);
        // 最后不要忘记flush强制输出:
        pw.flush();
    }
}
