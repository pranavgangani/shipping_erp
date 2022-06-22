package com.intuitbrains.model.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class DurationType {

	public final static DurationType MINS = new DurationType(1, "Minutes");
	public final static DurationType HOURS = new DurationType(2, "Hours");
	public final static DurationType DAYS = new DurationType(3, "Days");
	public final static DurationType WEEKS = new DurationType(4, "Weeks");
	public final static DurationType MONTHS = new DurationType(5, "Months");
	public final static DurationType YEARS = new DurationType(6, "Years");

	private long id;
	private String typeName;

	public DurationType() {
	}

	DurationType(long id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	public long getId() {
		return id;
	}

	public String getTypeName() {
		return typeName;
	}

	public static List<DurationType> getList() {
		return new ArrayList<>(Arrays.asList(MINS, HOURS, DAYS, MONTHS, WEEKS, YEARS));
	}

	public static DurationType createFromId(int typeId) {
		return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DurationType that = (DurationType) o;
		return id == that.id && Objects.equals(typeName, that.typeName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, typeName);
	}
}
