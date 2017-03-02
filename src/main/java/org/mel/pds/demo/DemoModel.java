package org.mel.pds.demo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.pds.commons.AbstractModel;
import org.mel.pds.commons.GenericMethod;

public class DemoModel extends AbstractModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Person person;

	private Person originalPerson;

	public DemoModel() {
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		this.originalPerson = (Person) GenericMethod.depthClone(person);
	}

	public Person getOriginalPerson() {
		return originalPerson;
	}

	public void setOriginalPerson(Person originalPerson) {
		this.originalPerson = originalPerson;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getStatus() {
		if (person == null) {
			return "virgin";
		}

		if (person.equals(originalPerson)) {
			return "clean";
		} else {
			return "dirty";
		}
	}

}
