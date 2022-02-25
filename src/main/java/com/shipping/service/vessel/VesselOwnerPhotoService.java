package com.shipping.service.vessel;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shipping.dao.vessel.VesselOwnerPhotoRepository;
import com.shipping.model.vessel.Vessel;
import com.shipping.model.vessel.VesselOwnerPhoto;
import com.shipping.service.common.SequenceGeneratorService;

@Service
public class VesselOwnerPhotoService {
	@Autowired
	private VesselOwnerPhotoRepository photoDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	public VesselOwnerPhoto getPhoto(long id) {
		return photoDao.findById(id).get();
	}

	public long addPhoto(VesselOwnerPhoto photo, MultipartFile file) throws IOException {
		photo.setId(sequenceGenerator.generateSequence(VesselOwnerPhoto.SEQUENCE_NAME));
		photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		photo = photoDao.insert(photo);
		return photo.getId();
	}
}
