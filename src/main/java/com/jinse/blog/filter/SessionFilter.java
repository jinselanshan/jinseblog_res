package com.jinse.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jinse.blog.utils.ConstantsUtil;
import com.jinse.blog.utils.SpringUtil;

public class SessionFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(SessionFilter.class);
	private FilterConfig config;

	@Override
	public void destroy() {
		config = null;
		log.info(config + "");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 获取ServletContext 对象，用于记录日志
		log.info("before the log filter!");

		// 将请求转换成HttpServletRequest 请求
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;
		HttpSession session = hreq.getSession();
		String url = hreq.getServletPath();
		log.info(url);
		if(url.equals("/login") || url.equals("/loginUser") || url.equals("/signup") || url.equals("/savaUser") || url.equals("/logout")) {
			chain.doFilter(req, res);
			return;
		}
		if(url.indexOf("/static") != -1) {
			chain.doFilter(req, res);
			return;
		}
		if (session.getAttribute(ConstantsUtil.STRING_CURRENT_USER) == null || SpringUtil.getCurrentUser() == null) {
			hres.sendRedirect("/jinseblog/login");
			return;
		} else {
			try {
				// Filter 只是链式处理，请求依然转发到目的地址。
				log.info("before filter pass!");
				chain.doFilter(req, res);
			} catch (Exception e) {
				log.error(null, e);
			}
		}

		log.info("after the log filter!");
		return;

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		log.info("begin do the session filter!");
		this.config = config;
	}

}
