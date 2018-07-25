package com.evoting.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Votes
 *
 */
@Entity

public class Vote implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Vote() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	  @JoinColumn(name="candidate_id" , referencedColumnName="id")
	  @ManyToOne(optional=false )
	  private Candidate candidate;
    
    @JoinColumn(name="election_id" , referencedColumnName="id")
	@ManyToOne(optional=false )
    private Election election;
    
    @JoinColumn(name="voter_id" , referencedColumnName="id")
   	@ManyToOne(optional=false )
     private Voter voter;
       
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	

    
   
}
