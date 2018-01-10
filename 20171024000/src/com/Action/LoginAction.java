

package com.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginAction extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		
		
		if(uname.equals("system")&&upass.equals("111")){
			resp.getWriter().write("true");
			System.out.println("ÕýÈ·");
		}else{
			resp.getWriter().write("false");
			System.out.println("´íÎó");
		}
	}
	
	

}
