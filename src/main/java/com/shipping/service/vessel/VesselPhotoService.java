package com.shipping.service.vessel;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shipping.dao.vessel.VesselPhotoRepository;
import com.shipping.model.vessel.VesselOwnerPhoto;
import com.shipping.model.vessel.VesselPhoto;
import com.shipping.service.common.SequenceGeneratorService;

@Service
public class VesselPhotoService {
	@Autowired
	private VesselPhotoRepository photoDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;

	public VesselPhoto getPhoto(long id) {
		return photoDao.findById(id).get();
	}

	public long addPhoto(VesselPhoto photo, MultipartFile file) throws IOException {
		photo.setId(sequenceGenerator.generateSequence(VesselPhoto.SEQUENCE_NAME));
		photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		photo = photoDao.insert(photo);
		return photo.getId();
	}
}
