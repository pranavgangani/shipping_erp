package com.shipping.service.crew;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shipping.dao.crew.PhotoRepository;
import com.shipping.model.crew.Photo;


@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoDao;

    public Photo getPhoto(String id) {
        return photoDao.findById(id).get();
    }

    public String addPhoto(Photo photo, MultipartFile file) throws IOException {        
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoDao.insert(photo);
        return photo.getId();
    }
}