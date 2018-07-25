package com.evoting.model;

import java.util.List;

import javax.ejb.EJB;

import com.evoting.service.VotesService;

public class Polls {
 @EJB
 VotesService vs;
 
	public Integer getVotesByCategory(Integer electionId){
		Election e=vs.fetchElectionById(electionId);
		List<Category> catList=e.getCats();
		List<Vote> v= null;
		for(Category c: catList){
			 v=e.getVotes();
		}
		
		
		return v.size();
	}
	public Integer getVotesByVoter(Integer voterId){
		Voter vt= vs.fetchVoterById(voterId);
		List<Vote> v= vt.getVotes();
		return v.size();
	}
	public Integer getVotesByElection(Election e){
		List<Vote> v=e.getVotes();
		return v.size();
	}
	public Integer getVotesOfCandidate(Integer candidateId){
		Candidate c= vs.fetchCandidateById(candidateId);
		List<Vote> v=	c.getVotes();
	
		return v.size();
	}
	 
	
}
