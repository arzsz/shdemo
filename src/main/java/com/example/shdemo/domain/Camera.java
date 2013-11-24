package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "camera.all", query = "Select c from Camara c")
public class Camera {

	private int idCam;
	private String name;
	private String model;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdCam() {
		return idCam;
	}

	public void setIdCam(int idCam) {
		this.idCam = idCam;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}