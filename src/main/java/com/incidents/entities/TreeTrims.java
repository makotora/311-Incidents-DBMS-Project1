package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TREE_TRIMS")
public class TreeTrims implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;

	@Column(name = "LOCATION", length = 200)
	private String location;

	public TreeTrims() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeTrims(Integer id, Incident incident, String location) {
		super();
		this.id = id;
		this.incident = incident;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TreeTrims [id=" + id + ", incident=" + incident + ", location=" + location + "]";
	}

}
