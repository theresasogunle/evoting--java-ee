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

import com.evoting.model.Candidate;
import com.evoting.model.Category;
import com.evoting.model.Election;

import com.evoting.service.CandidateService;
import com.evoting.service.CategoryService;
import com.evoting.service.ElectionService;

import com.evoting.service.VoterService;

/**
 * 
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ElectionService es;
	
	@EJB
	CandidateService cs;
	
	@EJB
	VoterService vs;
   
	@EJB
	CategoryService cats;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Candidate> cList=cs.getCandidates();
		request.setAttribute("can_list", cList);
		
		List<Election> eList=es.getAllElections();
		request.setAttribute("election_list", eList);
		
		List<Category> catList=cats.getAllCategory();
		request.setAttribute("cat_list", catList);
		
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/Dashboard.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
     
		String category= request.getParameter("category");
		String election= request.getParameter("election");
		
		Integer electionId=Integer.parseInt(election);
		Integer categoryId=Integer.parseInt(category);
		
		//Integer catId=(Integer)request.getSession().getAttribute("category_id");
	//	List<Candidate> cList3=cs.getCandidatebyElectionAndCategory(categoryId);
	//	request.setAttribute("canlist", cList3);
		
		HttpSession session = request.getSession(true);       
	   // session.setAttribute("election_id",electionId); 
	    session.setAttribute("category_id",categoryId);
		
		response.sendRedirect("ProcessVoting");
		
	}

}
