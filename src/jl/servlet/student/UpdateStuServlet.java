package jl.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class UpdateStuServlet
 */
@WebServlet("/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStuServlet() {
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
		int id=Integer.parseInt(request.getParameter("stuId"));
		String name=request.getParameter("stuName");
		String gender=request.getParameter("stuGender");
		String nativeplace=request.getParameter("stuNativeplace");
		String birthday=request.getParameter("stuBirthday");
		String school=request.getParameter("stuSchool");
		String major=request.getParameter("stuMajor");
		String enrolltime=request.getParameter("stuEnrolltime");
		String length=request.getParameter("stuLength");
		String education=request.getParameter("stuEducation");
		String phone=request.getParameter("stuPhone");
		String remark=request.getParameter("stuRemark");
		if(DaoFactory.getStudentInstance().update(id, name, gender, nativeplace, birthday, school, major, enrolltime, length, education, phone, remark)>0)
		{
			response.sendRedirect("Student/updateStudent.jsp"); 
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
