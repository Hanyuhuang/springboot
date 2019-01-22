package com.hyh.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;

public class MyLocaleResolver implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String language = request.getParameter("language");
		Locale locale = Locale.getDefault();
		if(language!=null&&!"".equals(language)) {
			String[] split = language.split("_");
			locale = new Locale(split[0],split[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest arg0, HttpServletResponse arg1, Locale arg2) {
		// TODO Auto-generated method stub
		
	}

}
