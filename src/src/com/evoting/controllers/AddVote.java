package com.evoting.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evoting.model.Candidate;
import com.evoting.model.Category;
import com.evoting.model.Election;
import com.evoting.model.Polls;
import com.evoting.model.Vote;
import com.evoting.model.Voter;
import com.evoting.service.CandidateService;
import com.evoting.service.ElectionService;
import com.evoting.service.VotesService;

/**
 * Servlet implementation class AddVote
 */
@WebServlet("/Vote")
public class AddVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @EJB
     ElectionService es;
     @EJB
     VotesService vs;
     @EJB
     CandidateService cs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVote() {
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
		//System.out.println("VOTER ID is"+voterId);
		
		Integer electionId=(Integer)request.getSession().getAttribute("id");
		//System.out.println("Election ID IS"+electionId);
		
		
		
		Election e=es.findElectionById(electionId);
		
		Integer canId=0;
		
	
		
		/*
		try{
		List<Category> cList=e.getCats();
		 
		for(Category c: cList){
			String scatId=request.getParameter("category");
			Integer catId= Integer.parseInt(scatId);
			System.out.println("CATEGORY ID of  "+c.getName().toUpperCase()+"is"+catId );	
			List<Candidate> can=c.getCandidates();
			
			for(Candidate cs: can){
				String scanId=request.getParameter(""+cs.getId());
				 canId=Integer.parseInt(scanId);
				System.out.println(cs.getNameOfCandidates().toUpperCase()+": "+canId );	
			}
			
		}
		}catch(Exception ex){System.out.println("ProcessVoting: Error handling submitted vote -> "+ ex.getMessage());}
		
		
		*/
		Election el=null;
		Candidate cc= null;
		try{
			List<Category> cList=e.getCats();
			for(Category c: cList){
				String scanId=request.getParameter(""+c.getId());
				 canId=Integer.parseInt(scanId);
				 
				System.out.println(c.getName().toUpperCase()+": "+canId );	
				Vote v= new Vote();
				
				
				 cc=vs.fetchCandidateById(canId);
				v.setCandidate(cc);
				
				 el= vs.fetchElectionById(electionId);
				v.setElection(el);
				
				Voter vt= vs.fetchVoterById(voterId);
				v.setVoter(vt);
				
			
			vs.addVotes(v);
			
			el.addVotes(v);
			cc.addVotes(v);
			vt.addVotes(v);
			}
		}catch(Exception ex){System.out.println("ProcessVoting: Error handling submitted vote -> "+ ex.getMessage());}
	
	Election ell= vs.fetchElectionById(electionId);
	List<Vote> vots= vs.getVotesByElection(ell);
	System.out.println("THERE ARE "+vots.size()+" Vote(s) IN THIS ELECTION");
	
	Candidate ccv= vs.fetchCandidateById(canId);
	List<Vote> votesc=vs.getVotesByCandidate(ccv);
    List<Candidate> cList= cs.getCandidates();
    
   // System.out.println(cList.getNameOfCandidates()+ " HAS " +votesc.size()+ " VOTES ");
		
			for( Candidate c: cList){
				
					System.out.println(ccv.getNameOfCandidates()+ " HAS " +votesc.size()+ " VOTES ");
				
				
			}
		
		
		
		
	  //  Integer votes= vs.getVotes(electionId);
	 //   System.out.println(el.getNameOfElection()+ " HAS " +votes+ " VOTES ");
	}

}
