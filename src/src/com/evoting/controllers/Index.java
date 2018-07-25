package com.evoting.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evoting.model.Election;
import com.evoting.model.Voter;
import com.evoting.service.ElectionService;
import com.evoting.service.VoterService;


/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	VoterService vs;
	@EJB
	ElectionService es;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Voter> vList=vs.getAllVoters();
		request.setAttribute("voters_list", vList);
		
		
		
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/Index.jsp");
		view.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
	Integer electionId=(Integer)request.getSession().getAttribute("election_id");
	
		Integer flag= vs.validate(username, password);
		 if(flag == electionId)
		 {
			 HttpSession session1 = request.getSession(true);       
			 session1.setAttribute("id",flag); 
			
			 response.sendRedirect("Dashboard");
		 }
		 else
		 {
			 System.out.println("Login Failed!");
			 request.setAttribute("login_failed", "yes");
			 doGet(request, response);
		 }	
	}

}
