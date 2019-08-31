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
 * Servlet implementation class QueryallRmServlet
 */
@WebServlet("/QueryallRmServlet")
public class QueryallRmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryallRmServlet() {
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
		ResultSet rs=DaoFactory.getRepairsmanInstance().queryAll();
		StringBuffer sb=new StringBuffer();
		try {
			while(rs.next())
			{
				String id=rs.getString("rm_id");
				sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(id);
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("rm_name"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("rm_phone"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append(rs.getString("rm_major"));
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE4'>");
				sb.append("<a href='../CombineServlet?id="+id+"'><button name='btn_choose' type='button' class='btn_choose'>бЁжа</button></a>");
				sb.append("</span></div></td></tr>");
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("re_id", request.getParameter("id")); 
		session.setAttribute("query", sb);
		response.sendRedirect("Admin/repairsMan.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
