package com.shipping.dao.vessel;

import com.shipping.model.vessel.Vessel;
import com.shipping.model.vessel.VesselVacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VesselVacancyRepository extends MongoRepository<VesselVacancy, Long> {
    @Query("{'rankId': { $eq: ?0 }}")
	public List<VesselVacancy> findVacanciesByRank(int rankId);

    @Query("{'vesselId': { $eq: ?0 }}")
    public List<VesselVacancy> findVacanciesByVessel(int vesselId);

    @Query("{'crewId': { $gt: 0 }}")
    public List<VesselVacancy> findFilledVacancies();

    @Query("{'crewId': { $eq: null }}")
    public List<VesselVacancy> findUnfilledVacancies();

}
