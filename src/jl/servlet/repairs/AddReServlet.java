package jl.servlet.repairs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class AddReServlet
 */
@WebServlet("/AddReServlet")
public class AddReServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReServlet() {
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
		getid=DaoFactory.getRepairsInstance().getLastId();//获取最后一行数据的id值
		int id=getid+1;//id自增
		String section=request.getParameter("dorSection1")+request.getParameter("dorSection2");
		int number=Integer.parseInt(request.getParameter("dorNumber"));
		String item=request.getParameter("reItem");
		String date=request.getParameter("reDate");
		String reason=request.getParameter("reReason");
		String name=request.getParameter("reName");
		String phone=request.getParameter("rePhone");
		String remark=request.getParameter("reRemark");
		if(DaoFactory.getRepairsInstance().insert(id, section, number, item, date, reason, name, phone, remark)>0)
		{
			response.sendRedirect("Student/addRepairs.jsp"); 
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
