package jl.servlet.student;

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
 * Servlet implementation class QueryStuServlet
 */
@WebServlet("/QueryStuServlet")
public class QueryStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStuServlet() {
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
		String id=request.getParameter("stuId");
		String name=request.getParameter("stuName");
		String school=request.getParameter("stuSchool");
		String major=request.getParameter("stuMajor");
		String gender=request.getParameter("stuGender");
		String education=request.getParameter("stuEducation");
		String section1=request.getParameter("dorSection1");
		String section2=request.getParameter("dorSection2");
		String number=request.getParameter("dorNumber");
		ResultSet rs=DaoFactory.getStudentInstance().query(id, name, gender, school, major, education, section1, section2, number);
		StringBuffer sb=new StringBuffer();
		try {
			while(rs.next())
			{
				sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_id"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_name"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_gender"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_nativeplace"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_birthday"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_school"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_major"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_enrolltime"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_length"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_education"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_phone"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("st_remark"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("do_section"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("do_number"));
				sb.append("</span></div></td></tr>");
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("query", sb);
		response.sendRedirect("Admin/studentInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
