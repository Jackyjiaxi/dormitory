package jl.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jl.utils.DbUtil;

public class Health {
	private int he_id;//卫生检查ID
	private String do_section;//宿舍区栋
	private int do_number;//宿舍号
	private String he_person;//检查人
	private String he_result;//检查结果
	private String he_date;//检查日期
	private String he_remark;//备注
	public int getHe_id() {
		return he_id;
	}
	public void setHe_id(int he_id) {
		this.he_id = he_id;
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
	public String getHe_person() {
		return he_person;
	}
	public void setHe_person(String he_person) {
		this.he_person = he_person;
	}
	public String getHe_result() {
		return he_result;
	}
	public void setHe_result(String he_result) {
		this.he_result = he_result;
	}
	public String getHe_date() {
		return he_date;
	}
	public void setHe_date(String he_date) {
		this.he_date = he_date;
	}
	public String getHe_remark() {
		return he_remark;
	}
	public void setHe_remark(String he_remark) {
		this.he_remark = he_remark;
	}
	//数据库操作
	//添加记录
	public int insert(int id,String section,int number,String person,String result,String date,String remark)
	{
		String sql="INSERT INTO health(he_id,do_section,do_number,he_person,he_result,he_date,he_remark) "
				+ "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int back=0;
		try {
			ps.setInt(1,id);
			ps.setString(2,section);
			ps.setInt(3,number);
			ps.setString(4,person);
			ps.setString(5,result);
			ps.setString(6,date);
			ps.setString(7,remark);
			System.out.println("执行insert，sql="+sql);
			back=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return back;
	}
	//根据记录ID删除
	public int delete(int id) 
	{
		String sql="DELETE FROM health WHERE he_id="+id;
		System.out.println("执行delete，sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据ID修改记录
	public int update(int id,String section,int number,String person,String result,String date,String remark)
	{
		String sql="UPDATE health SET do_section='"+section+"',";
					sql+="do_number="+number+",";
					sql+="he_person='"+person+"',";
					sql+="he_result='"+result+"',";
					sql+="he_date='"+date+"',";
					sql+="he_remark='"+remark+"'";
					sql+=" WHERE he_id="+id;
		System.out.println("执行update，sql="+sql);
		int back=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return back;
	}
	//根据条件查询记录
	public ResultSet query(String section1,String section2,String numberStr,String personStr,String resultStr)
	{
		String section=null;
		String number=null;
		String person=null;
		String result=null;
		if(section2.equals("请选择")) {
			section="do_section LIKE '"+section1+"%'"+" AND ";
		}else {
			section="do_section='"+section1+section2+"'"+" AND ";
		}
		if(numberStr.equals("请输入数值")) {
			number="";
		}else {
			number="do_number="+numberStr+" AND ";
		}
		if(personStr.equals("请输入")) {
			person="";
		}else {
			person="he_person='"+personStr+"' AND ";
		}
		if(resultStr.equals("请选择")) {
			result="he_result LIKE '%%'";
		}else if(resultStr.equals("优秀")) {
			result="he_result='优秀'";
		}else if(resultStr.equals("良好")) {
			result="he_result='良好'";
		}else if(resultStr.equals("合格")) {
			result="he_result='合格'";
		}else {
			result="he_result='不合格'";
		}
		String sql="SELECT * FROM health WHERE "+section+number+person+result;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//查询所有记录
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM health"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//求和
	public int[] sumInfo()
	{
		int[] result= {0,0,0,0};
		String sql="SELECT * FROM health"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		try {
			while(rs.next()) {
				if(rs.getString("he_result").equals("优秀"))
				{
					result[0]++;
				}else if(rs.getString("he_result").equals("良好"))
				{
					result[1]++;
				}else if(rs.getString("he_result").equals("合格"))
				{
					result[2]++;
				}else {
					result[3]++;
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//按条件求和
	public int[] sumInfo1(String section1,String section2,String numberStr,String personStr,String resultStr)
	{
		
		int[] back= {0,0,0,0};
		String section=null;
		String number=null;
		String person=null;
		String result=null;
		if(section2.equals("请选择")) {
			section="do_section LIKE '"+section1+"%'"+" AND ";
		}else {
			section="do_section='"+section1+section2+"'"+" AND ";
		}
		if(numberStr.equals("请输入数值")) {
			number="";
		}else {
			number="do_number="+numberStr+" AND ";
		}
		if(personStr.equals("请输入")) {
			person="";
		}else {
			person="he_person='"+personStr+"' AND ";
		}
		if(resultStr.equals("请选择")) {
			result="he_result LIKE '%%'";
		}else if(resultStr.equals("优秀")) {
			result="he_result='优秀'";
		}else if(resultStr.equals("良好")) {
			result="he_result='良好'";
		}else if(resultStr.equals("合格")) {
			result="he_result='合格'";
		}else {
			result="he_result='不合格'";
		}
		String sql="SELECT * FROM health WHERE "+section+number+person+result;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		try {
			while(rs.next()) {
				if(rs.getString("he_result").equals("优秀"))
				{
					back[0]++;
				}else if(rs.getString("he_result").equals("良好"))
				{
					back[1]++;
				}else if(rs.getString("he_result").equals("合格"))
				{
					back[2]++;
				}else {
					back[3]++;
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DbUtil.close();
		return back;
	}
	//获取表格最后一条数据的id
	public int getLastId()
	{
		String sql="SELECT * FROM health";
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try{
			if(rs.last())
			{
				result=Integer.parseInt(rs.getString("he_id"));
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
}
