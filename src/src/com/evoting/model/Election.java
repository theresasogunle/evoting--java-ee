package com.evoting.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Elections
 *
 */
@Entity
@NamedQuery(name="Election.findById",query="SELECT e FROM Election e WHERE e.id = :id")
public class Election implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Election() {
		super();
	}
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   
   private String nameOfElection;
   
   private Integer numberOfCandidates;
   
   @Temporal(TemporalType.DATE)
  	private Date duration;

   
   @OneToMany( mappedBy= "electionId",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
   private List<Candidate> Candidates;
   
   @OneToMany( mappedBy= "election",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
   private List<Voter> voter;
   
   @OneToMany( mappedBy= "election",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER) 
   private List<Category> cats;
   
   @OneToMany( mappedBy= "election",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER) 
   private List<Vote> vote;
 
   public Date getDuration() {
	return duration;
}

public void setDuration(Date duration) {
	this.duration = duration;
}
public List<Candidate> getCandidates() {
	return Candidates;
}
public List<Voter> getVoter() {
	return voter;
}

public void setVoter(List<Voter> voter) {
	this.voter = voter;
}


public void addVotes(Vote v ){
	if(!vote.contains(v))
		vote.add(v);
}
public void addCategory(Category c){
	if(!cats.contains(c))
		cats.add(c);
}

public void addVoter(Voter v){
	if(!voter.contains(v))
		voter.add(v);
}
public void addCandidate(Candidate c ){
	if(!Candidates.contains(c))
		Candidates.add(c);
}

public void setCandidates(List<Candidate> candidates) {
	Candidates = candidates;
}
private String email;
   
  
   
   public Integer getNumberOfCandidates() {
	return numberOfCandidates;
}

public void setNumberOfCandidates(Integer numberOfCandidates) {
	this.numberOfCandidates = numberOfCandidates;
}

   
   public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNameOfElection() {
	return nameOfElection;
}

public void setNameOfElection(String nameOfElection) {
	this.nameOfElection = nameOfElection;
}

public List<Category> getCats() {
	return cats;
}

public void setCats(List<Category> cats) {
	this.cats = cats;
}

public List<Vote> getVotes() {
	return vote;
}

public void setVotes(List<Vote> votes) {
	this.vote = votes;
}










}
