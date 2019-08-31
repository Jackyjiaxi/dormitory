package jl.servlet.dormitory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class UpdateDorServlet
 */
@WebServlet("/UpdateDorServlet")
public class UpdateDorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("GB18030");
		response.setContentType("text/html;charset=GB18030");
		HttpSession session=request.getSession();
		int did=Integer.parseInt(session.getAttribute("id").toString());
		String section=request.getParameter("dorSection1")+request.getParameter("dorSection2");
		int number=Integer.parseInt(request.getParameter("upNumber"));
		int bed=Integer.parseInt(request.getParameter("upBed"));
		int emptyBeds=Integer.parseInt(request.getParameter("upEmptybeds"));
		String type=request.getParameter("dorType");
		String water=request.getParameter("upWater");
		String elec=request.getParameter("upElec");
		String remark=request.getParameter("upRemark");
		if(DaoFactory.getDormitoryInstance().update(did, section, number, bed, emptyBeds, type, water, elec, remark)>0)
		{
			ResultSet rs=DaoFactory.getDormitoryInstance().queryAll();
			int[] sumInfo=DaoFactory.getDormitoryInstance().sumInfo();
			StringBuffer sb=new StringBuffer();
			try {
				while(rs.next())
				{
					String id=rs.getString("do_id");
					sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(id);
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_section"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_number"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_bed"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_emptybeds"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_type"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_water"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_elec"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_remark"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE4'>");
					sb.append("<a href='updateDormitory.jsp?id="+id+"'><button name='btn_update' type='button' class='btn_update'>±à¼­</button></a>");
					sb.append("&nbsp;");
					sb.append("<a href='../DeleteDorServlet?id="+id+"'><button name='btn_delete' type='button' class='btn_delete'>É¾³ý</button></a>");
					sb.append("</span></div></td></tr>");
				}
				rs.close();
				sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("ºÏ¼Æ");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(String.valueOf(sumInfo[0])); 
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(String.valueOf(sumInfo[1]));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE4'>");
				sb.append("");
				sb.append("</span></div></td></tr>");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("query", sb);
			response.sendRedirect("Admin/dormitoryInfo.jsp"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
