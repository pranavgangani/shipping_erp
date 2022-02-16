package com.shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shipping.model.crew.Crew;

@Service("crewService")
public class CrewService {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	/*
	 * @Autowired private NamedParameterJdbcTemplate jdbcTemplate;
	 */
	
	void addCrew(Crew crew) {
		   return jdbcTemplate.update(
	                "insert into crew(name, price) values(?,?)",
	                crew.g(), cre.getPrice());		
	}
	void deleteCrew(Crew filterCrew) {
		
	}
	void updateCrew(Crew filterCrew) {
		
	}
	Crew get(Crew filterCrew) {
		  return jdbcTemplate.queryForObject(
	                "select * from books where id = ?",
	                new Object[]{id},
	                (rs, rowNum) ->
	                        Optional.of(new Crew(
	                                rs.getLong("id"),
	                                rs.getString("name"),
	                                rs.getBigDecimal("price")
	                        ))
	        );
	}
	
	List<Crew> getFilteredList(Crew filterCrew) {
		 return jdbcTemplate.query(
	                "select * from books where name like ? and price <= ?",
	                new Object[]{"%" + name + "%", price},
	                (rs, rowNum) ->
	                        new Crew(
	                                rs.getLong("id"),
	                                rs.getString("name"),
	                                rs.getBigDecimal("price")
	                        )
	        );
	}
}
