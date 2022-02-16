package com.shipping.dao.crew;

import org.springframework.stereotype.Repository;

import com.shipping.model.crew.Crew;

import org.springframework.jdbc.core.JdbcTemplate;


@Repository("crewDao") 
public class CrewDaoJdbc implements CrewDao {
	private JdbcTemplate jdbcTemplate;
	  
	@Override
	public void add(Crew crew) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Crew crew) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Crew crew) {
		// TODO Auto-generated method stub

	}

	@Override
	public void get(Crew crew) {
		// TODO Auto-generated method stub

	}

}
