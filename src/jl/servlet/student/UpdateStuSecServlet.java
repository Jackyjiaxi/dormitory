package jl.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class UpdateStuSecServlet
 */
@WebServlet("/UpdateStuSecServlet")
public class UpdateStuSecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStuSecServlet() {
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
		String forSection=request.getParameter("forSection");
		int forNumber=Integer.valueOf(request.getParameter("forNumber"));
		String section=request.getParameter("dorSection1")+request.getParameter("dorSection2");
		int number=Integer.valueOf(request.getParameter("dorNumber"));
		if(DaoFactory.getDormitoryInstance().studentChange(forSection, forNumber, section, number))
		{
			if(DaoFactory.getStudentInstance().updateSN(id, section, number)>0)
			{
				response.sendRedirect("Admin/studentChange.jsp"); 
			}
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
