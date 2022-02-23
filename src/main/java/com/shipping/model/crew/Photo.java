package com.shipping.model.crew;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Photo")
public class Photo {
    
    @Id
    private String id;
    
    private long crewId;
    
    private String title;
         
    private Binary image;

    public Photo(long crewId, String title) {
        super();
        this.crewId = crewId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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