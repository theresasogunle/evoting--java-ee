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
import com.evoting.model.Election;
import com.evoting.model.Voter;
import com.evoting.service.CandidateService;
import com.evoting.service.ElectionService;
import com.evoting.service.VoterService;

/**
 * Servlet implementation class AddVoter
 */
@WebServlet("/AddVoter")
public class AddVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    ElectionService es;
    @EJB
    VoterService vs;
    @EJB
    CandidateService cs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVoter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Election> eList=es.getAllElections();
		request.setAttribute("election_list", eList);
		
		List<Candidate> cList= cs.getCandidates();
		request.setAttribute("candidates_list", cList);
		
		

		
		
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/AddVoter.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name=request.getParameter("name");
		String phone_number=request.getParameter("phone_number");
		String password=request.getParameter("password");
		
		
		Voter v= new Voter();
		v.setUsername(name);
		v.setPhone_number(phone_number);
		v.setPassword(password);
		Integer electionId=Integer.parseInt(request.getParameter("election"));
		
		
		vs.addVoter(v, electionId);
		Integer el=v.getElection().getId();
		Integer voterId=v.getId();
		HttpSession session = request.getSession(true);       
	    session.setAttribute("election_id",el); 
		session.setAttribute("voter", voterId);
		System.out.println(v);
	  
	    
		
		List<Candidate> cList=es.getAllCandidates(electionId);
		request.setAttribute("candidateslist", cList);
		
	
		
		
		
	}

}
