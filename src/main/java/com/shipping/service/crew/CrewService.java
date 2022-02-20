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
	
	void addCrew(Crew crew) {
		crewDao.add(crew);		  	
	}
	
	void deleteCrew(Crew filterCrew) {
		crewDao.delete(filterCrew);
	}
	
	void updateCrew(Crew filterCrew) {
		crewDao.update(filterCrew);
	}
	
	List<Crew> getCrewList(Crew filterCrew) {
		return crewDao.getFilteredList(filterCrew);
	}
	
}
