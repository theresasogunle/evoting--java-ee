package com.evoting.service;

import java.util.HashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import com.evoting.model.Candidate;
import com.evoting.model.Category;
import com.evoting.model.Election;


/**
 * Session Bean implementation class CandidatesService
 */
@Stateless
@LocalBean
public class CandidateService {

    /**
     * Default constructor. 
     */
    public CandidateService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "evoting")
    private EntityManager em;
    Election el=null;
    public void addCandidate(Candidate c, Integer electionId, Integer categoryId) {
        Election el = 	fetchElectionById(electionId); 
       Category cat= fetchCategoryById(categoryId);

     	c.setElectionId(el);
     	c.setCat(cat);
     	
     	em.persist(c);
     	
     	el.addCandidate(c);
    	cat.addCandidate(c);
     	
     	
     	
     	
    // el.setCandidates(candidates);

		
	}
   
    
    public Category fetchCategoryById(Integer categoryId)
    {
    	  Category c=em.find(Category.class, categoryId); //fetching post by Id
    	  return c;
    }
   
    public Election fetchElectionById(Integer electionId){
    	Election el = em.find(Election.class, electionId);
    	return el;
    }
    
    public List<Candidate> getCandidates()
    {
    	TypedQuery<Candidate> query=em.createQuery("SELECT c FROM Candidate c", Candidate.class);
    	List<Candidate> results=query.getResultList();
    	
    	return results;
    	
    	
    }
    /*
    public List<Candidate> getCandidatebyElectionAndCategory( Integer categoryId)
    {
    	
    	Category c=fetchCategoryById(categoryId);
    	
    	
    	List<Candidate> cList= c.getCandidates();
    	
    	return cList;
    }
   */
    
}
