package com.shipping.model.vessel;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.common.Collection;

@Document(collection = Collection.VESSEL_PHOTO)
public class VesselPhoto {
	@Transient
	public static final String SEQUENCE_NAME = Collection.VESSEL_PHOTO;
	
    @Id
    private long id;
    
    private long vesselId;
    
    private String title;
         
    private Binary image;

    public VesselPhoto(long vesselId, String title) {
        super();
        this.vesselId = vesselId;
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

    public long getVesselId() {
		return vesselId;
	}

	public void setVesselId(long vesselId) {
		this.vesselId = vesselId;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ",  vesselId=" + vesselId + ", title=" + title + ", image=" + image + "]";
	}


}