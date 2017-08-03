package dev.sgp.web.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteService;

@WebFilter(urlPatterns = { "/collaborateur/*" }, description = "Statistique filter")
public class FrequentationFilter implements Filter {

	private FilterConfig config;

	@Inject
	private VisiteService visiteService;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("FrequentationFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long before = System.currentTimeMillis();

		chain.doFilter(request, response);

		long after = System.currentTimeMillis();
		int temps = (int) (after - before);
		visiteService.sauvegarderVisiteWeb(new VisiteWeb(((HttpServletRequest) request).getRequestURI(), temps));
	}

	@Override
	public void destroy() {
		config.getServletContext().log("FrequentationFilter destroyed");
	}

}
