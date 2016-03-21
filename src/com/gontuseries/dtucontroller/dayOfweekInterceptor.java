package com.gontuseries.dtucontroller;

//package com.gontuseries.dtucontroller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

public class dayOfweekInterceptor extends HandlerInterceptorAdapter{
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek==1){
			response.getWriter().write("The Website is closed on Sunday; please try on any other day!!");
			return false;
		}
		
		
		return true;
		
	}

	

}
