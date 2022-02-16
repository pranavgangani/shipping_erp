package com.shipping.dao.crew;

import org.springframework.stereotype.Repository;

import com.shipping.model.crew.Crew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository("crewDao")
public class CrewDaoJdbc implements CrewDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void add(Crew crew) {
		jdbcTemplate.update("insert into crew(name, price) values(?,?)", crew.getCrewId(), crew.getfName());
	}

	@Override
	public void delete(Crew filterCrew) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Crew filterCrew) {
		// TODO Auto-generated method stub

	}

	@Override
	public Crew get(Crew filterCrew) {
		/*
		 * return jdbcTemplate.query("select * from books where id = ?", new Object[] {
		 * filterCrew.getCrewId() }, (rs, rowNum) -> { Crew crew = new Crew(); });
		 */
		return null;
	}

	@Override
	public List<Crew> getFilteredList(Crew filterCrew) {
		/*
		 * return
		 * jdbcTemplate.query("select * from books where name like ? and price <= ?",
		 * new Object[] { "%" + filterCrew.getfName() + "%", filterCrew }, (rs, rowNum)
		 * -> { Crew crew = new Crew(); });
		 */
		return null;
	}

}
