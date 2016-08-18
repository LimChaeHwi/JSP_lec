package edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empDelete")
public class EmployeeDeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empno = Integer.parseInt(req.getParameter("empno"));
		req.setAttribute("empno", empno);
		boolean result = new EmployeeBiz().deleteEmployee(empno);
		req.setAttribute("result", result);
		RequestDispatcher rd = req.getRequestDispatcher("empDelete.jsp");
		rd.forward(req, resp);
	}
}
