package edu;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/empInsert")
public class EmployeeInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ename = req.getParameter("ename");
		EmployeeVO vo = new EmployeeVO(Integer.parseInt(req.getParameter("empno")),
				req.getParameter("ename"),req.getParameter("job"),
				Integer.parseInt(req.getParameter("mgr")),Date.valueOf(req.getParameter("hiredate")),
				Double.parseDouble(req.getParameter("sal")),Double.parseDouble(req.getParameter("comm")),
				Integer.parseInt(req.getParameter("deptno")));
		boolean result = new EmployeeBiz().insertEmployee(vo);
		req.setAttribute("result", result);
		req.setAttribute("ename", ename);
		req.getRequestDispatcher("empInsert.jsp").forward(req, resp);
	}
}
