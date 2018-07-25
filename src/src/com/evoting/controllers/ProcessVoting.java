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

import com.evoting.model.Candidate;
import com.evoting.model.Category;
import com.evoting.model.Election;
import com.evoting.model.Voter;
import com.evoting.service.CandidateService;
import com.evoting.service.CategoryService;
import com.evoting.service.ElectionService;

import com.evoting.service.VoterService;

/**
 * Servlet implementation class ProcessVoting
 */
@WebServlet("/ProcessVoting")
public class ProcessVoting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ElectionService es;
	@EJB
	VoterService vs;
	@EJB
	CategoryService cats;
	@EJB
	CandidateService cs;
	Election e;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessVoting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/ViewAllCandidates.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Integer voterId=(Integer) request.getSession().getAttribute("voter");
	//	System.out.println(voterId);
		
		
		
		Voter v=es.findVoterById(voterId);
		request.setAttribute("voter", v);
		
		
	
		Integer electionId=(Integer)request.getSession().getAttribute("id");
		System.out.println(electionId);
		Election ess=es.findElectionById(electionId);
		request.setAttribute("election", ess);

	
		
		
		
	
		
		
	
		
		doGet(request, response);
		
		
	}

}
