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
 * Servlet implementation class UpdateStuInfoServlet
 */
@WebServlet("/DeleteStuInfoServlet")
public class DeleteStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStuInfoServlet() {
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
		int id=Integer.valueOf(request.getParameter("stuId"));
		ResultSet rs=DaoFactory.getStudentInstance().queryById(id);
		HttpSession session=request.getSession();
		session.setAttribute("st_id", id);
		try {
			if(rs.next())
			{
				session.setAttribute("st_school",rs.getString("st_school"));
				session.setAttribute("st_major",rs.getString("st_major") );
				session.setAttribute("st_name",rs.getString("st_name"));
				session.setAttribute("st_phone",rs.getString("st_phone"));
				session.setAttribute("do_section",rs.getString("do_section"));
				session.setAttribute("do_number",rs.getString("do_number"));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Admin/studentLeave.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
