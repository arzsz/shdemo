package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "person.all", query = "Select p from Person p"),
		@NamedQuery(name = "person.byPin", query = "Select p from Person p where p.pin = :pin") })
public class Person {

	private Long id;
	private String firstName = "unknown";
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Camera> getCameras() {
		return cameras;
	}

	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}

	private String pin = "";
	private Date registrationDate = new Date();

	private List<Camera> cameras = new ArrayList<Camera>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(unique = true, nullable = false)
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Temporal(TemporalType.DATE)
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
