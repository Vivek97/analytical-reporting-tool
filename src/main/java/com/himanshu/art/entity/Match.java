package com.himanshu.art.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "match_tb")
public class Match {

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Match_Arguments", joinColumns = { @JoinColumn(name = "match_id") }, inverseJoinColumns = { @JoinColumn(name = "arguments_id") })
	private List<Arguments> arguments = new ArrayList<Arguments>();

	@Column(name = "match_location ")
	private String location;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "match_id")
	private int match_id;

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	
	public List<Arguments> getArguments() {
		return arguments;
	}

	public void setArguments(Arguments arguments) {
		this.arguments.add(arguments);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
