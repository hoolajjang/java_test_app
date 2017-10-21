package java_test_app.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import java_test_app.dao.IShortUrlInfoDao;

public class UrlFilter implements Filter {

	private IShortUrlInfoDao shortUrlData;
	
	public UrlFilter(IShortUrlInfoDao data) {
		this.shortUrlData = data;
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		
		if (path.matches("/[a-zA-Z0-9]{8}")) {
			String key = path.substring(1);
			
			String originUrl = shortUrlData.getOriginUrl(key);
			resp.sendRedirect(originUrl);
		}
		else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
	}
	
}
