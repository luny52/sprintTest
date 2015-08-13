package com.springTest.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.springTest.Testspring;

//引入ModelAndView时要注意spring有两个ModelAndView,
//import org.springframework.web.portlet.ModelAndView这个不是我们要的ModelAndView引入它不会出错,
//但给ModelAndView设定viewname时无效,总是会以url作为视图名
//正确的引入是下面这个
//import org.springframework.web.servlet.ModelAndView

@Controller
public class Page1Controller {
	private PrintWriter writer;

	@RequestMapping("/page1-1")
	public @ResponseBody() String ShowMsg(HttpServletRequest request) {

		ServletContext servletContext = request.getSession()
				.getServletContext();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);

		Testspring hello = (Testspring) context.getBean("testspring");

		return "This is Page1Controller" + hello.Excute();
	}

	@RequestMapping("/page1-3")
	public @ResponseBody() void ShowVoid(@RequestParam("uid") String uid,
			HttpServletRequest request) {
		// 注意ShowVoid方法加上参数uid后请求的URL中必须包含参数uid才会被拦截到
		// HttpServletRequest request 可有可无
		String RequestURI = request.getRequestURI();
		String QueryString = request.getQueryString();
		String RequestURL = request.getRequestURL().toString();
		String RemoteHost = request.getRemoteHost();
		String RemoteAddr = request.getRemoteAddr();
		String LocalAddr = request.getLocalAddr();
		int RemotePort = request.getRemotePort();
		String Method = request.getMethod();
		String Parameter = request.getParameter("uid");

		return;
	}

	@RequestMapping("/topage1")
	public String StringToPage1() {

		return "page1";
	}

	@RequestMapping("/cometpage")
	public String StringTocometpage() {
		return "../cometpage";
	}

	@RequestMapping("/page1")
	public void VoidToPage1() {
		int a1 = 0;
	}

	@RequestMapping("/ModelPage")
	public ModelAndView toModelAndView() {
		return new ModelAndView();
	}

	@RequestMapping("/toModelAndViewByName")
	public ModelAndView toModelAndViewByName() {
		ModelAndView mv = new ModelAndView("ModelPage1", "ModelKey", 12355);

		return mv;
	}

	@RequestMapping("/comet")
	public @ResponseBody() void Showcomet(@RequestParam("uid") String uid,
			HttpServletRequest request, HttpServletResponse response) {
		// 注意ShowVoid方法加上参数uid后请求的URL中必须包含参数uid才会被拦截到
		// HttpServletRequest request 可有可无
		String RequestURI = request.getRequestURI();
		String QueryString = request.getQueryString();
		String RequestURL = request.getRequestURL().toString();
		String RemoteHost = request.getRemoteHost();
		String RemoteAddr = request.getRemoteAddr();
		int RemotePort = request.getRemotePort();
		String Method = request.getMethod();
		String Parameter = request.getParameter("uid");

		try {
			writer = response.getWriter();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		while (true) {
			try {
				writer.print("<script type=\"text/javascript\">window.parent.Change('"
						+ new Date().toString() + "')</script>");
				writer.flush();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		// return ;
	}

}
