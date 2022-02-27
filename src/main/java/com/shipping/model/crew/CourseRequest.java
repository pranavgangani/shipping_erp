package com.shipping.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.shipping.util.DateTime;

public class CourseRequest extends Request {
	@Id
	private long id;
	private String courseName, source, destination;
	private DateTime fromDate, toDate;
	private DateTime requestedDateTime;
	private String requestedBy;
	private List<Certification> couserCertifications;
	
	//Other dependencies
	private List<Certification> requiredCertifications;//Other Certs required for this Cert
	private List<Course> requiredCourses;//Other Courses required for this Cert
	private List<License> requiredLicenses;//Licenses required for this Cert	
}
