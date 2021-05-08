package com.domain.web;

import java.io.IOException;
import java.sql.SQLException;

import com.domain.web.dao.AlienDao;
import com.domain.web.model.Alien;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAlien")
public class GetAlienController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		
		AlienDao dao = new AlienDao();
		Alien a1 = new Alien();
		try {
			a1 = dao.getAlien(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("alien", a1);
		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
		rd.forward(request, response);
	}
}
