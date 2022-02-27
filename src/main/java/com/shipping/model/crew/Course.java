package com.shipping.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Course {
	@Id
	private long id;
	private List<Certification> certifications; 
	private List<License> licenses;
}
