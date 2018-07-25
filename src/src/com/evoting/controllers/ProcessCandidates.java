package com.evoting.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
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
 * Servlet implementation class ProcessCandidates
 */
@WebServlet("/ProcessCandidates")
public class ProcessCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    CandidateService cs;
    @EJB
    ElectionService  es;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessCandidates() {
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
		String nameOfCandidates=request.getParameter("nameOfCandidates");
		String email=request.getParameter("Email");
		String phoneNumber=request.getParameter("phoneNumber");
		
	
		
		Candidate c=new Candidate();
		
		c.setNameOfCandidates(nameOfCandidates);
		c.setEmail(email);
		c.setPhoneNumber(phoneNumber);
		
		
		String election_id1=request.getParameter("election_name");
		Integer election_id=Integer.parseInt(election_id1);
		
		Integer category_id=Integer.parseInt(request.getParameter("category"));
		
		cs.addCandidate(c,election_id, category_id);
	
		response.sendRedirect("RegisterCandidates");
	}

}
