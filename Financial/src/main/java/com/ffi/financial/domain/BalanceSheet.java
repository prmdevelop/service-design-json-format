package com.ffi.financial.domain;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "BALANCE_SHEET")
public class BalanceSheet {

	private int id;
	private String currencyReported;
	private String currencyConverted;
	private String version;
	private Double totalCurrentAsset;
	private Double totalNonCurrentAsset;
	private Double totalAsset;
	private Double totalCurrentLiability;
	private Double totalNonCurrentLiability;
	private Double totalLibility;
	private Double totalEquity;
	private Double netWorth;
	private Financial financialMaster;
	private Set<CurrentAsset> currentAssets;
	private Set<NonCurrentAsset> nonCurrentAssets;
	private Set<CurrentLiability> currentLiability;
	private Set<NonCurrentLiability> nonCurrentLiability;

	public BalanceSheet() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "currency_reported")
	public String getCurrencyReported() {
		return currencyReported;
	}

	public void setCurrencyReported(String currencyReported) {
		this.currencyReported = currencyReported;
	}

	@Column(name = "currency_converted")
	public String getCurrencyConverted() {
		return currencyConverted;
	}

	public void setCurrencyConverted(String currencyConverted) {
		this.currencyConverted = currencyConverted;
	}

	@Column(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Column(name = "total_current_asset")
	public Double getTotalCurrentAsset() {
		return totalCurrentAsset;
	}

	public void setTotalCurrentAsset(Double totalCurrentAsset) {
		this.totalCurrentAsset = totalCurrentAsset;
	}

	@Column(name = "total_non_current_asset")
	public Double getTotalNonCurrentAsset() {
		return totalNonCurrentAsset;
	}

	public void setTotalNonCurrentAsset(Double totalNonCurrentAsset) {
		this.totalNonCurrentAsset = totalNonCurrentAsset;
	}
	
	@Column(name = "total_asset")
	public Double getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(Double totalAsset) {
		this.totalAsset = totalAsset;
	}

	@Column(name = "total_current_liability")
	public Double getTotalCurrentLiability() {
		return totalCurrentLiability;
	}

	public void setTotalCurrentLiability(Double totalCurrentLiability) {
		this.totalCurrentLiability = totalCurrentLiability;
	}

	@Column(name = "total_non_current_liability")
	public Double getTotalNonCurrentLiability() {
		return totalNonCurrentLiability;
	}

	public void setTotalNonCurrentLiability(Double totalNonCurrentLiability) {
		this.totalNonCurrentLiability = totalNonCurrentLiability;
	}
	
	@Column(name = "total_liability")
	public Double getTotalLibility() {
		return totalLibility;
	}

	public void setTotalLibility(Double totalLibility) {
		this.totalLibility = totalLibility;
	}
	
	@Column(name = "total_Equity")
	public Double getTotalEquity() {
		return totalEquity;
	}

	public void setTotalEquity(Double totalEquity) {
		this.totalEquity = totalEquity;
	}

	@Column(name = "net_worth")
	public Double getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(Double netWorth) {
		this.netWorth = netWorth;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "financial_id")
	public Financial getFinancialMaster() {
		return financialMaster;
	}

	public void setFinancialMaster(Financial financialMaster) {
		this.financialMaster = financialMaster;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL)
	public Set<CurrentAsset> getCurrentAssets() {
		return currentAssets;
	}

	public void setCurrentAssets(Set<CurrentAsset> currentAssets) {
		this.currentAssets = currentAssets;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL)
	public Set<NonCurrentAsset> getNonCurrentAssets() {
		return nonCurrentAssets;
	}

	public void setNonCurrentAssets(Set<NonCurrentAsset> nonCurrentAssets) {
		this.nonCurrentAssets = nonCurrentAssets;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL)
	public Set<CurrentLiability> getCurrentLiability() {
		return currentLiability;
	}

	public void setCurrentLiability(Set<CurrentLiability> currentLiability) {
		this.currentLiability = currentLiability;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL)
	public Set<NonCurrentLiability> getNonCurrentLiability() {
		return nonCurrentLiability;
	}

	public void setNonCurrentLiability(Set<NonCurrentLiability> nonCurrentLiability) {
		this.nonCurrentLiability = nonCurrentLiability;
	}

	@Override
	public String toString() {
		return "BalanceSheet [id=" + id + ", currencyReported=" + currencyReported
				+ ", currencyConverted=" + currencyConverted + ", version=" + version + ", totalCurrentAsset="
				+ totalCurrentAsset + ", totalNonCurrentAsset=" + totalNonCurrentAsset + ", totalCurrentLiability="
				+ totalCurrentLiability + ", totalNonCurrentLiability=" + totalNonCurrentLiability + ", currentAssets="
				+ currentAssets + ", nonCurrentAssets=" + nonCurrentAssets + ", currentLiability=" + currentLiability
				+ ", nonCurrentLiability=" + nonCurrentLiability + "]";
	}
}
