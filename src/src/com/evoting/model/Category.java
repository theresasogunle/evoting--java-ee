package com.evoting.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	 private String name;
	 
	 @JoinColumn(name="election_fk" , referencedColumnName="id")
	 @ManyToOne(optional=false )
	 private Election election;
     
	 @OneToMany( mappedBy= "cat",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER)
	 private List<Candidate> Candidates;
	 
	 


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}
	public void addCandidate(Candidate c ){
		if(!Candidates.contains(c))
			Candidates.add(c);
	}


	public List<Candidate> getCandidates() {
		return Candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		Candidates = candidates;
	}

	
		
}
