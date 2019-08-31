package jl.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jl.utils.DbUtil;

public class Student {
	private int st_id;//ѧ��
	private String st_name;//����
	private String st_gender;//�Ա�
	private String st_nativeplace;//����
	private String st_birthday;//����
	private String st_school;//ѧԺ
	private String st_major;//רҵ
	private String st_enrolltime;//��ѧ����
	private String st_length;//ѧ��
	private String st_education;//ѧ��
	private String st_phone;//��ϵ��ʽ
	private String st_remark;//��ע
	private String do_section;//��������
	private int do_number;//�����
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
	//���ݿ����
	//���ѧ����Ϣ
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
			System.out.println("ִ��insert��sql="+sql);
			result=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//����ѧ��ɾ��
	public int delete(int id) 
	{
		String sql="DELETE FROM student WHERE st_id="+id;
		System.out.println("ִ��delete��sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//����ѧ���޸�ѧ����Ϣ
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
		System.out.println("ִ��update��sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//����������ѯѧ����Ϣ
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
		if(section2.equals("��ѡ��")) {
			section="do_section LIKE '"+section1+"%'"+" AND ";
		}else {
			section="do_section='"+section1+section2+"'"+" AND ";
		}
		if(numberStr.equals("��������ֵ")) {
			number="";
		}else {
			number="do_number="+numberStr+" AND ";
		}
		if(idStr.equals("��������ֵ")) {
			id="";
		}else {
			id="st_id="+idStr+" AND ";
		}
		if(schoolStr.equals("������")) {
			school="";
		}else {
			school="st_school='"+schoolStr+"' AND ";
		}
		if(majorStr.equals("������")) {
			major="";
		}else {
			major="st_major='"+majorStr+"' AND ";
		}
		if(nameStr.equals("������")) {
			name="";
		}else {
			name="st_name='"+nameStr+"' AND ";
		}
		if(genderStr.equals("��ѡ��")) {
			gender="st_gender LIKE '%%'"+" AND ";
		}else if(genderStr.equals("��")) {
			gender="st_gender='��' AND ";
		}else {
			gender="st_gender='Ů' AND ";
		}
		if(educationStr.equals("��ѡ��")) {
			education="st_education LIKE '%%'";
		}else if(educationStr.equals("�����ڶ�")) {
			education="st_education='�����ڶ�'";
		}else {
			education="st_education='�о����ڶ�'";
		}
		String sql="SELECT * FROM student WHERE "+section+number+id+school+major+name+gender+education;
		System.out.println("ִ��select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//��ѯ����ѧ����Ϣ
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM student"; 
		System.out.println("ִ��select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//����ѧ���޸���Ϣ
	public int updateSN(int id,String section,int number)
	{
		String sql="UPDATE student SET do_section='"+section+"',";
		sql+="do_number="+number+" WHERE st_id="+id;
		System.out.println("ִ��update��sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//����id��ѯѧ����Ϣ
	public ResultSet queryById(int id)
	{
		String sql="SELECT * FROM student WHERE st_id="+id; 
		System.out.println("ִ��select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//��ȡ������һ�����ݵ�id
	public int getLastId()
	{
		String sql="SELECT * FROM student";
		System.out.println("ִ��select,sql="+sql);
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
