package jl.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jl.utils.DbUtil;

public class Repairs {
	private int re_id;//报修Id
	private String do_section;//宿舍区栋
	private int do_number;//宿舍号
	private String re_item;//报修项目
	private String re_date;//报修日期
	private String re_reason;//报修原因
	private String re_name;//报修人
	private String re_phone;//联系方式
	private String re_remark;//备注
	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}
	public String getDo_section() {
		return do_section;
	}
	public void setDo_section(String do_section) {
		this.do_section = do_section;
	}
	public int getDo_number() {
		return do_number;
	}
	public void setDo_number(int do_number) {
		this.do_number = do_number;
	}
	public String getRe_item() {
		return re_item;
	}
	public void setRe_item(String re_item) {
		this.re_item = re_item;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	public String getRe_reason() {
		return re_reason;
	}
	public void setRe_reason(String re_reason) {
		this.re_reason = re_reason;
	}
	public String getRe_name() {
		return re_name;
	}
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	public String getRe_phone() {
		return re_phone;
	}
	public void setRe_phone(String re_phone) {
		this.re_phone = re_phone;
	}
	public String getRe_remark() {
		return re_remark;
	}
	public void setRe_remark(String re_remark) {
		this.re_remark = re_remark;
	}
	//数据库操作
	//添加记录
	public int insert(int id,String section,int number,String item,String date,String reason,String name,String phone,String remark)
	{
		String sql="INSERT INTO repairs(re_id,do_section,do_number,re_item,re_date,re_reason,re_name,re_phone,re_remark) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
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
			System.out.println("执行insert，sql="+sql);
			result=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//根据记录ID删除
	public int delete(int id) 
	{
		String sql="DELETE FROM repairs WHERE re_id="+id;
		System.out.println("执行delete，sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据ID修改记录
	public int update(int id,String section,int number,String item,String date,String reason,String name,String phone,String remark)
	{
		String sql="UPDATE repairs SET do_section='"+section+"',";
		sql+="do_number="+number+",";
		sql+="re_item='"+item+"',";
		sql+="re_date='"+date+"',";
		sql+="re_reason='"+reason+"',";
		sql+="re_name='"+name+"',";
		sql+="re_phone='"+phone+"',";
		sql+="re_remark='"+remark+"'";
		sql+=" WHERE re_id="+id;
		System.out.println("执行update，sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据条件查询记录
	public ResultSet query(String section1,String section2,String numberStr)
	{
		String section=null;
		String number=null;
		if(section2.equals("请选择")) {
			section="do_section LIKE '"+section1+"%'"+" AND ";
		}else {
			section="do_section='"+section1+section2+"'"+" AND ";
		}
		if(numberStr.equals("请输入数值")) {
			number="do_number LIKE '%%'";
		}else {
			number="do_number="+numberStr;
		}
		String sql="SELECT * FROM repairs WHERE "+section+number;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//查询所有记录
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM repairs"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//根据id查询记录
	public ResultSet queryById(int id)
	{
		String sql="SELECT * FROM repairs WHERE re_id="+id; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//获取表格最后一条数据的id
	public int getLastId()
	{
		String sql="SELECT * FROM repairs";
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try{
			if(rs.last())
			{
				result=Integer.parseInt(rs.getString("re_id"));
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
}
