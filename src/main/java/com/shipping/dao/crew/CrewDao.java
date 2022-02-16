package com.shipping.dao.crew;

import java.util.List;

import com.shipping.model.crew.Crew;

public interface CrewDao {
	void add(Crew crew);
	void delete(Crew filterCrew);
	void update(Crew filterCrew);
	Crew get(Crew filterCrew);
	List<Crew> getFilteredList(Crew filterCrew);

}
