package com.infinite.jdbc;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployDAO {
	Connection connection;
	PreparedStatement pst;
	public String updateEmploy(Employ employNew) throws SQLException, ClassNotFoundException{
		Employ employ = SearchEmploy(employNew.getEmpno());
		if(employ!=null){
			String cmd = "update employ set name=?, Dept=?,desig=?"  +"Basic =?  where empno=?";
			connection = ConnectionHelper.getConnection();
			pst = setString(1,employNew.getName());
			
			pst.setString(2,employNew.getDept());
			pst.setString(3,employNew.getDesig());
			pst.setInt(4,employNew.getBasic());
			pst.setInt(5,employNew.getEmpno());
			pst.executeUpdate();
			return "Employ Record Updated";
			
		}
		return "Record Not Found";
	}
	private PreparedStatement setString(int i, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public String deleteEmploy(int empno) throws SQLException, ClassNotFoundException{
	Employ employ = SearchEmploy(empno);
	if(employ!=null){
		connection = ConnectionHelper.getConnection();
		String cmd = "delete from Employ where empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		return "Record Deleted";
		
	}
	return "Employ record Not found";
	}
	public String addEmploy(Employ employ) throws SQLException, ClassNotFoundException{
		connection = ConnectionHelper.getConnection();
		
		String cmd = "insert into Employ(name,dept,desig,basic)"   +"valves(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1,employ.getName());
		pst.setString(1,employ.getDept());
		pst.setString(1,employ.getDesig());
		pst.setInt(1,employ.getBasic());
		return "Record Inserted";
		
	}
	public Employ SearchEmploy(int empno)throws ClassNotFoundException,SQLException{
	connection = ConnectionHelper.getConnection();
	String cmd = "select * from Employ where empno=?";
	pst = connection.prepareStatement(cmd);
	pst.setInt(1,empno);
	ResultSet rs = pst.executeQuery();
	Employ employ = null;
	if(rs.next()){
		employ = new Employ();
		employ.setEmpno(rs.getInt("empno"));
		employ.setName(rs.getString("name"));
		employ.setDept(rs.getString("dept"));
		employ.setDesig(rs.getString("desig"));
		employ.setBasic(rs.getInt("empno"));
		
		
	}
	return employ;
}
	public List<Employ> showEmploy() throws ClassNotFoundException, SQLException{
		List<Employ> employList = new ArrayList<Employ>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select*from Employ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		while(rs.next()){
			employ = new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("empno"));
			employList.add(employ);
			
			
		}
		return employList;
			
		
	}

}
                