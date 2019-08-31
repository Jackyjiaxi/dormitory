package jl.servlet.repairs;

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
 * Servlet implementation class QueryallLrServlet
 */
@WebServlet("/QueryallLrServlet")
public class QueryallLrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryallLrServlet() {
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
		ResultSet rs=DaoFactory.getRepairsmanInstance().queryAll1();
		StringBuffer sb=new StringBuffer();
		try {
			while(rs.next())
			{
				String id=rs.getString("re_id");
				sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(id);
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("do_section"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("do_number"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("re_item"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("re_date"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("re_reason"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("re_name"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("re_phone"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("re_remark"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("rm_name"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("rm_phone"));
				sb.append("</span></div></td></tr>");
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("query", sb);
		response.sendRedirect("Admin/repairsInfo.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
