package jl.bean;

import java.sql.*;

import jl.utils.DbUtil;

public class Admin {
	private String ad_username;//用户名
	private String ad_password;//密码
	private String ad_usertype;//用户类型
	private String ad_name;//姓名
	private String ad_phone;//联系方式
	public String getAd_username() {
		return ad_username;
	}
	public void setAd_username(String ad_username) {
		this.ad_username = ad_username;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	public String getAd_usertype() {
		return ad_usertype;
	}
	public void setAd_usertype(String ad_usertype) {
		this.ad_usertype = ad_usertype;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_phone() {
		return ad_phone;
	}
	public void setAd_phone(String ad_phone) {
		this.ad_phone = ad_phone;
	}
	//数据库操作
	//用户名登录验证
	public boolean login(String username,String password)
	{
		String sql="SELECT count(*) AS NUM FROM administrator WHERE ad_username='"+username
				         +"' AND ad_password='"+password+"'";
		System.out.println("进行用户名和密码匹配查询，sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try {
			if(rs.next())
			{
				result=rs.getInt("NUM");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result>0? true:false;
	}
	//用户类型登录验证
	public boolean usertypeCheck(String username,String usertype)
	{
		String sql="SELECT count(*) AS NUM FROM administrator WHERE ad_username='"+username
				         +"' AND ad_usertype='"+usertype+"'";
		System.out.println("进行用户名和用户类型匹配查询，sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try {
			if(rs.next())
			{
				result=rs.getInt("NUM");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result>0? true:false;
	}
	//密码验证
	public boolean passwordCheck(String username,String formerPwd)
	{
		String sql="SELECT count(*) AS NUM FROM administrator WHERE ad_username='"+username
				         +"' AND ad_password='"+formerPwd+"'";
		System.out.println("进行密码验证查询，sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try {
			if(rs.next())
			{
				result=rs.getInt("NUM");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result>0? true:false;
	}
	//添加用户
	public int insert(String username,String password,String usertype,String name,String phone)
	{
		String sql="INSERT INTO administrator(ad_username,ad_password,ad_usertype,ad_name,ad_phone) "
					   + "VALUES(?,?,?,?,?)";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int result=0;
		try {
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,usertype);
			ps.setString(4,name);
			ps.setString(5,phone);
			System.out.println("执行insert，sql="+sql);
			result=ps.executeUpdate();
			ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		DbUtil.close();
		return result;
	}
	//根据用户名删除
	public int delete(String username) 
	{
		String sql="DELETE FROM administrator WHERE ad_username='"+username+"'";
		System.out.println("执行delete，sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据用户名修改用户信息
	public int update(String username,String name,String phone)
	{
		String sql="UPDATE administrator SET ad_name='"+name+"',";
				sql+="ad_phone='"+phone+"' WHERE ad_username='";
				sql+=username+"'";
		System.out.println("执行update，sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据用户名修改密码
	public int updatePwd(String username,String newPwd)
	{
		String sql="UPDATE administrator SET ad_password='"+newPwd+"' ";
				sql+="WHERE ad_username='"+username+"'";
		System.out.println("执行update，sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据条件查询用户信息
	public ResultSet query(String type,String keyword)
	{
		String sql="SELECT * FROM administrator";
		System.out.println("执行select,sql="+sql);
		if(keyword!=null)
		{
			sql="SELECT * FROM administrator WHERE "+type+" LIKE '%"+keyword+"%';";//模糊查询
			System.out.println("执行select,sql="+sql);
		}
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
}
