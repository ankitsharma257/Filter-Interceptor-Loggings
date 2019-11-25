package com.example.demo;

import java.lang.management.ManagementFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.slf4j.MDCContextMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class democintroller 
{
	Logger logger = LoggerFactory.getLogger(RequestFilter.class);
	@PostMapping(value="a")
	public String a(HttpServletRequest request,HttpServletResponse response)
	{
		String UUID= (String) request.getAttribute("UUID");
		MDC.put("PID", UUID);
		response.addHeader("UUID",UUID);
		//https://www.baeldung.com/spring-response-header
		logger.info("controller");	
		return "a";
	}

}
