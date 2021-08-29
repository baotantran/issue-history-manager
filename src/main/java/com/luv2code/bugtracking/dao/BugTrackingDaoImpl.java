package com.luv2code.bugtracking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.bugtracking.entity.BugInformation;

@Repository
public class BugTrackingDaoImpl implements BugTrackingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<BugInformation> getAllBug() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<BugInformation> query = currentSession.createQuery("from BugInformation", BugInformation.class);
		
		List<BugInformation> list = query.getResultList();
		
		return list;
	}


	@Override
	@Transactional
	public BugInformation getBugById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		BugInformation bugInformation = currentSession.get(BugInformation.class, id);
		
		return bugInformation;
	}


	@Override
	@Transactional
	public void saveBug(BugInformation bug) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(bug);
		
	}


	@Override
	@Transactional
	public void updateBug(BugInformation bug) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(bug);
		
	}

	
}
