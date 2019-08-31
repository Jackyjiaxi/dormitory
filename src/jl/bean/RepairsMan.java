package jl.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jl.utils.DbUtil;

public class RepairsMan {
	private int rm_id;
	private String rm_name;
	private String rm_phone;
	private String rm_major;
	public int getRm_id() {
		return rm_id;
	}
	public void setRm_id(int rm_id) {
		this.rm_id = rm_id;
	}
	public String getRm_name() {
		return rm_name;
	}
	public void setRm_name(String rm_name) {
		this.rm_name = rm_name;
	}
	public String getRm_phone() {
		return rm_phone;
	}
	public void setRm_phone(String rm_phone) {
		this.rm_phone = rm_phone;
	}
	public String getRm_major() {
		return rm_major;
	}
	public void setRm_major(String rm_major) {
		this.rm_major = rm_major;
	}
	//数据库操作
	//查询所有维修工信息
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM repairsman"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//查询维修工信息
	public String query(int id)
	{
		String result=null;
		String sql="SELECT * FROM repairsman WHERE rm_id="+id; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		try {
			if(rs.next()) {
				result=rs.getString("rm_name")+":"+rs.getString("rm_phone");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//获取表格最后一条数据的id
	public int getLastId()
	{
		String sql="SELECT * FROM repairsman";
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try{
			if(rs.last())
			{
				result=Integer.parseInt(rs.getString("rm_id"));
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//维修工调配事务
	public int insert(int id,String section,int number,String item,String date,String reason,String name,String phone,String remark,String rname,String rphone)
	{
		String sql="INSERT INTO linkrepairs(re_id,do_section,do_number,re_item,re_date,re_reason,re_name,re_phone,re_remark,rm_name,rm_phone) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int result=0;
		try {
			ps.setInt(1,id);
			ps.setString(2,section);
			ps.setInt(3,number);
			ps.setString(4,item);
			ps.setString(5,date);
			ps.setString(6,reason);
			ps.setString(7,name);
			ps.setString(8,phone);
			ps.setString(9,remark);
			ps.setString(10,rname);
			ps.setString(11,rphone);
			System.out.println("执行insert，sql="+sql);
			result=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//查询所有调度信息
	public ResultSet queryAll1()
	{
		String sql="SELECT * FROM linkrepairs"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
}
