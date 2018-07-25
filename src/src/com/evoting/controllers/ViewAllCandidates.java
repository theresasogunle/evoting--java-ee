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
import com.evoting.model.Election;
import com.evoting.service.CandidateService;
import com.evoting.service.ElectionService;

/**
 * Servlet implementation class ViewAllCandidates
 */
@WebServlet("/ViewAllCandidates")
public class ViewAllCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    CandidateService cs;
    @EJB
    ElectionService es;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Election> eList=(List<Election>) es.getAllElections();
		
		request.setAttribute("election_list", eList);
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/ViewAllCandidates.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		//Getting information about the Candidates 
		
		
	}

}
