package com.luv2code.bugtracking.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="bug_information")
public class BugInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="bug_summary")
	private String bugSummary;
	
	@Column(name="bug_detail")
	@NotNull(message="is required")
	private String bugDetail;
	
	@Column(name="bug_resolver")
	private String bugResolver;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getBugSummary() {
		return bugSummary;
	}

	public void setBugSummary(String bugSummary) {
		this.bugSummary = bugSummary;
	}

	public String getBugDetail() {
		return bugDetail;
	}

	public void setBugDetail(String bugDetail) {
		this.bugDetail = bugDetail;
	}

	public String getBugResolver() {
		return bugResolver;
	}

	public void setBugResolver(String bugResolver) {
		this.bugResolver = bugResolver;
	}
	
	public String toString() {
		return bugSummary + " " + bugResolver;
	}
	
}
