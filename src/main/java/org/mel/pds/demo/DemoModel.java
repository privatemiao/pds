package org.mel.pds.demo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.pds.commons.AbstractModel;

public class DemoModel extends AbstractModel {
	private Person person;

	public DemoModel() {
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
