package com.shipping.service.crew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shipping.dao.crew.CrewDao;
import com.shipping.model.crew.Crew;

@Service("crewService")
public class CrewService {
	@Autowired
	private CrewDao crewDao;
	
	public void addCrew(Crew crew) {
		crewDao.insert(crew);		  	
	}
	
	public void deleteCrew(Crew filterCrew) {
		crewDao.delete(filterCrew);
	}
	
	public void updateCrew(Crew filterCrew) {
		crewDao.save(filterCrew);
	}
	
	public List<Crew> getCrewList(Crew filterCrew) {
		return crewDao.findAll();
	}
	
}
