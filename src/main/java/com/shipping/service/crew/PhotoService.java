package com.shipping.service.crew;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shipping.dao.crew.PhotoRepository;
import com.shipping.model.crew.CrewPhoto;
import com.shipping.model.vessel.VesselPhoto;
import com.shipping.service.common.SequenceGeneratorService;


@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoDao;
    @Autowired
	private SequenceGeneratorService sequenceGenerator;

    public CrewPhoto getPhoto(long id) {
        return photoDao.findById(id).get();
    }

    public long addPhoto(CrewPhoto photo, MultipartFile file) throws IOException {   
    	photo.setId(sequenceGenerator.generateSequence(CrewPhoto.SEQUENCE_NAME));
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoDao.insert(photo);
        return photo.getId();
    }
}