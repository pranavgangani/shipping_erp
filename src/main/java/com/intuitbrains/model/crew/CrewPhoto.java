package com.intuitbrains.model.crew;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.intuitbrains.common.Collection;

@Document(collection = Collection.CREW_PHOTO)
public class CrewPhoto {
	@Transient
	public static final String SEQUENCE_NAME = Collection.CREW_PHOTO;
	
    @Id
    private long id;    
    private long crewId;   
    private String title;         
    private Binary image;

    public CrewPhoto(long crewId, String title) {
        super();
        this.crewId = crewId;
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

    public long getCrewId() {
		return crewId;
	}

	public void setCrewId(long crewId) {
		this.crewId = crewId;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", crewId=" + crewId + ", title=" + title + ", image=" + image + "]";
	}


}