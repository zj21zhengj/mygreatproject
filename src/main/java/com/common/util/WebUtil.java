package com.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 常用工具包
 */
public class WebUtil {

    private WebUtil() {

    }

    public static HttpServletRequest getThreadRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpSession getThreadSession() {
        return getThreadRequest().getSession(true);
    }

    /**
     * Description: 获取项目在磁盘上的路径
     *
     * @param
     * @return String 路径
     */
    public static String getRealPath() {
        return getThreadSession().getServletContext().getRealPath("");
    }
}
