package jl.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class AddStuServlet
 */
@WebServlet("/AddStuServlet")
public class AddStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStuServlet() {
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
		int getid=0;
		getid=DaoFactory.getStudentInstance().getLastId();//获取最后一行数据的id值
		int id=getid+1;//id自增
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
		String section=request.getParameter("dorSection1")+request.getParameter("dorSection2");
		int number=Integer.parseInt(request.getParameter("dorNumber")); 
		if(DaoFactory.getDormitoryInstance().addStudent(section, number))
		{
			if(DaoFactory.getStudentInstance().insert(id, name, gender, nativeplace, birthday, school, major, enrolltime, length, education, 
																				phone, remark, section, number)>0)
			{	
				response.sendRedirect("Admin/addStudent.jsp"); 
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
