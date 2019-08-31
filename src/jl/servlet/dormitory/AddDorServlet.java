package jl.servlet.dormitory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jl.factory.DaoFactory;

/**
 * Servlet implementation class AddDorServlet
 */
@WebServlet("/AddDorServlet")
public class AddDorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDorServlet() {
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
		getid=DaoFactory.getDormitoryInstance().getLastId();//获取最后一行数据的id值
		int id=getid+1;//id自增
		String section=request.getParameter("dorSection1")+request.getParameter("dorSection2");
		int number=Integer.parseInt(request.getParameter("dorNumber"));
		int bed=Integer.parseInt(request.getParameter("dorBed"));
		int emptyBeds=Integer.parseInt(request.getParameter("dorEmptyBeds"));
		String type=request.getParameter("dorType");
		String water=request.getParameter("dorWater");
		String elec=request.getParameter("dorElec");
		String remark=request.getParameter("dorRemark");
		if(DaoFactory.getDormitoryInstance().insert(id, section, number, bed, emptyBeds, type, water, elec, remark)>0)
		{
			response.sendRedirect("Admin/addDormitory.jsp"); 
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
