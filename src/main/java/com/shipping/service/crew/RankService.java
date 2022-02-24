package com.shipping.service.crew;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.dao.crew.RankRepository;
import com.shipping.model.crew.Rank;
import com.shipping.service.common.SequenceGeneratorService;

@Service("rankService")
public class RankService {
	@Autowired
	private RankRepository rankDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	public void addRank(Rank rank) {
		rank.setId(sequenceGenerator.generateSequence(Rank.SEQUENCE_NAME));
		rankDao.insert(rank);
	}
	
	public void deleteRank(Rank filterRank) {
		rankDao.delete(filterRank);
	}
	
	public void updateRank(Rank filterRank) {
		rankDao.save(filterRank);
	}
	
	public List<Rank> getRankList(Rank filterRank) {
		return rankDao.findAll();
	}
	
	public Optional<Rank> get(Rank filterRank) {
		return rankDao.findById((int) filterRank.getId());
	}
}
