package com.ffi.financial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="LIABILITY")
@Inheritance(strategy=InheritanceType.JOINED)
public class Liability {
	
	private int id;
	private String reportedLabel;
	private String labelType;
	private Double value;
	private String version;
	private String isExpired;
	
	public Liability() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "reported_label")
	public String getReportedLabel() {
		return reportedLabel;
	}

	public void setReportedLabel(String reportedLabel) {
		this.reportedLabel = reportedLabel;
	}

	@Column(name = "lable_type")
	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	@Column(name = "value")
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Column(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "IsExpired")
	public String getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}
	
	@Override
	public String toString() {
		return "CurrentLiability [id=" + id + ", reportedLabel=" + reportedLabel + ", labelType=" + labelType
				+ ", value=" + value + ", version=" + version + ", isExpired=" + isExpired + "]";
	}
}
