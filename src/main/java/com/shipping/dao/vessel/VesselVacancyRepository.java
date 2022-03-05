package com.shipping.dao.vessel;

import com.shipping.model.vessel.Vessel;
import com.shipping.model.vessel.VesselVacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VesselVacancyRepository extends MongoRepository<VesselVacancy, Long> {
    @Query("{'vacancyAttributes.minRankList': { $eq: 1 }}")
	public List<VesselVacancy> findVacanciesByRank(int rankId);

    @Query("{'vacancyAttributes.minRankList': { $in: [?0] }}")
    public List<VesselVacancy> findVacanciesByRanks(List<Integer> rankIds);

    @Query("{$and :[{'vacancyAttributes.minRankList': { $in: [?0]}},{'vacancyAttributes.minGrossTonnage': {$gt>?1}}] }")
    public List<VesselVacancy> findVacanciesByAllAttr(List<Integer> rankIds);

    @Query("{'vacancyAttributes.minRankList': { $eq: 1 }}")
    public List<VesselVacancy> findVacanciesByVesselSubType(int rankId);

    @Query("{'vesselId': { $eq: ?0 }}")
    public List<VesselVacancy> findVacanciesByVessel(int vesselId);

    @Query("{'crewId': { $gt: 0 }}")
    public List<VesselVacancy> findFilledVacancies();

    @Query("{'crewId': { $eq: null }}")
    public List<VesselVacancy> findUnfilledVacancies();

}
