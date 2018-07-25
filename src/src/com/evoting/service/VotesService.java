package com.evoting.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.evoting.model.Candidate;
import com.evoting.model.Election;
import com.evoting.model.Vote;
import com.evoting.model.Voter;


/**
 * Session Bean implementation class VotesService
 */
@Stateless
@LocalBean

public class VotesService {

    /**
     * Default constructor. 
     */
    public VotesService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "evoting")
    private EntityManager em;
    
    
    
    public void addVotes(Vote v){
    	
        	em.persist(v);	
    }
    public Election fetchElectionById(Integer electionId){
       	Election el = em.find(Election.class, electionId);
       	return el;
       }
    public Candidate fetchCandidateById(Integer candidateId)
    {
 	   Candidate c=em.find(Candidate.class, candidateId);
 	  
 	   return c;
    }
    public Voter fetchVoterById(Integer voterId)
    {
 	   Voter v=em.find(Voter.class, voterId);
 	   return v;
    }
    public List<Vote> getVotesByElection(Election e){
		List<Vote> v=e.getVotes();
		return v;
	}
    public List<Vote> getVotesByCandidate(Candidate c){
		List<Vote> v=c.getVotes();
		return v;
	}
}
