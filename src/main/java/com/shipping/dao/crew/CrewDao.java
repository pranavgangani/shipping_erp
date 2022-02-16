package com.shipping.dao.crew;

import com.shipping.model.crew.Crew;

public interface CrewDao {
	void add(Crew crew);
	void delete(Crew crew);
	void update(Crew crew);
	void get(Crew crew);

}
