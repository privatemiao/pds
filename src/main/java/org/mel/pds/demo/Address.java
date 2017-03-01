package org.mel.pds.demo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address {
	private String province;
	private String city;
	private String dist;
	private String street;

	public Address() {
	}

	public Address(String province, String city, String dist, String street) {
		this.province = province;
		this.city = city;
		this.dist = dist;
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
