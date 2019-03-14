package com.ffi.model.utility;

public class Identifer {

	public String fqdn;

	public String id;

	public Identifer() {
		super();
	}

	public Identifer(String fqdn, String id) {
		super();
		this.fqdn = fqdn;
		this.id = id;
	}

	public String getFqdn() {
		return fqdn;
	}

	public void setFqdn(String fqdn) {
		this.fqdn = fqdn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Identifer [fqdn=" + fqdn + ", id=" + id + "]";
	}

}
