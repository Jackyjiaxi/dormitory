package jl.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jl.utils.DbUtil;

public class Student {
	private int st_id;//学号
	private String st_name;//姓名
	private String st_gender;//性别
	private String st_nativeplace;//籍贯
	private String st_birthday;//生日
	private String st_school;//学院
	private String st_major;//专业
	private String st_enrolltime;//入学日期
	private String st_length;//学制
	private String st_education;//学历
	private String st_phone;//联系方式
	private String st_remark;//备注
	private String do_section;//宿舍区栋
	private int do_number;//宿舍号
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_gender() {
		return st_gender;
	}
	public void setSt_gender(String st_gender) {
		this.st_gender = st_gender;
	}
	public String getSt_nativeplace() {
		return st_nativeplace;
	}
	public void setSt_nativeplace(String st_nativeplace) {
		this.st_nativeplace = st_nativeplace;
	}
	public String getSt_birthday() {
		return st_birthday;
	}
	public void setSt_birthday(String st_birthday) {
		this.st_birthday = st_birthday;
	}
	public String getSt_school() {
		return st_school;
	}
	public void setSt_school(String st_school) {
		this.st_school = st_school;
	}
	public String getSt_major() {
		return st_major;
	}
	public void setSt_major(String st_major) {
		this.st_major = st_major;
	}
	public String getSt_enrolltime() {
		return st_enrolltime;
	}
	public void setSt_enrolltime(String st_enrolltime) {
		this.st_enrolltime = st_enrolltime;
	}
	public String getSt_length() {
		return st_length;
	}
	public void setSt_length(String st_length) {
		this.st_length = st_length;
	}
	public String getSt_education() {
		return st_education;
	}
	public void setSt_education(String st_education) {
		this.st_education = st_education;
	}
	public String getSt_phone() {
		return st_phone;
	}
	public void setSt_phone(String st_phone) {
		this.st_phone = st_phone;
	}
	public String getSt_remark() {
		return st_remark;
	}
	public void setSt_remark(String st_remark) {
		this.st_remark = st_remark;
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
	//数据库操作
	//添加学生信息
	public int insert(int id,String name,String gender,String nativeplace,String birthday,String school,String major,
			String enrolltime,String length,String education,String phone,String remark,String section,int number)
	{
		String sql="INSERT INTO student(st_id,st_name,st_gender,st_nativeplace,st_birthday,st_school,st_major,st_enrolltime,st_length,"
								+ "st_education,st_phone,st_remark,do_section,do_number) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int result=0;
		try {
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,gender);
			ps.setString(4,nativeplace);
			ps.setString(5,birthday);
			ps.setString(6,school);
			ps.setString(7,major);
			ps.setString(8,enrolltime);
			ps.setString(9,length);
			ps.setString(10,education);
			ps.setString(11,phone);
			ps.setString(12,remark);
			ps.setString(13,section);
			ps.setInt(14,number);
			System.out.println("执行insert，sql="+sql);
			result=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//根据学号删除
	public int delete(int id) 
	{
		String sql="DELETE FROM student WHERE st_id="+id;
		System.out.println("执行delete，sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据学号修改学生信息
	public int update(int id,String name,String gender,String nativeplace,String birthday,String school,String major,String enrolltime,String length,String education,String phone,String remark)
	{
		String sql="UPDATE student SET st_name='"+name+"',";
		sql+="st_gender='"+gender+"',";
		sql+="st_nativeplace='"+nativeplace+"',";
		sql+="st_birthday='"+birthday+"',";
		sql+="st_school='"+school+"',";
		sql+="st_major='"+major+"',";
		sql+="st_enrolltime='"+enrolltime+"',";
		sql+="st_length='"+length+"',";
		sql+="st_education='"+education+"',";
		sql+="st_phone='"+phone+"',";
		sql+="st_remark='"+remark+"' WHERE st_id="+id;
		System.out.println("执行update，sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据条件查询学生信息
	public ResultSet query(String idStr,String nameStr,String genderStr,String schoolStr,String majorStr,
										String educationStr,String section1,String section2,String numberStr)
	{
		String id=null;
		String name=null;
		String gender=null;
		String school=null;
		String major=null;
		String education=null;
		String section=null;
		String number=null;
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
		if(idStr.equals("请输入数值")) {
			id="";
		}else {
			id="st_id="+idStr+" AND ";
		}
		if(schoolStr.equals("请输入")) {
			school="";
		}else {
			school="st_school='"+schoolStr+"' AND ";
		}
		if(majorStr.equals("请输入")) {
			major="";
		}else {
			major="st_major='"+majorStr+"' AND ";
		}
		if(nameStr.equals("请输入")) {
			name="";
		}else {
			name="st_name='"+nameStr+"' AND ";
		}
		if(genderStr.equals("请选择")) {
			gender="st_gender LIKE '%%'"+" AND ";
		}else if(genderStr.equals("男")) {
			gender="st_gender='男' AND ";
		}else {
			gender="st_gender='女' AND ";
		}
		if(educationStr.equals("请选择")) {
			education="st_education LIKE '%%'";
		}else if(educationStr.equals("本科在读")) {
			education="st_education='本科在读'";
		}else {
			education="st_education='研究生在读'";
		}
		String sql="SELECT * FROM student WHERE "+section+number+id+school+major+name+gender+education;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//查询所有学生信息
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM student"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//根据学号修改信息
	public int updateSN(int id,String section,int number)
	{
		String sql="UPDATE student SET do_section='"+section+"',";
		sql+="do_number="+number+" WHERE st_id="+id;
		System.out.println("执行update，sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据id查询学生信息
	public ResultSet queryById(int id)
	{
		String sql="SELECT * FROM student WHERE st_id="+id; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//获取表格最后一条数据的id
	public int getLastId()
	{
		String sql="SELECT * FROM student";
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try{
			if(rs.last())
			{
				result=Integer.parseInt(rs.getString("st_id"));
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
}
