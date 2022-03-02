package com.shipping.common;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.FLAG)
public class Flag {
	@Transient
	public static final String SEQUENCE_NAME = Collection.FLAG;
	
	@Id
	private ObjectId id;
	private String name, code, image, emoji, unicode;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	public String getUnicode() {
		return unicode;
	}
	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
	
	
	//private List<Certification> rankCertifications;
	//private List<VesselCertification> shipCertifications;
}
