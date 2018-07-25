package com.evoting.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evoting.model.Election;
import com.evoting.model.Polls;
import com.evoting.service.ElectionService;
import com.evoting.service.VotesService;

/**
 * Servlet implementation class ViewResult
 */
@WebServlet("/ViewResult")
public class ViewResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	VotesService vs;
    
	@EJB
	ElectionService es;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Integer voterId=(Integer) request.getSession().getAttribute("voter");
		System.out.println("VOTER ID is"+voterId);
		
		Integer electionId=(Integer)request.getSession().getAttribute("id");
		System.out.println("Election ID IS"+electionId);
		
		Integer canId=(Integer)request.getSession().getAttribute("candidate_id");
		System.out.println("Candidate ID IS"+canId);
		
		//Election el=es.findElectionById(electionId);
		//Integer vots= vs.getVotesByElection(el);
		//System.out.println(vots);
	
		
	}

}
