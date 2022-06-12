package com.intuitbrains.dao.vessel;

import com.intuitbrains.model.vessel.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VesselVacancyRepository extends MongoRepository<Vacancy, Long> {
    @Query("{'vacancyAttributes.minRankList': { $eq: 1 }}")
	public List<Vacancy> findVacanciesByRank(int rankId);

    @Query("{'vacancyAttributes.minRankList': { $in: [?0] }}")
    public List<Vacancy> findVacanciesByRanks(List<Integer> rankIds);

    @Query("{$and :[{'vacancyAttributes.minRankList': { $in: [?0]}},{'vacancyAttributes.minGrossTonnage': {$gt>?1}}] }")
    public List<Vacancy> findVacanciesByAllAttr(List<Integer> rankIds);

    @Query("{'vacancyAttributes.minRankList': { $eq: 1 }}")
    public List<Vacancy> findVacanciesByVesselSubType(int rankId);

    @Query("{'vesselId': { $eq: ?0 }}")
    public List<Vacancy> findVacanciesByVessel(long vesselId);

    @Query("{'crewId': { $gt: 0 }}")
    public List<Vacancy> findFilledVacancies();

    @Query("{'crewId': { $eq: null }}")
    public List<Vacancy> findUnfilledVacancies();

    @Query("{'filledByCrewId': { $eq: ?0 }}")
    public Vacancy findVacancyByCrewId(long crewId);

}
