package com.ffi.financial.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "COMPANY")
public class Company {

	private int id;
	private String name;
	private String naics;
	private String sic;
	private String businessSegment;
	private String businessType;
	private Date createdDate;
	private Date lastModifiedDate;
	private String createdBy;
	private Set<Financial> financial;

	public Company() {}
	
	public Company(int id, String name, String naics, String sic, String businessSegment, String businessType,
			Date createdDate, Date lastModifiedDate, String createdBy) {
		this.id = id;
		this.name = name;
		this.naics = naics;
		this.sic = sic;
		this.businessSegment = businessSegment;
		this.businessType = businessType;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "naics")
	public String getNaics() {
		return naics;
	}

	public void setNaics(String naics) {
		this.naics = naics;
	}

	@Column(name = "sic")
	public String getSic() {
		return sic;
	}

	public void setSic(String sic) {
		this.sic = sic;
	}

	@Column(name = "business_segment")
	public String getBusinessSegment() {
		return businessSegment;
	}

	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}

	@Column(name = "business_type")
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "last_modified_date")
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	public Set<Financial> getFinancial() {
		return financial;
	}

	public void setFinancial(Set<Financial> financial) {
		this.financial = financial;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", naics=" + naics + ", sic=" + sic + ", businessSegment="
				+ businessSegment + ", businessType=" + businessType + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", createdBy=" + createdBy + ", financial="
				+ financial + "]";
	}
}
