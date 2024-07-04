package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/announce")
public class AnnouncementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processServlet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processServlet(req, resp);
	}
	
	protected void processServlet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String message = req.getParameter("ann");
				// ServletContext ctx = config.getServletContext();
				// ServletContext ctx = req.getServletContext();
				// ServletContext ctx = session.getServletContext();
				ServletContext ctx = this.getServletContext(); // current servlet
				ctx.setAttribute("announcement", message);
				resp.sendRedirect("logout");
	}
}

