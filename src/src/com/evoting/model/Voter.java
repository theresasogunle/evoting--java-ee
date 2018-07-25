package com.evoting.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Voter
 *
 */
@Entity
@NamedQuery(name="Voter.findById",query="SELECT v FROM Voter v WHERE v.id = :id")
public class Voter implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Voter() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String username;
	
	private String phone_number;
	
	private String password;
	
	@JoinColumn(name="election_fk" , referencedColumnName="id")
	@ManyToOne(optional=false )
	private Election election;

	
	 @OneToMany( mappedBy= "voter",cascade= {CascadeType.REMOVE}, fetch=FetchType.EAGER) 
	   private List<Vote> votes;
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
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

	@Override
	public String toString() {
		return "Voter [id=" + id + ", username=" + username + ", phone_number=" + phone_number + ", password="
				+ password + ", election=" + election + "]";
	}
	

	
}
