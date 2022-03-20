package com.intuitbrains.model.vessel;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.intuitbrains.common.Collection;

@Document(collection = Collection.VESSEL_OWNER_PHOTO)
public class VesselOwnerPhoto {
	@Transient
	public static final String SEQUENCE_NAME = Collection.VESSEL_OWNER_PHOTO;
	
    @Id
    private long id;
    
    private long vesselOwnerId;
    private String title;
         
    private Binary image;

    public VesselOwnerPhoto(long vesselOwnerId, String title) {
        super();
        this.vesselOwnerId = vesselOwnerId;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public long getVesselOwnerId() {
		return vesselOwnerId;
	}

	public void setVesselOwnerId(long vesselOwnerId) {
		this.vesselOwnerId = vesselOwnerId;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ",  vesselOwnerId=" + vesselOwnerId + ", title=" + title + ", image=" + image + "]";
	}


}