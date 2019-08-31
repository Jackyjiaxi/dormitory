package jl.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertype=request.getParameter("usertype");
		HttpSession session = request.getSession();
		if(username!=null&&password!=null&&usertype!=null) 
		{
			if(DaoFactory.getAdminInstance().login(username, password)) 
			{
				if(DaoFactory.getAdminInstance().usertypeCheck(username, usertype))
				{
					if(usertype.equals("π‹¿Ì‘±"))
					{
						response.sendRedirect("Admin/welcome.jsp");
						session.setAttribute("username",username );
					}else
					{
						response.sendRedirect("Student/welcome.jsp");
						session.setAttribute("username",username );
					}
				}else
				{
					response.sendRedirect("error/loginError.jsp");
				}
			}else 
			{
				response.sendRedirect("error/loginError.jsp");
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
