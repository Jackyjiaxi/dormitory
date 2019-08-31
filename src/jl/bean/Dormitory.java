package jl.bean;

import java.sql.*;

import jl.utils.DbUtil;

public class Dormitory {
	private int do_id;//宿舍ID
	private String do_section;//宿舍区栋
	private int do_number;//宿舍号
	private int do_bed;//宿舍床位数
	private int do_emptybeds;//宿舍空闲床位数
	private String do_type;//宿舍类型
	private String do_water;//宿舍水表底数
	private String do_elec;//宿舍电表底数
	private String do_remark;//备注 
	public int getDo_id() {
		return do_id;
	}
	public void setDo_id(int do_id) {
		this.do_id = do_id;
	}
	public int getDo_number() {
		return do_number;
	}
	public void setDo_number(int do_number) {
		this.do_number = do_number;
	}
	public String getDo_section() {
		return do_section;
	}
	public void setDo_section(String do_section) {
		this.do_section = do_section;
	}
	public String getDo_type() {
		return do_type;
	}
	public void setDo_type(String do_type) {
		this.do_type = do_type;
	}
	public int getDo_bed() {
		return do_bed;
	}
	public void setDo_bed(int do_bed) {
		this.do_bed = do_bed;
	}
	public int getDo_emptybeds() {
		return do_emptybeds;
	}
	public void setDo_emptybeds(int do_emptybeds) {
		this.do_emptybeds = do_emptybeds;
	}
	public String getDo_water() {
		return do_water;
	}
	public void setDo_water(String do_water) {
		this.do_water = do_water;
	}
	public String getDo_elec() {
		return do_elec;
	}
	public void setDo_elec(String do_elec) {
		this.do_elec = do_elec;
	}
	public String getDo_remark() {
		return do_remark;
	}
	public void setDo_remark(String do_remark) {
		this.do_remark = do_remark;
	}
	//添加宿舍信息
	public int insert(int id,String section,int number,int bed,int emptybeds,String type,String water,String elec,String remark)
	{
		String sql="INSERT INTO dormitory(do_id,do_section,do_number,do_bed,do_emptybeds,do_type,do_water,do_elec,do_remark) "
					   + "VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int result=0;
		try {
			ps.setInt(1,id);
			ps.setString(2,section);
			ps.setInt(3,number);
			ps.setInt(4,bed);
			ps.setInt(5,emptybeds);
			ps.setString(6,type);
			ps.setString(7,water);
			ps.setString(8,elec);
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
	//根据宿舍ID删除
	public int delete(int id) 
	{
		String sql="DELETE FROM dormitory WHERE do_id='"+id+"'";
		System.out.println("执行delete，sql="+sql);
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据宿舍ID修改宿舍信息
	public int update(int id,String section,int number,int bed,int emptybeds,String type,String water,String elec,String remark)
	{
		String sql="UPDATE dormitory SET do_section='"+section+"',";
				sql+="do_number='"+number+"',";
				sql+="do_bed='"+bed+"',";
				sql+="do_emptybeds='"+emptybeds+"',";
				sql+="do_type='"+type+"',";
				sql+="do_water='"+water+"',";
				sql+="do_elec='"+elec+"',";
				sql+="do_remark='"+remark+"' WHERE do_id='";
				sql+=id+"'";
		System.out.println("执行update，sql="+sql);
		int result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	//根据条件查询宿舍信息
	public ResultSet query(String section1,String section2,String numberStr,String bedStr,String emptybedsStr,String typeStr)
	{
		String section=null;
		String number=null;
		String bed=null;
		String emptybeds=null;
		String type=null;
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
		if(bedStr.equals("请输入数值")) {
			bed="";
		}else {
			bed="do_bed="+bedStr+" AND ";
		}
		if(emptybedsStr.equals("请选择")) {
			emptybeds="do_emptybeds>=0"+" AND ";
		}else if(emptybedsStr.equals("0")) {
			emptybeds="do_emptybeds=0"+" AND ";
		}else {
			emptybeds="do_emptybeds>0"+" AND ";
		}
		if(typeStr.equals("请选择")) {
			type="do_type LIKE '%%'";
		}else if(typeStr.equals("公寓")) {
			type="do_type='公寓'";
		}else {
			type="do_type='普宿'";
		}
		String sql="SELECT * FROM dormitory WHERE "+section+number+bed+emptybeds+type;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//查询所有宿舍信息
	public ResultSet queryAll()
	{
		String sql="SELECT * FROM dormitory"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		return rs;
	}
	//求和
	public int[] sumInfo()
	{
		int[] result= {0,0};
		String sql="SELECT sum(do_bed) AS bedInt,sum(do_emptybeds) AS emptybedsInt FROM dormitory"; 
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		try {
			if(rs.next()) {
				result[0]=rs.getInt("bedInt");
				result[1]=rs.getInt("emptybedsInt");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//按条件求和
	public int[] sumInfo1(String section1,String section2,String numberStr,String bedStr,String emptybedsStr,String typeStr)
	{
		int[] result= {0,0};
		String section=null;
		String number=null;
		String bed=null;
		String emptybeds=null;
		String type=null;
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
		if(bedStr.equals("请输入数值")) {
			bed="";
		}else {
			bed="do_bed="+bedStr+" AND ";
		}
		if(emptybedsStr.equals("请选择")) {
			emptybeds="do_emptybeds>=0"+" AND ";
		}else if(emptybedsStr.equals("0")) {
			emptybeds="do_emptybeds=0"+" AND ";
		}else {
			emptybeds="do_emptybeds>0"+" AND ";
		}
		if(typeStr.equals("请选择")) {
			type="do_type LIKE '%%'";
		}else if(typeStr.equals("公寓")) {
			type="do_type='公寓'";
		}else {
			type="do_type='普宿'";
		}
		String sql="SELECT sum(do_bed) AS bedInt,sum(do_emptybeds) AS emptybedsInt FROM dormitory WHERE "
							+section+number+bed+emptybeds+type;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		try {
			if(rs.next()) {
				result[0]=rs.getInt("bedInt");
				result[1]=rs.getInt("emptybedsInt");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//获取表格最后一条数据的id
	public int getLastId()
	{
		String sql="SELECT * FROM dormitory";
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int result=0;
		try{
			if(rs.last())
			{
				result=Integer.parseInt(rs.getString("do_id"));
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	//学生入住登记sql事务
	public boolean addStudent(String section,int number)
	{
		String sql="SELECT * FROM dormitory WHERE do_section='"+section+"'";
					sql+=" AND do_number="+number;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int emptybeds=0;
		int result=0;
		try{	
			if(rs.next())
			{	
				result=rs.getInt("do_emptybeds");
				emptybeds=result-1;
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(emptybeds>=0)
		{
			String sql1="UPDATE dormitory SET do_emptybeds="+emptybeds+" WHERE do_section='"+section+"'";
					sql1+=" AND do_number="+number;
			System.out.println("执行update,sql="+sql1);
			if(DbUtil.executeUpdate(sql1)>0) {
				System.out.println("入住登记成功！");
			}
		}else {
			System.out.println("该宿舍已满员！不可入住");
		}
		DbUtil.close();
		return emptybeds<0? false:true;
	}
	//学生调换宿舍sql事务
	public boolean studentChange(String forSection,int forNumber,String section,int number)
	{
		String sql1="SELECT * FROM dormitory WHERE do_section='"+forSection+"' AND do_number="+forNumber;
		System.out.println("执行select,sql1="+sql1);
		ResultSet rs1=DbUtil.executeQuery(sql1);
		String sql2="SELECT * FROM dormitory WHERE do_section='"+section+"' AND do_number="+number;
		System.out.println("执行select,sql2="+sql2);
		ResultSet rs2=DbUtil.executeQuery(sql2);
		int bed1=0;
		int emptybeds1=0;
		int result1=0;
		int emptybeds2=0;
		int result2=0;
		try{
			if(rs1.next())
			{
				bed1=rs1.getInt("do_bed");
				result1=rs1.getInt("do_emptybeds");
				emptybeds1=result1+1;
			}
			if(rs2.next())
			{
				result2=rs2.getInt("do_emptybeds");
				emptybeds2=result2-1;
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if((emptybeds1<=bed1)&&(emptybeds2>=0))
		{	
			String sql3="UPDATE dormitory SET do_emptybeds="+emptybeds1+" WHERE do_section='"+forSection+"'";
			sql3+=" AND do_number="+forNumber;
			System.out.println("执行update,sql3="+sql3);
			String sql4="UPDATE dormitory SET do_emptybeds="+emptybeds2+" WHERE do_section='"+section+"'";
			sql4+=" AND do_number="+number;
			System.out.println("执行update,sql4="+sql4);
			if((DbUtil.executeUpdate(sql3)>0)&&(DbUtil.executeUpdate(sql4)>0))
			{
				System.out.println("宿舍调换成功！");
			}
		}else {
			System.out.println("转出宿舍人数为0或转入宿舍已满员！不可调换");
		}
		DbUtil.close();
		return (emptybeds1<=bed1)&&(emptybeds2>=0)? true:false;
	}
	//学生离校处理sql事务
	public boolean deleteStudent(String section,int number)
	{
		String sql="SELECT * FROM dormitory WHERE do_section='"+section+"'";
		sql+=" AND do_number="+number;
		System.out.println("执行select,sql="+sql);
		ResultSet rs=DbUtil.executeQuery(sql);
		int bed=0;
		int emptybeds=0;
		int result=0;
		try{
			if(rs.next())
			{
				bed=rs.getInt("do_bed");
				result=rs.getInt("do_emptybeds");
				emptybeds=result+1;
			}
			DbUtil.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(emptybeds<=bed)
		{
			String sql1="UPDATE dormitory SET do_emptybeds="+emptybeds+" WHERE do_section='"+section+"'";
			sql1+=" AND do_number="+number;
			System.out.println("执行update,sql1="+sql1);
			if(DbUtil.executeUpdate(sql1)>0)
			{
				System.out.println("离校处理成功！");
			}
		}else {
			System.out.println("该宿舍人数为0！");
		}
		DbUtil.close();
		return emptybeds>bed? false:true;
	}
}
