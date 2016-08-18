package edu;

import java.util.ArrayList;

public class EmployeeBiz {

	public ArrayList<EmployeeVO> searchEmployee(int empno){
		ArrayList<EmployeeVO> list = new EmployeeDAO().searchEmployee(empno);
		return list;
	}
	public ArrayList<EmployeeVO> listEmployee(){
		ArrayList<EmployeeVO> list = new EmployeeDAO().listEmployee();
		return list;
	}
	public boolean insertEmployee(EmployeeVO vo){
		boolean result=false;
		result = new EmployeeDAO().insertEmployee(vo);
		
		return result;
	}
	public boolean updateEmployee(EmployeeVO vo){
		boolean result=false;
		result = new EmployeeDAO().updateEmployee(vo);
		
		return result;
	}
	public boolean deleteEmployee(int empno){
		boolean result=false;
		result = new EmployeeDAO().deleteEmployee(empno);
		
		return result;
	}
}
