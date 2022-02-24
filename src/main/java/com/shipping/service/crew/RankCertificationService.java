package com.shipping.service.crew;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.dao.crew.RankCertificationRepository;
import com.shipping.model.crew.RankCertification;
import com.shipping.service.common.SequenceGeneratorService;

@Service("rankCertificationService")
public class RankCertificationService { 
	@Autowired
	private RankCertificationRepository rankCertDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	public void addCert(RankCertification cert) {
		cert.setId(sequenceGenerator.generateSequence(RankCertification.SEQUENCE_NAME));
		rankCertDao.insert(cert);
	}
	
	public void deleteCert(RankCertification filterCert) {
		rankCertDao.delete(filterCert);
	}
	
	public void updateCert(RankCertification filterCert) {
		rankCertDao.save(filterCert);
	}
	
	public List<RankCertification> getList(RankCertification filterCert) {
		return rankCertDao.findAll();
	}
	
	public Optional<RankCertification> get(RankCertification filterCert) {
		return rankCertDao.findById((int) filterCert.getId());
	}
}
