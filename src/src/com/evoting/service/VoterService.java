package com.evoting.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.evoting.model.Candidate;
import com.evoting.model.Election;
import com.evoting.model.Voter;

/**
 * Session Bean implementation class VoterService
 */
@Stateless
@LocalBean
public class VoterService {

    /**
     * Default constructor. 
     */
    public VoterService() {
        // TODO Auto-generated constructor stub
    }
   @PersistenceContext(unitName = "evoting")
   private EntityManager em;
   
   public void addVoter(Voter v, Integer electionId)
   {
	   Election el= fetchElectionById(electionId);
	   v.setElection(el);
	   
	  em.persist(v);
	  
	  el.addVoter(v);
   }
  public List<Candidate> getCandidatesByElectionId(Integer electionId)
  {
	  Election el= fetchElectionById(electionId);
	  List<Candidate> cList=  el.getCandidates();
	  System.out.println("Candidates Pool Size: "+cList.size());
	  return  cList;
  }
   public Voter getSingleVoter()
	{ 
		TypedQuery<Voter> query=em.createQuery("SELECT v FROM Voter v", Voter.class);
   	Voter results= query.getSingleResult();
   	return results;
	}
   
   public Election fetchElectionById(Integer electionId){
   	Election el = em.find(Election.class, electionId);
   	return el;
   }
   public List<Voter> getAllVoters()
	{ 
		TypedQuery<Voter> query=em.createQuery("SELECT v FROM Voter v", Voter.class);
		List<Voter> results=query.getResultList();
		System.out.println("Voter Pool Size: "+results.size());
		return results;
	}
   public Integer validate(String username, String password)
   {
	   Integer flag= -1;
	   try{
	   String select = "SELECT v FROM Voter v WHERE v.username=:username and v.password=:password";

	   Query query = em.createQuery(select);
	   query.setParameter("username", username);
	   query.setParameter("password", password);
	 
	   Voter   v= (Voter) query.getSingleResult();
	  
	   if(v== null)
	   {
		  return flag= -1;
	   }
	   else{
		Integer voterId=   v.getId();
		   System.out.println(v);
		 
		 return flag= v.getElection().getId();
		   
		   
	   }
	  }catch(NoResultException ex){System.out.println("Invalid user!");}
	  
	  return flag;
	 
   }
   public List<Candidate> getCandidatesById(Integer electionId)
   {
	   Election e=em.find(Election.class, electionId);
	   List<Candidate> cList =e.getCandidates();
	   return cList;
   }
  
}
