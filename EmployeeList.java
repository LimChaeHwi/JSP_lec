package edu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchList")
public class EmployeeList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<EmployeeVO> list = new EmployeeBiz().listEmployee();
		req.setAttribute("list", list);
		String url = req.getParameter("url");
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
