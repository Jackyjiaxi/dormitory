package jl.utils;
import java.sql.*;
public class DbUtil {
	private static final String user="root";
	private static final String password="08958631";
	private static final String url="jdbc:mysql://localhost:3306/dormitorydb";
	protected static Statement s=null;
	protected static ResultSet rs=null;
	protected static Connection conn=null;
	//连接数据库
	public static synchronized Connection getConnection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("mysql数据库驱动加载成功");
			conn=DriverManager.getConnection(url, user, password);
			if(conn!=null)
			{
				System.out.println("数据库连接成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库连接
	public static void close()
	{
		try {
			if(s!=null)
				s.close();
			if(rs!=null)
				rs.close();
			if(conn!=null)
			{
				conn.close();
				conn=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//执行insert、update、delete语句，返回数据更新的条数
	public static int executeUpdate(String sql)
	{
		int result=0;
		try {
			System.out.println("进行数据库增、删或改操作，sql = " + sql);
			s=getConnection().createStatement();
			result=s.executeUpdate(sql);
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}
	//执行select语句，返回查询结果集
	public static ResultSet executeQuery(String sql)
	{
		try {
			System.out.println("进行数据库查询操作，sql = " + sql);
			s=getConnection().createStatement();
			rs=s.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//执行动态SQL语句
	public static PreparedStatement executePreparedStatement(String sql)
	{
		PreparedStatement ps=null;
		try {
			ps=getConnection().prepareStatement(sql);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return ps;
	}
	//事务回滚
	public static void rollback()
	{
		try {
			getConnection().rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
