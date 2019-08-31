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
 * Servlet implementation class CombineServlet
 */
@WebServlet("/CombineServlet")
public class CombineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CombineServlet() {
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
		int getid=Integer.parseInt(session.getAttribute("re_id").toString()); //Î¬ÐÞ¼ÇÂ¼ID
		int getid1=Integer.parseInt(request.getParameter("id")); //Î¬ÐÞ¹¤ID
		ResultSet rs=DaoFactory.getRepairsInstance().queryById(getid);
		String[] info=DaoFactory.getRepairsmanInstance().query(getid1).split(":");
		int id=0;
		String section=null;
		int number=0;
		String item=null;
		String date=null;
		String reason=null;
		String name=null;
		String phone=null;
		String remark=null;
		try {
			if(rs.next())
			{
				id=Integer.parseInt(rs.getString("re_id"));
				section=rs.getString("do_section");
				number=Integer.parseInt(rs.getString("do_number"));
				item=rs.getString("re_item");
				date=rs.getString("re_date");
				reason=rs.getString("re_reason");
				name=rs.getString("re_name");
				phone=rs.getString("re_phone");
				remark=rs.getString("re_remark");
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(DaoFactory.getRepairsmanInstance().insert(id, section, number, item, date, reason, name, phone, remark, info[0],info[1])>0)
		{
			response.sendRedirect("Admin/repairsMan.jsp"); 
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
