package administrator.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import administrator.model.service.ADM_MemberService;
import administrator.model.vo.Admin;
import administrator.model.vo.Outmember;

/**
 * Servlet implementation class OutmemberListServlet
 */
@WebServlet("/outmem/list")
public class OutmemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutmemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Admin loginAdm = (Admin)session.getAttribute("loginAdmin");
//		String admPwd =loginAdm.getAdm_pwd();
		
		ArrayList<Outmember> list = new ADM_MemberService().selectOutList();
	
		request.setAttribute("list", list);
		//request.setAttribute("admPwd", admPwd);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/admin_outmemList.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
