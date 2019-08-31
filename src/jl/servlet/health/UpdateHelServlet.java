package jl.servlet.health;

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
 * Servlet implementation class UpdateHelServlet
 */
@WebServlet("/UpdateHelServlet")
public class UpdateHelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHelServlet() {
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
		String person=request.getParameter("upPerson");
		String result=request.getParameter("upResult");
		String date=request.getParameter("upDate");
		String remark=request.getParameter("upRemark");
		if(DaoFactory.getHealthInstance().update(did, section, number, person, result, date, remark)>0)
		{
			ResultSet rs=DaoFactory.getHealthInstance().queryAll();
			int[] sumInfo=DaoFactory.getHealthInstance().sumInfo();
			StringBuffer sb=new StringBuffer();
			try {
				while(rs.next())
				{
					String id=rs.getString("he_id");
					sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(id);
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_section"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("do_number"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("he_person"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("he_result"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("he_date"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
					sb.append(rs.getString("he_remark"));
					sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE4'>");
					sb.append("<a href='updateHealth.jsp?id="+id+"'><button name='btn_update' type='button' class='btn_update'>�༭</button></a>");
					sb.append("&nbsp;");
					sb.append("<a href='../DeleteHelServlet?id="+id+"'><button name='btn_delete' type='button' class='btn_delete'>ɾ��</button></a>");
					sb.append("</span></div></td></tr>");
				}
				rs.close();
				sb.append("<tr><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("�ϼ�");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("���㣺"+String.valueOf(sumInfo[0])+"��");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("���ã�"+String.valueOf(sumInfo[1])+"��");
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("�ϸ�"+String.valueOf(sumInfo[2])+"��"); 
				sb.append("</span></div></td><td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE2'>");
				sb.append("���ϸ�"+String.valueOf(sumInfo[3])+"��");
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
			response.sendRedirect("Admin/healthInfo.jsp"); 
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
