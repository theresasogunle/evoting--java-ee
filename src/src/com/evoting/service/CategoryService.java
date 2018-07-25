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

/**
 * Session Bean implementation class PostService
 */
@Stateless
@LocalBean
public class CategoryService {

    /**
     * Default constructor. 
     */
    public CategoryService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "evoting")
    private EntityManager em;
    
    public void addCategory(Category p ,Integer electionId){
    	Election e= fetchElectionById(electionId);
    	p.setElection(e);
    	
    	em.persist(p);
    	
    	e.addCategory(p);
    }
    
    public Election fetchElectionById(Integer electionId){
    	Election el = em.find(Election.class, electionId);
    	return el;
    }
    public List<Category> getAllCategory(){
    	TypedQuery<Category> query=em.createQuery("SELECT c FROM Category c", Category.class);
    	List<Category> results=query.getResultList();
    	return results;
    }
    public Category fetchCategorybyId(Integer categoryId){
    	Category c= em.find(Category.class, categoryId);
    	return c;
    }
    public List<Candidate> fetchCandidates(Integer categoryId){
    	Category c= fetchCategorybyId(categoryId);
    	
    	List<Candidate> cList=c.getCandidates();
    	
    	return cList;
    }
    
}
