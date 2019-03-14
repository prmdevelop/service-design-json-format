package com.ffi.financial.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CURRENT_LIABILITY")
public class CurrentLiability extends Liability {

	private BalanceSheet balanceSheet;

	public CurrentLiability() {
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "balance_sheet_id")
	public BalanceSheet getBalanceSheet() {
		return balanceSheet;
	}

	public void setBalanceSheet(BalanceSheet balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

}
