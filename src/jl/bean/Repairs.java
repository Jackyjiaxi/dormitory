package jl.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jl.utils.DbUtil;

public class Repairs {
	private int re_id;//����Id
	private String do_section;//��������
	private int do_number;//�����
	private String re_item;//������Ŀ
	private String re_date;//��������
	private String re_reason;//����ԭ��
	private String re_name;//������
	private String re_phone;//��ϵ��ʽ
	private String re_remark;//��ע
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
	//���ݿ����
	//��Ӽ�¼
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
			System.out.println("ִ��insert��sql="+sql);
			result=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//���ݼ�¼IDɾ��
	public int delete(int id) 
	{
		String sql="DELETE FROM repairs WHERE re_id="+id;
		System.out.println("ִ��delete��sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//����ID�޸ļ�¼
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
		System.out.println("ִ��update��sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//����������ѯ��¼
	public ResultSet query(String section1,String section2,String numberStr)
	{
		String section=null;
		String number=null;
		if(section2.equals("��ѡ��")) {
			section="do_section LIKE '"+section1+"%'"+" AND ";
		}else {
			section="do_section='"+section1+section2+"'"+" AND ";
		}
		if(numberStr.equals("��������ֵ")) {
			number="do_number LIKE '%%'";
		}else {
			number="do_number="+numberStr;
		}
		String sql="SELECT * FROM repairs WHERE "+section+number;
		System.out.println("ִ��select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//��ѯ���м�¼
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM repairs"; 
		System.out.println("ִ��select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//����id��ѯ��¼
	public ResultSet queryById(int id)
	{
		String sql="SELECT * FROM repairs WHERE re_id="+id; 
		System.out.println("ִ��select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//��ȡ������һ�����ݵ�id
	public int getLastId()
	{
		String sql="SELECT * FROM repairs";
		System.out.println("ִ��select,sql="+sql);
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
