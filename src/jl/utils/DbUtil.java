package jl.utils;
import java.sql.*;
public class DbUtil {
	private static final String user="root";
	private static final String password="08958631";
	private static final String url="jdbc:mysql://localhost:3306/dormitorydb";
	protected static Statement s=null;
	protected static ResultSet rs=null;
	protected static Connection conn=null;
	//�������ݿ�
	public static synchronized Connection getConnection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("mysql���ݿ��������سɹ�");
			conn=DriverManager.getConnection(url, user, password);
			if(conn!=null)
			{
				System.out.println("���ݿ����ӳɹ�");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ�����
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
	//ִ��insert��update��delete��䣬�������ݸ��µ�����
	public static int executeUpdate(String sql)
	{
		int result=0;
		try {
			System.out.println("�������ݿ�����ɾ��Ĳ�����sql = " + sql);
			s=getConnection().createStatement();
			result=s.executeUpdate(sql);
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}
	//ִ��select��䣬���ز�ѯ�����
	public static ResultSet executeQuery(String sql)
	{
		try {
			System.out.println("�������ݿ��ѯ������sql = " + sql);
			s=getConnection().createStatement();
			rs=s.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//ִ�ж�̬SQL���
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
	//����ع�
	public static void rollback()
	{
		try {
			getConnection().rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
