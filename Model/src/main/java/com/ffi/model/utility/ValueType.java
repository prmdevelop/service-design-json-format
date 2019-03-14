package com.ffi.model.utility;

public class ValueType<T> {

	public String property;

	public T data;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ValueType [property=" + property + ", data=" + data + "]";
	}
}
