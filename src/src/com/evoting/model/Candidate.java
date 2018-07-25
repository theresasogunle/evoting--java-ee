package com.evoting.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Candidates
 *
 */
@NamedQuery(name = "Candidate.findById", query="SELECT c FROM Candidate c WHERE c.Id = :id")
@Entity

public class Candidate implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Candidate() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String nameOfCandidates;
	
	private String email;
	
	@JoinColumn(name="category_fk" , referencedColumnName="id")
    @ManyToOne(optional=false )
	private Category cat;
	@JoinColumn(name="election_fk" , referencedColumnName="id")
	@ManyToOne(optional=false )
	private Election electionId;
	
	@OneToMany( mappedBy= "candidate",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER) 
	private List<Vote> votes;
   
	
	private String phoneNumber;
	
	

	public Election getElectionId() {
		return electionId;
	}

	public void setElectionId(Election electionId) {
		this.electionId = electionId;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNameOfCandidates() {
		return nameOfCandidates;
	}

	public void setNameOfCandidates(String nameOfCandidates) {
		this.nameOfCandidates = nameOfCandidates;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	public void addVotes(Vote v ){
		if(!votes.contains(v))
			votes.add(v);
	}

	
	
	
	

	
	
   
}
