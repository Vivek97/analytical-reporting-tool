package com.himanshu.art.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "step_tb")
public class Step {

	@Id
	@GeneratedValue
	private int step_id;

	@Column(name = "step_keyword")
	private String keyword;

	@Column(name = "step_name")
	private String name;

	@Column(name = "step_line")
	private Long line;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "Step_Match", joinColumns ={@JoinColumn(name = "step_id")}, inverseJoinColumns ={ @JoinColumn(name = "match_id")})
	private Match match;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "Step_Result", joinColumns ={ @JoinColumn(name = "step_id")}, inverseJoinColumns = {@JoinColumn(name = "result_id")})
	private Result result;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Step_Embeddings", joinColumns = { @JoinColumn(name = "step_id") }, inverseJoinColumns = { @JoinColumn(name = "embedding_id") })
	private List<Embedding> embeddingList = new ArrayList<Embedding>();

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLine() {
		return line;
	}

	public void setLine(Long line) {
		this.line = line;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<Embedding> getEmbeddingList() {
		return embeddingList;
	}

	public void setEmbeddingList(Embedding embedding) {
		this.embeddingList.add(embedding);

	}

	public int getStep_id() {
		return step_id;
	}

	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}

}
