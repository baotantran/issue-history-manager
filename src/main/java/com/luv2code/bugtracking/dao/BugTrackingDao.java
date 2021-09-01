package com.luv2code.bugtracking.dao;

import java.util.*;

import com.luv2code.bugtracking.entity.BugInformation;

public interface BugTrackingDao {

	public List<BugInformation> getAllBug();
	
	public BugInformation getBugById(int id);
	
	public void saveBug(BugInformation bug);
	
	public void deleteBug(int id);
}
