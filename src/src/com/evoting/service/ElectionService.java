package com.evoting.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.evoting.model.Candidate;
import com.evoting.model.Category;
import com.evoting.model.Election;
import com.evoting.model.Voter;

/**
 * Session Bean implementation class ElectionService
 */
@Stateless
@LocalBean
public class ElectionService {

    /**
     * Default constructor. 
     */
    public ElectionService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "evoting")
    private EntityManager em;
    
   public void addElection(Election e) {

		em.persist(e);
		
		
	}
   public Election findElectionById(Integer electionId)
   {
	   Election e=em.find(Election.class, electionId);
	   e.setId(electionId);
	   
	   return e;
   }
 
   public List<Candidate> getAllCandidates(Integer electionId)
   {
	
	  Election e=em.find(Election.class, electionId);
	  e.setId(electionId);
	List<Candidate> cList =e.getCandidates();
	// TypedQuery<Candidates> query=em.createQuery("SELECT c FROM Candidates c WHERE c.electionId.election_fk = ? 1 ", Candidates.class);
	//  query.setParameter(1, electionId);
//List<Candidates> results=query.getResultList(); 	
	 
	   return cList;
   }
   public Voter findVoterById( Integer voterId)
   {
	   Voter v= em.find(Voter.class, voterId);
	   return v;
   }
   
   
   
   public List<Category> getAllCategories(Integer electionId)
   {
	
	  Election e=em.find(Election.class, electionId);
	  e.setId(electionId);
	List<Category> catList =e.getCats();
	// TypedQuery<Candidates> query=em.createQuery("SELECT c FROM Candidates c WHERE c.electionId.election_fk = ? 1 ", Candidates.class);
	//  query.setParameter(1, electionId);
//List<Candidates> results=query.getResultList(); 	
	 
	   return catList;
   }
  
	public List<Election> getAllElections()
	{ 
		TypedQuery<Election> query=em.createQuery("SELECT e FROM Election e", Election.class);
    	List<Election> results=query.getResultList();
    	return results;
	}
    
}
