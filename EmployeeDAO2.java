package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmployeeDAO2 {
	//context.xml 추가 META-INF에
	//커넥션 풀 이용
	
	public ArrayList<EmployeeVO> searchEmployee(int empno){
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		ResultSet rs = null;
		
		try{
			con = new EmployeeDAO2().getConnection();
			pstmt = con.prepareStatement("select * from emp where empno =?");
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			if(rs==null){
				return null;
			}
			while(rs.next()){
				list.add(new EmployeeVO(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getDate(5),rs.getDouble(6),rs.getDouble(7),
						rs.getInt(8)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){e.getMessage();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.getMessage();}}
			if(con!=null){try{con.close();}catch(Exception e){e.getMessage();}}
		}
		return list;		
		
		
	}
	public ArrayList<EmployeeVO> listEmployee(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		ResultSet rs = null;
		
		try{
			con = new EmployeeDAO2().getConnection();
			pstmt = con.prepareStatement("select * from emp");
			
			rs = pstmt.executeQuery();
			if(rs==null){
				return null;
			}
			while(rs.next()){
				list.add(new EmployeeVO(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getDate(5),rs.getDouble(6),rs.getDouble(7),
						rs.getInt(8)));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){try{rs.close();}catch(Exception e){e.getMessage();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.getMessage();}}
			if(con!=null){try{con.close();}catch(Exception e){e.getMessage();}}
		}
		return list;		

	}
	public boolean insertEmployee(EmployeeVO vo){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
			con = new EmployeeDAO2().getConnection();
			pstmt = con.prepareStatement("insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?) ");
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setDate(5, vo.getHiredate());
			pstmt.setDouble(6, vo.getSal());
			pstmt.setDouble(7, vo.getComm());
			pstmt.setInt(8, vo.getDeptno());
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.getMessage();}}
			if(con!=null){try{con.close();}catch(Exception e){e.getMessage();}}
		}
		if(result>0){
			System.out.println("입력성공");
			return true;
		}else{
			System.out.println("입력실패");
			return false;
		}
		
	}
	public boolean updateEmployee(EmployeeVO vo){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
			con = new EmployeeDAO2().getConnection();
			pstmt = con.prepareStatement("update emp set empno=?,ename=?,job=?,mgr=?,"
					+ "hiredate=?,sal=?,comm=?,deptno=? where empno=?");
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setDate(5, vo.getHiredate());
			pstmt.setDouble(6, vo.getSal());
			pstmt.setDouble(7, vo.getComm());
			pstmt.setInt(8, vo.getDeptno());
			pstmt.setInt(9, vo.getEmpno());
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.getMessage();}}
			if(con!=null){try{con.close();}catch(Exception e){e.getMessage();}}
		}
		if(result>0){
			System.out.println("수정성공");
			return true;
		}else{
			System.out.println("수정실패");
			return false;
		}
		
	}
	public boolean deleteEmployee(int empno){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
			con = new EmployeeDAO2().getConnection();
			pstmt = con.prepareStatement("delete from emp where empno = ? ");
			pstmt.setInt(1, empno);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.getMessage();}}
			if(con!=null){try{con.close();}catch(Exception e){e.getMessage();}}
		}
		if(result>0){
			System.out.println("삭제성공");
			return true;
		}else{
			System.out.println("삭제실패");
			return false;
		}
		
	}
	public Connection getConnection() throws SQLException, ClassNotFoundException, NamingException{
/*		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
*/
		//Connection Pool 로 DB연결
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
		Connection con = ds.getConnection();
		return con;
	}
}
