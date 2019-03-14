package com.ffi.financial.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "FINANCIAL_MASTER")
public class Financial {

	public int id;
	public int year;
	public Date createdDate;
	public Date lastModifiedDate;
	public String source;
	public Company company;
	public Set<BalanceSheet> balanceSheets;

	public Financial() {
	}

	public Financial(int id,int year, Date createdDate, Date lastModifiedDate, String source) {
		this.id = id;
		this.year = year;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.source = source;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	@Column(name = "feed_source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "financialMaster", cascade = CascadeType.ALL)
	public Set<BalanceSheet> getBalanceSheets() {
		return balanceSheets;
	}

	public void setBalanceSheets(Set<BalanceSheet> balanceSheets) {
		this.balanceSheets = balanceSheets;
	}

	@Override
	public String toString() {
		return "FinancialMaster [id=" + id + ", year=" + year + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", source=" + source + ", balanceSheets=" + balanceSheets + "]";
	}


}
